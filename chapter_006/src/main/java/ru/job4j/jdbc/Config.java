package ru.job4j.jdbc;

public class Config {
    private String url = "jdbc:sqlite:D:/SqlLite/";

    public Config(String database) {
        url += database;
    }

    public String getUrl() {
        return url;
    }
}
