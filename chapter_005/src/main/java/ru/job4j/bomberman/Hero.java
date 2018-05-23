package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Hero implements Runnable {
    final private ReentrantLock[][] board;

    public Hero(ReentrantLock[][] board) {
        this.board = board;
    }


    @Override
    public void run() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                synchronized (board[i][j]) {
                    try {
                        board[i][j].tryLock(500, TimeUnit.MILLISECONDS);

                        board[i][j].unlock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
