package database;

import java.sql.*;
import java.util.logging.Handler;

public class connection {
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    String url = "jdbc:derby:D:/Derby/db-derby-10.13.1.1-bin/bin/firstdb";
    String user = "root";
    String password = "wanglei1224";

    public connection(){

        getConnection();

    }


    public Connection getConnection(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("driver success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url);

            statement = connection.createStatement();

            System.out.println("connection success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return connection;
    }





}

