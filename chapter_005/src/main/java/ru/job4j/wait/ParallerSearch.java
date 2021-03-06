package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@ThreadSafe
class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> texts;
    private volatile boolean finish = false;
    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.texts = exts;
    }

    private void findTextInFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(text)) {
                    synchronized (ParallelSearch.this) {
                        paths.add(file.getName());
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not found file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        Thread search = new Thread(() -> {
            Path path = Paths.get(root);
            try {
                Files.walkFileTree(path, new MyFileVisitor());
            } catch (IOException e) {
                e.printStackTrace();
            }
            finish = true;
        });

        Thread read = new Thread(() -> {
            String name = null;
            while (!finish) {
                synchronized (ParallelSearch.this) {
                    if (!files.isEmpty()) {
                        name = files.poll();
                        if (name != null) {
                            File file = new File(name);
                            findTextInFile(file);
                        }
                    } else {
                        try {
                            while (files.isEmpty()) {
                                ParallelSearch.this.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    synchronized Queue<String> result() {
        return this.files;
    }

    class MyFileVisitor extends SimpleFileVisitor {
        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            File newFile = new File(file.toString());
            for (String text : texts) {
                String exe = "." + text;
                if (newFile.toString().contains(exe)) {
                    synchronized (ParallelSearch.this) {
                        files.offer(newFile.getAbsolutePath());
                        ParallelSearch.this.notify();
                    }
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
