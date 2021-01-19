package database;

import database.get_object.Get_customer;
import database.get_object.Get_hotel;
import database.get_object.Get_staff;
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
        Customer customer = new Customer(list, c, "customer");
//        customer.clean_table(customer.table_name1);
        customer.insert("Apple", "Bob", "White", "123456789", "991224wl", "akkk");
        customer.insert("Banana", "Mary", "Ropack", "78345", "rwf74d8", "fgijh");
        customer.view_table();
        int id = customer.search_id_by_phone_or_username("Apple");
        Get_customer get_customer = customer.get(id);
//        int id = customer.search_id_by_phone_or_username("Apple");
        get_customer.print();
        customer.delete(id);
        customer.view_table();
        System.out.println();

        Staff staff = new Staff(list, c, "staff");
//        staff.clean_table(staff.table_name1);
        staff.insert("Tree", "jack", "Black", "186457451", "password1", "ABRIHUJ", "mary");
        staff.insert("Sea", "mary", "Blown", "641515674", "te489.15b", "ABYVFS", "helen");
        staff.view_table();
        int id2 = staff.search_id_by_phone_or_username("Tree");
        System.out.println("ID2 = " + id2);
        Get_staff get_staff = staff.get(id2);
        get_staff.print();
//        int id2 = customer.search_id_by_phone_or_username("Tree");
        staff.delete(id2);
        staff.view_table();
        System.out.println();

        Hotel hotel = new Hotel(list, c, "hotel");
        hotel.insert("fly fire hotel", 4, 5, 2, 6, 1, 0);
        hotel.insert("fly cat hotel", 1, 0, 2, 3, 5, 6);
        hotel.view_table();
        int id3 = hotel.search_id_by_hotel_name("fly fire hotel");
        Get_hotel get_hotel = hotel.get(id3);
        get_hotel.print();
        hotel.delete(1);
        hotel.view_table();
        System.out.println();

//        Image image = new Image(list, c,"image");
//        image.insert(2, "fly fire", "C:\\Users\\zzzzzz\\IdeaProjects\\PDC_project\\image\\商城.png");
//        image.view_table();
//        image.get(2);
//        image.delete(2, image.table_name1);
//        image.view_table();
//        System.out.println();

        login_test(customer, staff, "78345", "rwf74d8", "186457451", "asd");
        forget_password_test(customer, staff, "Apple", "akkk", "186457451", "mary");

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
        customer.clean_table();
        staff.clean_table();
        hotel.clean_table();
    }

    public void login_test(Customer customer, Staff staff, String account1, String password, String account2, String password2) {
        System.out.println("-----login test-----");
        if (customer.login(account1, password)) {
            System.out.println("customer login success");
        }

        if (staff.login(account2, password2)) {
            System.out.println("staff login success");
        }
        System.out.println("-----test over-----");
        System.out.println();
    }

    public void forget_password_test(Customer customer, Staff staff, String account1, String question, String account2, String question2) {
        System.out.println("-----forget password test-----");
        String password = customer.find_forget_password(account1, question);
        String password2 = staff.find_forget_password(account2, question2);
        if (password != null) {
            System.out.println("customer get password:" + password);
        }
        if (password2 != null) {
            System.out.println("staff get password:" + password2);
        }
        System.out.println("-----test over-----");
        System.out.println();
    }

}
