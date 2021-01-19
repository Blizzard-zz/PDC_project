package database.table;

import database.connection;
import database.get_object.Get_customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer extends Table_super {

    public Customer(ArrayList list, connection c, String table_name1) {
        super(c, table_name1);
        initial_table(list);
    }

    public void initial_table(ArrayList list) {

        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, "
                        + "username VARCHAR (50),firstname VARCHAR(50), lastname VARCHAR(50), phone_number VARCHAR(50),password VARCHAR(20),question VARCHAR (30))";

                connection.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {

                System.out.println(table_name1 + " exists");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean judge_customer_exist_by_phone(String phone) {

        boolean exist = false;
        ArrayList<String> list = new ArrayList();
        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);
            while (resultSet.next()) {
                String column = resultSet.getString("phone_number");
                list.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (String s : list)
            if (Objects.equals(s, phone)) {
                exist = true;
                break;
            }

        return exist;
    }

    public boolean judge_customer_exist_by_username(String name) {

        boolean exist = false;
        ArrayList<String> list = new ArrayList();
        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);
            while (resultSet.next()) {
                String column = resultSet.getString("username");
                list.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (String s : list)
            if (Objects.equals(s, name)) {
                exist = true;
                break;
            }

        return exist;
    }

    //insert value and need to select id if there has same id then update ,else insert value
    public void insert(String firstname, String username, String lastname, String phone, String password, String question) {

        ArrayList<Integer> list;
        list = get_id_list(table_name1);

        boolean customer_exist = judge_customer_exist_by_phone(phone);

        if (customer_exist) {
            int pre_id = search_id_by_phone(phone);
            System.out.println("pre id = " + pre_id);
            update_value(pre_id, username, firstname, lastname, phone, password, question);
        } else {
            int last_id = create_new_id(list);
            System.out.println("last id = " + last_id);
            insert_value(last_id, username, firstname, lastname, phone, password, question);
        }

    }


    private void update_value(int pre_id, String username, String firstname, String lastname, String phone, String password, String question) {

        try {
            String update = "update " + table_name1 + " set " + "username = '" + username + "',firstname = '" + firstname + "',lastname = '" + lastname
                    + "',phone_number = '" + phone + "',password = '" + password + "',question = '" + question + "' where id = " + pre_id;
            System.out.println(update);
            connection.statement.executeUpdate(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void insert_value(int last_id, String username, String firstname, String lastname, String phone, String password, String question) {
        try {
            String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + username + "','" + firstname + "','" + lastname + "','" + phone + "','"
                    + password + "','" + question + "')";
            System.out.println(insert);
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

//    public boolean login(String account, String input_password) {
//        boolean login;
//        if (isNumeric(account)) {
//            login = phone_number_login(account, input_password);
//        } else {
//            login = username_number_login(account, input_password);
//        }
//        return login;
//    }
//
//    public boolean username_number_login(String account, String input_password) {
//        boolean login = false;
//        String judge = "username";
//        String login_password = search_password(account, judge);
//
//        if (login_password.equals(input_password)) {
//            login = true;
//            System.out.println("input password correct,login.....");
//        } else {
//            System.out.println("wrong password,please input again.");
//        }
//
//        return login;
//    }
//
//    public boolean phone_number_login(String acount, String input_password) {
//        boolean login = false;
//        String judge = "phone_number";
//        String login_password = search_password(acount, judge);
//
//        if (login_password.equals(input_password)) {
//            login = true;
//            System.out.println("input password correct,login.....");
//        } else {
//            System.out.println("wrong password,please input again.");
//        }
//
//        return login;
//    }
//
//
//    public boolean isNumeric(String str) {
//        Pattern pattern = Pattern.compile("[0-9]*");
//        Matcher isNum = pattern.matcher(str);
//        if (!isNum.matches()) {
//            return false;
//        }
//        return true;
//    }


    @Override
    public void view_table() {
        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);
            int index = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String question = resultSet.getString("question");
                System.out.println("view_table id: " + id + " username: " + username + " firstname: " + firstname + " lastname: " + lastname + " phone: " + phone + " password: " + password + " question: " + question);
                index = 1;
            }
            if (index == 0) System.out.println("there is no data in the database");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
