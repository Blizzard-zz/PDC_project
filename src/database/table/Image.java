package database.table;

import database.connection;
import database.get_object.Get_hotel;
import database.get_object.Get_image;
import database.table.Table_super;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Image extends Table_super {
//    public String table_name1;
//    database.connection connection;

    public Image(ArrayList list, connection c, String name) {
        super(c, name);


        initial_table(list);
    }

    public void initial_table(ArrayList list) {

        try {
            if (!list.contains(table_name1)) {

                String sqlCreateTable = "CREATE TABLE " + table_name1 + " (ID INT, "
                        + "hotel_name VARCHAR (100),hotel_path VARCHAR(100),single_room_path VARCHAR (100),double_room_path VARCHAR (100)," +
                        "tripe_room_path VARCHAR (100),four_room_path VARCHAR (100))";
//                System.out.println(sqlCreateTable);
                connection.statement.executeUpdate(sqlCreateTable);
                System.out.println("table: " + table_name1 + " create success");
            } else {
//                System.out.println(table_name1 + " exists");
            }

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

    public void insert(String hotel_name, String hotel_path, String single_path, String double_path, String tripe_path, String four_path) {
        connection c = this.connection;
        ArrayList<Integer> list = get_id_list(table_name1);

        boolean hotel_exist = judge_hotel_exist(hotel_name);
        try {
            int pre_id = search_id_by_hotel_name(hotel_name);
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1 + " where id = " + pre_id);
            if (resultSet.next() && hotel_exist) {

                String update = "update " + table_name1 + " set " + "hotel_name = '" + hotel_name + "',hotel_path = '" + hotel_path
                        + "',single_room_path = '" + single_path + "',double_room_path = '" + double_path + "',tripe_room_path = '" + tripe_path
                        + "',four_room_path = '" + four_path + "' where id = " + pre_id;

//                System.out.println(update);
                connection.statement.executeUpdate(update);

            } else {
                int last_id = create_new_id(list);
                String insert = "insert into " + table_name1 + " values (" + last_id + ",'" + hotel_name + "','" + hotel_path
                        + "','" + single_path + "','" + double_path + "','" + tripe_path + "','" + four_path + "')";
//                System.out.println(insert);
                c.statement.executeUpdate(insert);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Get_image get(int id) {
//        String table_name = this.table_name1;

        try {
            ResultSet resultSet = connection.statement.executeQuery("select * from " + table_name1);

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    String hotel_name = resultSet.getString("hotel_name");
                    String path = resultSet.getString("hotel_path");
                    String single_path = resultSet.getString("single_room_path");
                    String double_path = resultSet.getString("double_room_path");
                    String tripe_path = resultSet.getString("tripe_room_path");
                    String four_path = resultSet.getString("four_room_path");
                    Get_image get_image = new Get_image(id, hotel_name, path, single_path, double_path, tripe_path, four_path);
                    return get_image;
                }

//                System.out.println("id: "+id+" firstname: "+firstname+" lastname: "+lastname+" phone: "+phone+" password: "+password);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
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

    @Override
    public void view_table() {

        System.out.println("view table");
        int index = 0;
        ArrayList<Integer> list = get_id_list(table_name1);

        for (int i = 0; i < list.size(); i++) {
            Get_image get_image = get(list.get(i));
            get_image.print();
            System.out.println();
            index = 1;
        }

        if (index == 0) System.out.println("there is no data in the database");
    }


}
