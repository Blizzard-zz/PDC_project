package database.table;

import database.connection;
import database.table.Table;

import java.sql.SQLException;
import java.util.ArrayList;

public class Table_super implements Table {
    String table_name1;
    database.connection connection;

    public Table_super(connection c) {
        this.connection = c;
    }

    @Override
    public void view_table() {

    }

    @Override
    public void delete(int id, String table_name) {
//        String table_name = this.table_name1;

        connection c = this.connection;
        try {
            String delete = "delete from " + table_name + " where id = " + id;
            System.out.println(delete);
            c.statement.executeUpdate("delete from " + table_name + " where id = " + id);
            System.out.println("success delete id: " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void clean_table(String table_name) {
        connection c = this.connection;
        try {
            c.statement.executeUpdate("truncate table " + table_name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initial_table(ArrayList list) {

    }
}
