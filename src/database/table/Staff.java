package database.table;

import database.connection;
import database.get_object.Get_staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Staff extends Table_super {

    public String table_name1;
    database.connection connection;

    public Staff(ArrayList list, connection c) {
        super(c);
        table_name1 = "staff";
        this.connection = super.connection;
        initial_table(list);
    }

    public void initial_table(ArrayList list) {
        connection c = this.connection;
        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, "
                        + "firstname VARCHAR(50), lastname VARCHAR(50), phone_number VARCHAR(50)" +
                        ",password VARCHAR(20),register VARCHAR(20),question VARCHAR (50))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {
                System.out.println(table_name1 + " exists");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //insert value and need to select id if there has same id then update ,else insert value
    public void insert(String firstname, String lastname, String phone, String password, String register, String question) {

        ArrayList<Integer> list;
        list = get_id_list(table_name1);

        boolean staff_exist = judge_staff_exist(phone);

        if (staff_exist) {
            int pre_id = search_id_by_phone(phone);
            System.out.println("pre id = " + pre_id);
            update_value(pre_id, firstname, lastname, phone, password, register, question);
        } else {
            int last_id = create_new_id(list);
            System.out.println("last id = " + last_id);
            insert_value(last_id, firstname, lastname, phone, password, register, question);
        }

    }

    public boolean judge_staff_exist(String phone) {

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

    private int search_id_by_phone(String phone) {
        System.out.println("phone_number = " + phone);
        try {
            String search = "select id from " + table_name1 + " where phone_number = '" + phone + "'";
            System.out.println(search);
            ResultSet resultSet = connection.statement.executeQuery(search);
//            connection.statement.executeUpdate(search);
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    private void update_value(int pre_id, String firstname, String lastname, String phone, String password, String register, String question) {

        try {
            String update = "update " + table_name1 + " set " + "firstname = '" + firstname + "',lastname = '" + lastname
                    + "',phone_number = '" + phone + "',password = '" + password +
                    "',register = '" + register + "',question = '" + question + "' where id = " + pre_id;
            System.out.println(update);
            connection.statement.executeUpdate(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void insert_value(int last_id, String firstname, String lastname, String phone, String password, String register, String question) {
        try {
            String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + firstname + "','" + lastname
                    + "','" + phone + "','" + password + "','" + register + "','" + question + "')";
            System.out.println(insert);
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
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String phone = resultSet.getString("phone_number");
                    String password = resultSet.getString("password");
                    String register = resultSet.getString("register");
                    String question = resultSet.getString("question");
                    Get_staff get_staff = new Get_staff(id, firstname, lastname, phone, password, register, question);

                    return get_staff;
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    //login judge the input_password whether equal to the password stored in the database.
    public boolean login(String phone, String input_password) {
        boolean login = false;

        String login_password = search_password_by_phone(phone);

        if (login_password.equals(input_password)) {
            login = true;
            System.out.println("input password correct,login.....");
        }

        return login;
    }

    private String search_password_by_phone(String phone) {
//        System.out.println("phone_number = " + phone);
        try {
            String search = "select password from " + table_name1 + " where phone_number = '" + phone + "'";
            System.out.println(search);
            ResultSet resultSet = connection.statement.executeQuery(search);
            if (resultSet.next()) {
                return resultSet.getString("password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //if staff forget password, it provide a method to find it.
    public String find_forget_password(String phone, String question) {
        try {
            String search = "select * from " + table_name1 + " where phone_number = '" + phone + "'";
            ResultSet resultSet2 = connection.statement.executeQuery(search);

            if (resultSet2.next()) {

                String exist_question1 = resultSet2.getString("question");
                if (exist_question1.equals(question)) {
                    return resultSet2.getString("password");
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }


    @Override
    public void view_table() {
        String table_name = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name);
            int index = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String register = resultSet.getString("register");
                String question = resultSet.getString("question");
                System.out.println("view_table id: " + id + " firstname: " + firstname + " lastname: " + lastname
                        + " phone: " + phone + " password: " + password + " register: " + register + " question: " + question);
                index = 1;
            }
            if (index == 0) System.out.println("there is no data in the database");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}


