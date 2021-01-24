package database.table;

import database.connection;
import database.get_object.Get_customer;
import database.get_object.Get_hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer extends Table_super {

    public Customer(ArrayList list, connection c, String table_name1) {
        super(c, table_name1);
        initial_table(list);
    }

    public void initial_table(ArrayList list) {

        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, "
                        + "username VARCHAR (50),firstname VARCHAR(50), lastname VARCHAR(50)," +
                        " phone_number VARCHAR(50),password VARCHAR(20),question VARCHAR (30))";

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
    public void insert(String username, String firstname, String lastname, String phone, String password, String question) {

        ArrayList<Integer> list = get_id_list(table_name1);

        boolean customer_exist1 = judge_something_exist_by_phone_or_username(phone);
        boolean customer_exist2 = judge_something_exist_by_phone_or_username(username);

        if (customer_exist1 && customer_exist2) {
            int pre_id = search_id_by_phone_or_username(phone);
//            System.out.println("pre id = " + pre_id);
            update_value(pre_id, username, firstname, lastname, phone, password, question);
        } else {
            int last_id = create_new_id(list);
//            System.out.println("last id = " + last_id);
            insert_value(last_id, username, firstname, lastname, phone, password, question);
        }

    }

    private void update_value(int pre_id, String username, String firstname, String lastname, String phone, String password, String question) {

        try {
            String update = "update " + table_name1 + " set " + "username = '" + username + "',firstname = '" + firstname + "',lastname = '" + lastname
                    + "',phone_number = '" + phone + "',password = '" + password + "',question = '" + question + "' where id = " + pre_id;
//            System.out.println(update);
            connection.statement.executeUpdate(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void insert_value(int last_id, String username, String firstname, String lastname, String phone, String password, String question) {
        try {
            String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + username + "','" + firstname + "','" + lastname + "','" + phone + "','"
                    + password + "','" + question + "')";
//            System.out.println(insert);
            connection.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // get an object by id
    public Get_customer get(int id) {
        String table_name = this.table_name1;

        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    String username = resultSet.getString("username");
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String phone = resultSet.getString("phone_number");
                    String password = resultSet.getString("password");
                    String question = resultSet.getString("question");
                    Get_customer get_customer = new Get_customer(id, username, firstname, lastname, phone, password, question);
                    return get_customer;
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
            Get_customer get_customer = get(list.get(i));
            get_customer.print();
            index = 1;
            System.out.println();
        }

        if (index == 0) System.out.println("there is no data in the database");
    }

}
