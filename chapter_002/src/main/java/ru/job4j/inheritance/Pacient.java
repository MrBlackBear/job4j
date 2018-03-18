package ru.job4j.inheritance;

public class Pacient {
    String name;
    String disease;

    Pacient(String name, String disease) {
        this.name = name;
        this.disease = disease;
    }

    public String getDisease() {
        return this.disease;
    }
}
