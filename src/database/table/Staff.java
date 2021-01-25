package database.table;

import database.connection;
import database.get_object.Get_hotel;
import database.get_object.Get_staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Staff extends Table_super {


    public Staff(ArrayList list, connection c, String table_name1) {
        super(c, table_name1);
        initial_table(list);
    }

    public void initial_table(ArrayList list) {

        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, username VARCHAR(50)," +
                        " firstname VARCHAR(50), lastname VARCHAR(50)," + " phone_number VARCHAR(50)" +
                        ",password VARCHAR(20),register VARCHAR(20),question VARCHAR (50))";
                System.out.println(sqlCreateTable);
                connection.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {
//                System.out.println(table_name1 + " exists");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //insert value and need to select id if there has same id then update ,else insert value
    public void insert(String username, String firstname, String lastname, String phone, String password, String register, String question) {

        ArrayList<Integer> list = get_id_list(table_name1);
        boolean staff_exist1 = judge_something_exist_by_phone_or_username(phone);
        boolean staff_exist2 = judge_something_exist_by_phone_or_username(username);

        if (staff_exist1 && staff_exist2) {
            int pre_id = search_id_by_phone_or_username(phone);
            update_value(pre_id, username, firstname, lastname, phone, password, register, question);
        } else {
            int last_id = create_new_id(list);
            insert_value(last_id, username, firstname, lastname, phone, password, register, question);
        }
    }

    private void update_value(int pre_id, String username, String firstname, String lastname, String phone, String password, String register, String question) {
        try {
            String update = "update " + table_name1 + " set " + "username = '" + username + "',firstname = '" + firstname + "',lastname = '" + lastname
                    + "',phone_number = '" + phone + "',password = '" + password +
                    "',register = '" + register + "',question = '" + question + "' where id = " + pre_id;
//            System.out.println(update);
            connection.statement.executeUpdate(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void insert_value(int last_id, String username, String firstname, String lastname, String phone, String password, String register, String question) {
        try {
            String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + username + "','" + firstname + "','" + lastname
                    + "','" + phone + "','" + password + "','" + register + "','" + question + "')";
//            System.out.println(insert);
            connection.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Get_staff get(int id) {

        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    String username = resultSet.getString("username");
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String phone = resultSet.getString("phone_number");
                    String password = resultSet.getString("password");
                    String register = resultSet.getString("register");
                    String question = resultSet.getString("question");
                    Get_staff get_staff = new Get_staff(id, username, firstname, lastname, phone, password, register, question);
                    return get_staff;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void view_table() {
        System.out.println("view table");
        int index = 0;
        ArrayList<Integer> list = get_id_list(table_name1);

        for (int i = 0; i < list.size(); i++) {
            Get_staff get_staff = get(list.get(i));
            get_staff.print();
            index = 1;
            System.out.println();
        }
        if (index == 0) System.out.println("there is no data in the database");
    }

}


