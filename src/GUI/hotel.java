package GUI;

import java.util.ArrayList;

import database.*;
import database.get_object.Get_hotel;
import database.get_object.Get_image;

public class hotel {
    roomtype first;
    roomtype next;

    create_table table;

    roomtype roomtype1;
    roomtype roomtype2;
    roomtype roomtype3;
    roomtype roomtype4;

    public String hotel_name;
    String description;
    String hotel_path;
    Get_hotel get_hotel;
    Get_image get_image;
    ArrayList<roomtype> roomlist1 = new ArrayList<>();

    public hotel(String hotelname) {
        this.hotel_name = hotelname;
        table = new create_table();

        int id = table.hotel.search_id_by_hotel_name(hotel_name);
        get_hotel = table.hotel.get(id);
        int id1 = table.image.search_id_by_hotel_name(hotel_name);
        System.out.println("image id = " + id1);
        get_image = table.image.get(id1);

        hotel_path = get_image.hotle_path;
        description = get_hotel.hotel_description;
        roomtype1 = new roomtype("single_room", get_hotel.single_room.number, get_hotel.single_room.description, get_image.single_path);
        roomtype2 = new roomtype("double_room", get_hotel.double_room.number, get_hotel.double_room.description, get_image.double_path);
        roomtype3 = new roomtype("tripe_room", get_hotel.tripe_room.number, get_hotel.tripe_room.description, get_image.tripe_path);
        roomtype4 = new roomtype("four_room", get_hotel.four_room.number, get_hotel.four_room.description, get_image.four_path);

        add(roomtype1);
        add(roomtype2);
        add(roomtype3);
        add(roomtype4);

    }

    public roomtype get_room_type_by_name(String name) {

        switch (name) {
            case "single_room":
                return roomtype1;
            case "double_room":
                return roomtype2;
            case "tripe_room":
                return roomtype3;
            case "four_room":
                return roomtype4;

        }

        return null;
    }


    public void add(roomtype room) {
        roomlist1.add(room);
    }

    public ArrayList<roomtype> show_room_list() {
        return roomlist1;
    }

}
