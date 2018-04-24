package ru.job4j;

import java.util.ArrayList;
import java.util.Arrays;

public class Org {
    private ArrayList<String> departments = new ArrayList<>();

    public void add(String nameOfDepartment) {
        departments.add(nameOfDepartment);
    }

    public void showDepartments() {
        System.out.println(Arrays.toString(departments.toArray()));
    }

    public ArrayList<String> get(){
        return departments;
    }
}
