package ru.job4j.jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class StoreXML {
    private File target;

    StoreXML(File target) {
        this.target = target;
    }

    void save(List<XmlEntries.Entry> list, String url) throws Exception {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();) {
            statement.executeUpdate("drop table if exists entry");
            statement.executeUpdate("create table entry (field integer)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{

    }
}
