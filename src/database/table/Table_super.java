package database.table;

import database.connection;
import database.table.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Table_super implements Table {
    String table_name1;
    database.connection connection;

    public Table_super(connection c) {
        this.connection = c;
    }

    public ArrayList get_id_list(String name) {
//        name = table_name1;
        ArrayList<Integer> list = new ArrayList();
        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + name);
            while (resultSet.next()) {
                int column = resultSet.getInt(1);
                list.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public int create_new_id(ArrayList<Integer> list) {
        int last_id;
        if (list.size() == 0) {
            last_id = 1;
        } else {
            last_id = list.get(list.size() - 1);
            last_id++;
        }
        return last_id;
    }

    public boolean judge_id_exist(ArrayList<Integer> list, int id) {
        System.out.print("exist id list: ");
        boolean exist = false;
        for (Integer i : list) {
            System.out.print(i + " ");
            if (i == id) exist = true;
        }
        System.out.println();
        return exist;
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
