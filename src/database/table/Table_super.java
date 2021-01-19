package database.table;

import database.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
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

    //-----search ID by username or phone-----//
    public int search_id_by_phone_or_username(String input) {
        boolean exist = judge_something_exist_by_phone_or_username(input);


        if (isNumeric(input)) {
            String search1 = "select id from " + table_name1 + " where phone_number = '" + input + "'";
            return search_id_by_phone(search1);
        } else {
            String search2 = "select id from " + table_name1 + " where username = '" + input + "'";
            return search_id_by_username(search2);
        }
    }

    private int search_id_by_phone(String search) {
//        System.out.println("phone_number = " + phone);

        try {
//            String search = "select id from " + table_name1 + " where phone_number = '" + phone + "'";
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

    private int search_id_by_username(String search) {
//        System.out.println("phone_number = " + phone);
        try {
//            String search = "select id from " + table_name1 + " where username = '" + username + "'";
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
    //-----search ID by username or phone  end-----//


    //-----login-----//
    public boolean login(String account, String input_password) {
        boolean login;
        boolean exist = judge_something_exist_by_phone_or_username(account);
//        boolean ccustomer_exist2 = judge_something_exist_by_phone_or_username(username);
        if (exist) {
            if (isNumeric(account)) {
                login = phone_number_login(account, input_password);
            } else {
                login = username_number_login(account, input_password);
            }
            return login;
        } else {
            System.out.println("Account don't exist,please register first");
            return false;
        }

    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    private boolean username_number_login(String username, String input_password) {
        boolean login = false;
        String search2 = "select password from " + table_name1 + " where username = '" + username + "'";
        String login_password = search_password(search2);

        login = Password_correctness(login_password, input_password);

        return login;
    }

    private boolean phone_number_login(String phone, String input_password) {
        boolean login;
        String search1 = "select password from " + table_name1 + " where phone_number = '" + phone + "'";
        String login_password = search_password(search1);

        login = Password_correctness(login_password, input_password);

        return login;
    }

    private boolean Password_correctness(String login_password, String input_password) {
        boolean login;
        if (login_password.equals(input_password)) {
            login = true;
            System.out.println("input password correct,login.....");
        } else {
            login = false;
            System.out.println("wrong password,please input again.");
        }
        return login;
    }

    public String search_password(String search) {

        try {
            ResultSet resultSet = connection.statement.executeQuery(search);
            if (resultSet.next()) {

                return resultSet.getString("password");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //-----login  end-----//


    //-----find forget password-----//
    public String find_forget_password(String account, String question) {

        boolean exist = judge_something_exist_by_phone_or_username(account);
        if (exist) {
            if (isNumeric(account)) {
                String search1 = "select * from " + table_name1 + " where phone_number = '" + account + "'";
                String result = phone_number_get_password_by_question(search1, question);
                return result;
            } else {
                String search2 = "select * from " + table_name1 + " where username = '" + account + "'";
                String result = username_get_password_by_question(search2, question);
                return result;
            }
        } else {
            System.out.println("Account don't exist,please register first");
        }
        return null;
    }

    public String phone_number_get_password_by_question(String search, String question) {

//        ResultSet resultSet2;
        try {
            ResultSet resultSet2 = connection.statement.executeQuery(search);
            while (resultSet2.next()) {
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

    public String username_get_password_by_question(String search, String question) {

//        ResultSet resultSet2;
        try {
            ResultSet resultSet2 = connection.statement.executeQuery(search);
            while (resultSet2.next()) {
                String exist_question1 = resultSet2.getString("question");
//                System.out.println(exist_question1);
                if (exist_question1.equals(question)) {
                    return resultSet2.getString("password");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
    //-----find forget password  end-----//


    //-----judge_something_exist-----//
    public boolean judge_something_exist_by_phone_or_username(String input) {
        boolean exist = false;
        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);
            if (isNumeric(input)) {
                exist = judge_customer_exist_by_phone(resultSet, input);
            } else {
                exist = judge_customer_exist_by_username(resultSet, input);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return exist;
    }

    public boolean exist(ArrayList<String> list, String input) {
        boolean exist = false;
        for (String s : list)
            if (Objects.equals(s, input)) {
                exist = true;
                break;
            }
        return exist;
    }

    private boolean judge_customer_exist_by_phone(ResultSet resultSet, String phone) {

        boolean exist;
        ArrayList<String> list = new ArrayList();
        try {
            while (resultSet.next()) {
                String column = resultSet.getString("phone_number");
                list.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        exist = exist(list, phone);

        return exist;
    }

    private boolean judge_customer_exist_by_username(ResultSet resultSet, String name) {

        boolean exist;
        ArrayList<String> list = new ArrayList();
        try {
//            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);
            while (resultSet.next()) {
                String column = resultSet.getString("username");
                list.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        exist = exist(list, name);

        return exist;
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
    //-----judge_something_exist  end-----//


    @Override
    public void delete(int id) {
        ArrayList list = get_id_list(table_name1);
//        System.out.println(list.contains(id));
        if (list.contains(id)) {
            try {
                String delete = "delete from " + table_name1 + " where id = " + id;
                System.out.println(delete);
                connection.statement.executeUpdate("delete from " + table_name1 + " where id = " + id);
                System.out.println("success delete id: " + id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            System.out.println("No id exist");

        }

    }

    @Override
    public void clean_table() {
//        connection c = this.connection;
        try {
            connection.statement.executeUpdate("truncate table " + table_name1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
