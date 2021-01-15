package database;

import database.get_object.Get_customer;
import database.get_object.Get_hotel;
import database.table.Customer;
import database.table.Hotel;
import database.table.Image;
import database.table.Staff;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class create_table {

    public create_table() {
        connection c = new connection();
        ArrayList<String> list = new ArrayList<>();

        String[] names = {"TABLE"};
        ResultSet result;
        DatabaseMetaData metadata;
        // find all the table
        try {
            metadata = c.connection.getMetaData();
            result = metadata.getTables(null, null, null, names);
            while ((result.next())) {
                list.add(result.getString("TABLE_NAME").toLowerCase());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.print("table list: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println();
        Customer customer = new Customer(list, c);
        customer.insert(1, "Bob", "White", "123456789", "991224wl", "akkk");
        customer.insert(2, "Mary", "Ropack", "78345", "rwf74d8", "fgijh");
        customer.view_table();
        Get_customer get_customer = customer.get(1);
        customer.delete(1, customer.table_name1);
        customer.view_table();
        System.out.println();

        Staff staff = new Staff(list, c);
        staff.insert(1, "Leo", "Black", "186457451", "password1", "ABRIHUJ");
        staff.view_table();
        staff.get(1);
        System.out.println();

        Hotel hotel = new Hotel(list, c);
        hotel.insert(1, 4, 5, 2, 6, 1, 0);
        hotel.view_table();
        Get_hotel get_hotel = hotel.get(1);
        hotel.delete(1, hotel.table_name1);
        hotel.view_table();
        System.out.println();

        Image image = new Image(list, c);
        image.insert(2, "fly fire", "C:\\Users\\zzzzzz\\IdeaProjects\\PDC_project\\image\\商城.png");
        image.view_table();
        image.get(2);
        image.delete(2, image.table_name1);
        image.view_table();
        System.out.println();

        c.close_Connection();

    }

}
