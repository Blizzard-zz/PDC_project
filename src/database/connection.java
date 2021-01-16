package database;

import java.sql.*;


public class connection {
    Connection connection;
    public Statement statement;

    String url = "jdbc:derby:D:/Derby/db-derby-10.14.2.0-bin/bin/PDC_database";
    String user = "root";
    String password = "wanglei1224";

    public connection() {
        getConnection();
    }

    public Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("driver success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            System.out.println("connection success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public void close_Connection() {
        try {
            System.out.println("all the operation have done, close connection");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

