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
        ArrayList<String> list;

        list = table_list(c);

        System.out.println();
        System.out.println();
        Customer customer = new Customer(list, c);
//        customer.clean_table(customer.table_name1);
        customer.insert("Bob", "White", "123456789", "991224wl", "akkk");
        customer.insert("Mary", "Ropack", "78345", "rwf74d8", "fgijh");
        customer.view_table();
        Get_customer get_customer = customer.get(1);
        customer.delete(1, customer.table_name1);
        customer.view_table();
        System.out.println();

        Staff staff = new Staff(list, c);
//        staff.clean_table(staff.table_name1);
        staff.insert("Leo", "Black", "186457451", "password1", "ABRIHUJ", "mary");
        staff.insert("Jack", "Blown", "641515674", "te489.15b", "ABYVFS", "helen");
        staff.view_table();
        staff.get(1);
        staff.delete(1, staff.table_name1);
        staff.view_table();
        System.out.println();

        Hotel hotel = new Hotel(list, c);
        hotel.insert("fly fire hotel", 4, 5, 2, 6, 1, 0);
        hotel.insert("fly cat hotel", 1, 0, 2, 3, 5, 6);
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

        login_test(customer, staff, "123456789", "991224wl", "186457451", "password1");
        forget_password_test(customer, staff, "123456789", "akkk", "186457451", "mary");

        c.close_Connection();

    }

    public ArrayList table_list(connection c) {
        String[] names = {"TABLE"};
        ResultSet result;
        DatabaseMetaData metadata;

        ArrayList<String> list = new ArrayList<>();
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
        return list;
    }

    public void clean_all_table(Customer customer, Staff staff, Hotel hotel) {
        customer.clean_table(customer.table_name1);
        staff.clean_table(staff.table_name1);
        hotel.clean_table(hotel.table_name1);
    }

    public void login_test(Customer customer, Staff staff, String phone, String password, String phone2, String password2) {
        System.out.println("-----login test-----");
        if (customer.login(phone, password)) {
            System.out.println("customer login success");
        }

        if (staff.login(phone2, password2)) {
            System.out.println("staff login success");
        }
        System.out.println("-----test over-----");
        System.out.println();
    }

    public void forget_password_test(Customer customer, Staff staff, String phone, String question, String phone2, String question2) {
        System.out.println("-----forget_password_test-----");
        String password = customer.find_forget_password(phone, question);
        System.out.println("customer get password:" + password);
        String password2 = staff.find_forget_password(phone2, question2);
        System.out.println("staff get password:" + password2);
        System.out.println("-----test over-----");
        System.out.println();
    }

}
