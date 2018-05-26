package ru.job4j.jdbc;

import java.sql.*;

public class StoreSQL {
    private int n;
    private Config config;

    public StoreSQL(Config config, int n) {
        this.config = config;
        this.n = n;
    }

    public void generate(int n) {
        try (Connection connection = DriverManager.getConnection(config.getUrl());
             PreparedStatement ps = connection.prepareStatement("INSERT INTO entry (field) VALUES ('?');");
             Statement statement = connection.createStatement();) {
            statement.executeUpdate("drop table if exists entry");
            statement.executeUpdate("create table entry (field integer)");
            for (int i = 1; i <= n; i++) {
                ps.setInt(1, i);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
