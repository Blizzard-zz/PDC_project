package database;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class create_table {

    public create_table(){
        connection c = new connection();
        ArrayList<String> list = new ArrayList<>();

        String[] names = { "TABLE" };
        ResultSet result;
        DatabaseMetaData metadata = null;
        // find all the table
        try {
            metadata = c.connection.getMetaData();
            result = metadata.getTables(null, null, null, names);
            while((result.next())) {
                list.add(result.getString("TABLE_NAME").toLowerCase());
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        System.out.printf("table list: ");
        for (int i = 0; i <list.size();i++){
            System.out.printf(list.get(i)+" ");
        }
        System.out.println();
        System.out.println();

        String newTable="customer";
        create_new_customer_table(newTable,list,c);
        System.out.println();

        String newTable1="staff";
        create_new_staff_table(newTable1,list,c);
        System.out.println();

        String newTable2="image";
        create_image_table(newTable2,list,c);
        System.out.println();

        String newTable3="hotel";
        create_hotel_table(newTable3,list,c);
        System.out.println();



        int customer_id = 1;
        insert_customer_value(newTable,c,customer_id,"Lei","Wang","13777585245","wanglei1224");
        insert_customer_value(newTable,c,2,"Bob","White","123456789","991224wl");
        insert_customer_value(newTable,c,3,"Mary","Black","9878648461","86416qwd");
        view_customer_table(newTable,c);
        System.out.println();

        int staff_id = 1;
        insert_staff_value(newTable1,c,staff_id,"Lei","Wang","13777585245","wanglei1224","ABCDEF");
        view_staff_table(newTable1,c);
        System.out.println();
    }

    private void insert_staff_value(String table, connection c,int id,String firsname,String lastname,String phone,String password, String register) {
        System.out.println("staff table: ");
        try {
            String insert = "insert into "+table+" values ("+id+",'"+firsname+"','"+lastname+"','"+phone+"','"
                    +password+"',' "+register+"')";
            System.out.println(insert);
            c.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void view_customer_table(String Table,connection c) {
        System.out.println("customer table: ");
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from "+ Table);

            while (resultSet.next()){

                String id = resultSet.getString("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                System.out.println("id: "+id+" firstname: "+firstname+" lastname: "+lastname+" phone: "+phone+" password: "+password);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void view_staff_table(String Table,connection c) {
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from "+ Table);
            while (resultSet.next()){

                String id = resultSet.getString("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String register = resultSet.getString("register");
                System.out.println("id: "+id+" firstname: "+firstname+" lastname: "+lastname+" phone: "+phone+
                        " password: "+password+" register:"+register);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void insert_customer_value(String table, connection c,int id,String firsname,String lastname,String phone,String password) {

        try {
            String insert = "insert into "+table+" values ("+id+",'"+firsname+"','"+lastname+"','"+phone+"','"
                    +password+"')";
            System.out.println(insert);
            c.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void create_new_customer_table(String newTable, ArrayList<String> list,connection c) {
        try {
            if (list.contains(newTable)){


                c.statement.executeUpdate("drop table "+newTable);

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "firstname VARCHAR(50), lastname VARCHAR(50), phone_number VARCHAR(50),password VARCHAR(20))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: "+newTable+" create success");
            }else{

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "firstname VARCHAR(50), lastname VARCHAR(50), phone_number VARCHAR(50),password VARCHAR(20))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table "+newTable+" create success");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void create_new_staff_table(String newTable, ArrayList<String> list,connection c) {
        try {
            if (list.contains(newTable)){


                c.statement.executeUpdate("drop table "+newTable);



                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "firstname VARCHAR(50), lastname VARCHAR(50), phone_number VARCHAR(50),password VARCHAR(20),register VARCHAR(20))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: "+newTable+" create success");
            }else{

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "firstname VARCHAR(50), lastname VARCHAR(50), phone_number VARCHAR(50),password VARCHAR(20),register VARCHAR(20))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table "+newTable+" create success");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void create_image_table(String newTable, ArrayList<String> list,connection c) {
        try {
            if (list.contains(newTable)){

                c.statement.executeUpdate("drop table "+newTable);

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "hotel_name VARCHAR (10),path VARCHAR(50))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: "+newTable+" create success");
            }else{

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "hotel_name VARCHAR (10),path VARCHAR(50))";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table "+newTable+" create success");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void create_hotel_table(String newTable, ArrayList<String> list,connection c) {
        try {
            if (list.contains(newTable)){


                c.statement.executeUpdate("drop table "+newTable);

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "single_room INT,double_room INT,tripe_room INT ,four_room INT,business_room INT,presidential_suite INT)";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: "+newTable+" create success");
            }else{

                String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
                        + "single_room INT,double_room INT,tripe_room INT ,four_room INT,business_room INT,presidential_suite INT)";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table "+newTable+" create success");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
