package database;

import database.get_object.*;
import database.table.Customer;
import database.table.Hotel;
import database.table.Image;
import database.table.Staff;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class create_table {
    public Customer customer;
    public Staff staff;
    public Hotel hotel;
    public Image image;
    public Get_hotel get_hotel;
    public Get_hotel get_hotel1;
    public Get_hotel get_hotel2;


    public create_table() {
        connection c = new connection();
        ArrayList<String> list;

        list = table_list(c);


        customer = new Customer(list, c, "customer");
        staff = new Staff(list, c, "staff");
        hotel = new Hotel(list, c, "hotel");
        image = new Image(list, c, "image");
        clean_all_table(customer, staff, hotel);
        establish_all();

    }

    public void establish_all() {
        establish_customer();
        establish_staff();
        establish_hotel();
        establish_image();
    }

    public void establish_image() {
        image.insert("Open the fire", "src/images/1.jpg", "src/images/1.singleRoom.PNG",
                "src/images/1.business room.PNG", "src/images/1.five-person room.PNG", "src/images/1.four-person room.PNG");
        image.insert("Eagle", "src/images/2.jpg", "src/images/2.singleRoom.PNG",
                "src/images/2.business room.PNG", "src/images/2.three-person room.PNG", "src/images/2.four-person room.PNG");
        image.insert("Dreamers", "src/images/3.jpg", "src/images/3.single room.PNG",
                "src/images/3.business room.PNG", "src/images/3.five-person room.PNG", "src/images/3.four-person room.PNG");

    }

    public void establish_hotel() {
        String hotel_name = "Open the fire";
        String hotel_description = "No.207, Wenzhou Road, Xiasha Development Zone  Phone number:63368947";

        int single_number = 3;
        String single_description = "1.8m king-size bed, 40m, WIFI(free), broadband(free)";

        int double_number = 0;
        String double_description = "";

        int tripe_number = 2;
        String tripe_description = "3 * 1.2m bed, 50-60m, WIFI(free), broadband(free)";

        int four_number = 1;
        String four_description = "4 * 1.2m bed, 60m, WIFI(free), broadband(free)";

        get_hotel = hotel_list(hotel_name, hotel_description, single_number, single_description,
                double_number, double_description, tripe_number, tripe_description, four_number, four_description);

        hotel.insert(get_hotel);

        String hotel_name1 = "Eagle";
        String hotel_description1 = "No.211, Wenzhou Road, Xiasha Development Zone  Phone number:63368754";

        int single_number1 = 0;
        String single_description1 = "";

        int double_number1 = 5;
        String double_description1 = "1.8m king-size bed, 40m, WIFI(free), broadband(free)";

        int tripe_number1 = 3;
        String tripe_description1 = "3 * 1.2m bed, 50-60m, WIFI(free), broadband(free)";

        int four_number1 = 3;
        String four_description1 = "4 * 1.2m bed, 60m, WIFI(free), broadband(free)";

        get_hotel1 = hotel_list(hotel_name1, hotel_description1, single_number1, single_description1,
                double_number1, double_description1, tripe_number1, tripe_description1, four_number1, four_description1);

        hotel.insert(get_hotel1);

        String hotel_name2 = "Dreamers";
        String hotel_description2 = "No.257, Wenzhou Road, Xiasha Development Zone  Phone number:63357659\n";

        int single_number2 = 5;
        String single_description2 = "1.8m king-size bed, 40m, WIFI(free), broadband(free)";

        int double_number2 = 0;
        String double_description2 = "";

        int tripe_number2 = 0;
        String tripe_description2 = "";

        int four_number2 = 10;
        String four_description2 = "4 * 1.2m bed, 60m, WIFI(free), broadband(free)";

        get_hotel2 = hotel_list(hotel_name2, hotel_description2, single_number2, single_description2,
                double_number2, double_description2, tripe_number2, tripe_description2, four_number2, four_description2);

        hotel.insert(get_hotel2);
//        hotel.view_table();


    }

    public void establish_staff() {
        staff.insert("staff01", "Ada", "Miller", "13757689435",
                "abcdef", "ADLKOJ908", "Daniel");
        staff.insert("staff02", "Charlie", "Smith", "13957876543",
                "ghijkl", "LAKNE736", "Joshua");

    }

    public void establish_customer() {
        customer.insert("Scar", "Albus", "Dumbledore", "13758884998", "abcdef", "Dobby");
        customer.insert("Professor", "Severus", "Snape", "13968187236", "ghijkl", "Black");

    }

    public Get_hotel hotel_list(String hotel_name, String hotel_description, int single_number, String single_description, int double_number, String double_description,
                                int tripe_number, String tripe_description, int four_number, String four_description) {

        Single_room single_room = new Single_room(single_number, single_description);

        Double_room double_room = new Double_room(double_number, double_description);

        Tripe_room tripe_room = new Tripe_room(tripe_number, tripe_description);

        Four_room four_room = new Four_room(four_number, four_description);

        Get_hotel get_hotel = new Get_hotel(0, hotel_name, hotel_description, single_room, double_room, tripe_room, four_room);

        return get_hotel;
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
