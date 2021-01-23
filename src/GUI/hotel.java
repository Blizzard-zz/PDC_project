package GUI;

import java.util.ArrayList;

public class hotel {
    roomtype first;
    roomtype next;
    roomtype r1 = new roomtype("Hotel1", 10);
    roomtype r2 = new roomtype("Hotel2", 10);
    roomtype r3 = new roomtype("Hotel3", 10);
    roomtype r4 = new roomtype("Hotel4", 10);
    roomtype r5 = new roomtype("Hotel5", 10);
    static ArrayList<roomtype> roomlist1 = new ArrayList<>();

    public hotel(String hotelname) {
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
    }

    public void add(roomtype room) {
        roomlist1.add(room);

    }

    public ArrayList<roomtype> show() {
        return roomlist1;

    }


}
