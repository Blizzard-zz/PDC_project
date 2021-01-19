package database.table;

import database.connection;
import database.get_object.Get_hotel;

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

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, hotel_name VARCHAR(20),  "
                        + "single_room INT,double_room INT,tripe_room INT ,four_room INT,business_room INT,presidential_suite INT)";

                c.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {
                System.out.println(table_name1 + " exists");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insert(String hotel_name, int single_room, int double_room, int tripe_room, int four_room, int business_room, int presidential_suite) {

        ArrayList<Integer> list = get_id_list(table_name1);

        boolean hotel_exist = judge_hotel_exist(hotel_name);

        if (hotel_exist) {
            int pre_id = search_id_by_hotel_name(hotel_name);
//            System.out.println("pre id = " + pre_id);
            update_value(pre_id, hotel_name, single_room, double_room, tripe_room, four_room, business_room, presidential_suite);
        } else {
            int last_id = create_new_id(list);
//            System.out.println("last id = " + last_id);
            insert_value(last_id, hotel_name, single_room, double_room, tripe_room, four_room, business_room, presidential_suite);
        }

    }

    private void update_value(int pre_id, String hotel_name, int single_room, int double_room, int tripe_room, int four_room, int business_room, int presidential_suite) {

        try {
            String update = "update " + table_name1 + " set " + "hotel_name = '" + hotel_name + "',single_room = " + single_room
                    + ",double_room = " + double_room + ",tripe_room = " + tripe_room + ",four_room = " + four_room + ",business_room = "
                    + business_room + ",presidential_suite = " + presidential_suite + " where id = " + pre_id;
            System.out.println(update);
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

    private int search_id_by_hotel_name(String hotel_name) {
        System.out.println("hotel_name = " + hotel_name);
        try {
            String search = "select id from " + table_name1 + " where hotel_name = '" + hotel_name + "'";
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


    private void insert_value(int last_id, String hotel_name, int single_room, int double_room, int tripe_room, int four_room, int business_room, int presidential_suite) {
        try {
            String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + hotel_name + "'," + single_room + "," + double_room + ","
                    + tripe_room + "," + four_room + "," + business_room + "," + presidential_suite + ")";
            System.out.println(insert);
            connection.statement.executeUpdate(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Get_hotel get(int id) {
        String table_name = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    String hotel_name = resultSet.getString("hotel_name");
                    int single_room = resultSet.getInt("single_room");
                    int double_room = resultSet.getInt("double_room");
                    int tripe_room = resultSet.getInt("tripe_room");
                    int four_room = resultSet.getInt("four_room");
                    int business_room = resultSet.getInt("business_room");
                    int presidential_suite = resultSet.getInt("presidential_suite");

                    Get_hotel get_hotel = new Get_hotel(id, hotel_name, single_room, double_room, tripe_room, four_room, business_room, presidential_suite);
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
        String table_name = this.table_name1;
        connection c = this.connection;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from " + table_name);
            int index = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hotel_name = resultSet.getString("hotel_name");
                int single_room = resultSet.getInt("single_room");
                int double_room = resultSet.getInt("double_room");
                int tripe_room = resultSet.getInt("tripe_room");
                int four_room = resultSet.getInt("four_room");
                int business_room = resultSet.getInt("business_room");
                int presidential_suite = resultSet.getInt("presidential_suite");

                System.out.println("view_table id: " + id + " hotel_name: " + hotel_name + " single_room: " + single_room + " double_room: " + double_room
                        + " tripe_room: " + tripe_room + " four_room: " + four_room + " business_room: " + business_room
                        + " presidential_suite: " + presidential_suite);
                index = 1;
            }
            if (index == 0) System.out.println("there is no data in the database");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
