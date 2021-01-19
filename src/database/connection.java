package database;

import java.sql.*;


public class connection {
    public Connection connection;
    public Statement statement;

    //    String url = "jdbc:derby:C:/Users/zzzzzz/IdeaProjects/PDC_project/PDC_database";
    String url = "jdbc:derby:PDC_database";
    String user = "root";
    String password = "wanglei1224";

    public connection() {
        getConnection();
    }

    public void getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Driver Success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

