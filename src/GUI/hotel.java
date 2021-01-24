package GUI;

import java.util.ArrayList;

import database.*;
import database.get_object.Get_hotel;

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
    Get_hotel get_hotel;

    ArrayList<roomtype> roomlist1 = new ArrayList<>();

    public hotel(String hotelname) {
        this.hotel_name = hotelname;
        table = new create_table();

        int id = table.hotel.search_id_by_hotel_name(hotel_name);
        get_hotel = table.hotel.get(id);
        description = get_hotel.hotel_description;
        roomtype1 = new roomtype("single_room", get_hotel.single_room.number, get_hotel.single_room.description);
        roomtype2 = new roomtype("double_room", get_hotel.double_room.number, get_hotel.double_room.description);
        roomtype3 = new roomtype("tripe_room", get_hotel.tripe_room.number, get_hotel.tripe_room.description);
        roomtype4 = new roomtype("four_room", get_hotel.four_room.number, get_hotel.four_room.description);

        add(roomtype1);
        add(roomtype2);
        add(roomtype3);
        add(roomtype4);

    }

    public void add(roomtype room) {
        roomlist1.add(room);
    }

    public ArrayList<roomtype> show_room_list() {
        return roomlist1;
    }

}
