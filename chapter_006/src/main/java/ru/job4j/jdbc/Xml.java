package ru.job4j.jdbc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class Xml {
    private String url = "jdbc:postgresql://localhost:5432/shalobasov";
    private String user = "postgres";
    private String password = "123456";
    private int n;


    public Xml(int n) {
        this.n = n;
    }

    public void createXmlFile() {
        String fileNameXml = "1.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = db.newDocument();
        Element root = doc.createElement("entries");
        for (int i = 1; i <= n; i++) {
            Element entry = doc.createElement("entry");
            Element field = doc.createElement("field");
            field.setTextContent(Integer.toString(i));
            root.appendChild(entry);
            entry.appendChild(field);
        }
        if (doc != null)
            writeDocument(doc, fileNameXml);
    }

    public boolean insertData(int n) {
        boolean result = true;
        PreparedStatement statement = null;
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            statement = con.prepareStatement("INSERT INTO test (field) VALUES ('?');");
            for (int i = 1; i <= n; i++) {
                statement.setInt(i, i);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        ;
        return result;
    }


    public boolean createTable() {
        boolean result = true;
        Statement statement = null;
        ResultSet rs = null;
        String queryCreate = "CREATE TABLE test(field INTEGER PRIMARY KEY);";
        String queryDelete = "DROP TABLE test;";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData md = con.getMetaData();
            rs = md.getTables(null, null, "test", null);
            statement = con.createStatement();
            if (rs.next()) {
                statement.executeQuery(queryDelete);
                statement.executeQuery(queryCreate);
            } else {
                statement.executeQuery(queryCreate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeDocument(Document document, final String path) throws TransformerFactoryConfigurationError {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance().newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        Xml.loadDriver();
    }
}
