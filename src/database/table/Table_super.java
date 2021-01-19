package database.table;

import database.connection;
import database.table.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Table_super implements Table {
    public String table_name1;
    database.connection connection;

    public Table_super(connection c, String table_name1) {
        this.table_name1 = table_name1;
        this.connection = c;
    }

    @Override
    public abstract void view_table();

    public abstract void initial_table(ArrayList list);


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

    public boolean login(String account, String input_password) {
        boolean login;
        if (isNumeric(account)) {
            login = phone_number_login(account, input_password);
        } else {
            login = username_number_login(account, input_password);
        }
        return login;
    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public boolean username_number_login(String account, String input_password) {
        boolean login = false;
        String judge = "username";
        String login_password = search_password(account, judge);

        if (login_password.equals(input_password)) {
            login = true;
            System.out.println("input password correct,login.....");
        } else {
            System.out.println("wrong password,please input again.");
        }

        return login;
    }

    public boolean phone_number_login(String acount, String input_password) {
        boolean login = false;
        String judge = "phone_number";
        String login_password = search_password(acount, judge);

        if (login_password.equals(input_password)) {
            login = true;
            System.out.println("input password correct,login.....");
        } else {
            System.out.println("wrong password,please input again.");
        }

        return login;
    }

    public String search_password(String input, String judge) {
//        System.out.println("phone_number = " + phone);
        try {
            String search = "select password from " + table_name1 + " where phone_number = '" + input + "'";
            String search2 = "select password from " + table_name1 + " where username = '" + input + "'";
            if (judge.equals("phone_number")) {
                System.out.println(search);
                ResultSet resultSet = connection.statement.executeQuery(search);
                if (resultSet.next()) {
                    return resultSet.getString("password");
                }
            } else if (judge.equals("username")) {
                System.out.println(search2);
                ResultSet resultSet = connection.statement.executeQuery(search2);
                if (resultSet.next()) {
                    return resultSet.getString("password");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public int search_id_by_phone(String phone) {
//        System.out.println("phone_number = " + phone);

        try {
            String search = "select id from " + table_name1 + " where phone_number = '" + phone + "'";
            System.out.println(search);
            ResultSet resultSet = connection.statement.executeQuery(search);
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int search_id_by_username(String name) {
//        System.out.println("phone_number = " + phone);
        try {
            String search = "select id from " + table_name1 + " where username = '" + name + "'";
            System.out.println(search);
            ResultSet resultSet = connection.statement.executeQuery(search);
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
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

    //if customer forget password, it provide a method to find it.
    public String find_forget_password(String input, String question) {


        String search = "select * from " + table_name1 + " where phone_number = '" + input + "'";
        String search2 = "select * from " + table_name1 + " where username = '" + input + "'";

        if (isNumeric(input)) {
//            login = phone_number_login(account, input_password);
            String result = get_password_by_question(search, question);
            return result;
        } else {
//            login = username_number_login(account, input_password);
            String result = get_password_by_question(search2, question);
            return result;
        }

    }

    public String get_password_by_question(String search, String question) {

        ResultSet resultSet2;
        try {
            resultSet2 = connection.statement.executeQuery(search);
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
    public void delete(int id) {

        connection c = this.connection;
        try {
            String delete = "delete from " + table_name1 + " where id = " + id;
            System.out.println(delete);
            c.statement.executeUpdate("delete from " + table_name1 + " where id = " + id);
            System.out.println("success delete id: " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void clean_table() {
        connection c = this.connection;
        try {
            c.statement.executeUpdate("truncate table " + table_name1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
