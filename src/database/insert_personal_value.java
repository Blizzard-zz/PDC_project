package database;

import java.sql.SQLException;

public class insert_personal_value {
    public insert_personal_value(String table, connection c,int id,String firsname,String lastname,String phone,String password,String regeister){

        if (regeister !=null){



        }else {

            insert_value1(table,c,id,firsname,lastname,phone,password);
        }



    }
    private void insert_value1(String table, connection c,int id,String firsname,String lastname,String phone,String password) {

        try {
            String insert = "insert into "+table+" values ("+id+",'"+firsname+"','"+lastname+"','"+phone+"','"
                    +password+"')";
            System.out.println(insert);
            c.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void insert_value2(String table, connection c,int id,String firsname,String lastname,String phone,String password,String regeister) {

        try {
            String insert = "insert into "+table+" values ("+id+",'"+firsname+"','"+lastname+"','"+phone+"','"
                    +password+"')";
            System.out.println(insert);
            c.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
