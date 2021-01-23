package database.table;

import database.connection;
import database.get_object.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Hotel extends Table_super {
    public String table_name1;
    database.connection connection;

    public Hotel(ArrayList list, connection c, String name) {
        super(c, name);
        table_name1 = "hotel";
        this.connection = super.connection;
        initial_table(list);
    }

    public void initial_table(ArrayList list) {
        connection c = this.connection;
        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, hotel_name VARCHAR(20),hotel_description VARCHAR (100), "
                        + "single_room INT,single_description VARCHAR (100),double_room INT,double_description VARCHAR (100)," +
                        "tripe_room INT ,tripe_description VARCHAR (100),four_room INT,four_description VARCHAR (100)" + ")";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {
                System.out.println(table_name1 + " exists");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insert(Get_hotel get_hotel) {

        ArrayList<Integer> list = get_id_list(table_name1);

        boolean hotel_exist = judge_hotel_exist(get_hotel.hotel_name);

        if (hotel_exist) {
            int pre_id = search_id_by_hotel_name(get_hotel.hotel_name);
            update_value(pre_id, get_hotel);
        } else {
            int last_id = create_new_id(list);
            insert_value(last_id, get_hotel);
        }

    }

    private void insert_value(int last_id, Get_hotel hotel) {
        try {
            String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + hotel.hotel_name + "','" + hotel.hotel_description + "',"
                    + hotel.single_room.number + ",' " + hotel.single_room.description + "',"
                    + hotel.double_room.number + ",' " + hotel.double_room.description + "',"
                    + hotel.tripe_room.number + ",' " + hotel.tripe_room.description + "',"
                    + hotel.four_room.number + ",' " + hotel.four_room.description + "')";
//            System.out.println(insert);
            connection.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void update_value(int pre_id, Get_hotel hotel) {

        try {
            String update = "update " + table_name1 + " set " + "hotel_name = '" + hotel.hotel_name + "',hotel_description = '" + hotel.hotel_description
                    + "',single_room = " + hotel.single_room.number + ",single_description = '" + hotel.single_room.description +
                    "',double_room = " + hotel.double_room.number + ",double_description = '" + hotel.double_room.description +
                    "',tripe_room = " + hotel.tripe_room.number + ",tripe_description = '" + hotel.tripe_room.description +
                    "',four_room = " + hotel.four_room.number + ",four_description = '" + hotel.four_room.description + "' where id = " + pre_id;
//            System.out.println(update);
            connection.statement.executeUpdate(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean judge_hotel_exist(String hotel_name) {
        boolean exist;
        ArrayList<String> list = new ArrayList();
        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);
            while (resultSet.next()) {
                String column = resultSet.getString("hotel_name");
                list.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        exist = exist(list, hotel_name);
        return exist;
    }

    public int search_id_by_hotel_name(String hotel_name) {
//        System.out.println("hotel_name = " + hotel_name);
        try {
            String search = "select id from " + table_name1 + " where hotel_name = '" + hotel_name + "'";
//            System.out.println(search);
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


    public Get_hotel get(int id) {
        String table_name = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    String hotel_name = resultSet.getString("hotel_name");
                    String hotel_description = resultSet.getString("hotel_description");

                    int single_number = resultSet.getInt("single_room");
                    String single_description = resultSet.getString("single_description");
                    Single_room single_room = new Single_room(single_number, single_description);

                    int double_number = resultSet.getInt("double_room");
                    String double_description = resultSet.getString("double_description");
                    Double_room double_room = new Double_room(double_number, double_description);
                    int tripe_number = resultSet.getInt("tripe_room");
                    String tripe_description = resultSet.getString("tripe_description");
                    Tripe_room tripe_room = new Tripe_room(tripe_number, tripe_description);

                    int four_number = resultSet.getInt("four_room");
                    String four_description = resultSet.getString("four_description");
                    Four_room four_room = new Four_room(four_number, four_description);

                    Get_hotel get_hotel = new Get_hotel(id, hotel_name, hotel_description, single_room, double_room, tripe_room, four_room);
                    return get_hotel;
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
            Get_hotel get_hotel = get(list.get(i));
            get_hotel.print();
            System.out.println();
            index = 1;
        }

        if (index == 0) System.out.println("there is no data in the database");
    }

}
