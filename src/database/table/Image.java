package database.table;

import database.connection;
import database.get_object.Get_image;
import database.table.Table_super;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Image extends Table_super {
    public String table_name1;
    database.connection connection;

    public Image(ArrayList list, connection c, String name) {
        super(c, name);

        this.connection = super.connection;
        initial_table(list);
    }

    public void initial_table(ArrayList list) {
        connection c = this.connection;
        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, "
                        + "hotel_name VARCHAR (10),path VARCHAR(100))";
                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {
                System.out.println(table_name1 + " exists");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void insert(int id, String hotel_name, String path) {
        String table = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name1 + " where id = " + id);
            if (resultSet.next()) {
                String update = "update " + table_name1 + " set " + "hotel_name = '" + hotel_name + "',path = '" + path + "' where id = " + id;
                System.out.println(update);
                c.statement.executeUpdate(update);

            } else {
                String insert = "insert into " + table_name1 + " values (" + id + ",'" + hotel_name + "','" + path + "')";
                System.out.println(insert);
                c.statement.executeUpdate(insert);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Get_image get(int id) {
//        String table_name = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name1);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    String hotel_name = resultSet.getString("hotel_name");
                    String path = resultSet.getString("path");
                    Get_image get_image = new Get_image(id, hotel_name, path);
                    return get_image;
                }

//                System.out.println("id: "+id+" firstname: "+firstname+" lastname: "+lastname+" phone: "+phone+" password: "+password);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void view_table() {
//        String table_name = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name1);
            int index = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hotel_name = resultSet.getString("hotel_name");
                String path = resultSet.getString("path");
                System.out.println("view_table id: " + id + " hotel_name: " + hotel_name + " path: " + path);
                index = 1;
            }
            if (index == 0) System.out.println("there is no data in the database");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
