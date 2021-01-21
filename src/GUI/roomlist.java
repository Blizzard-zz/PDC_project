package GUI;

import java.util.ArrayList;

public class roomlist {
    roomtype first;
    roomtype next;
    roomtype r1 = new roomtype("大床房", 10);
    roomtype r2 = new roomtype("双人间", 10);
    roomtype r3 = new roomtype("三人间", 10);
    roomtype r4 = new roomtype("总统套", 10);
    roomtype r5 = new roomtype("豪华间", 10);
    static ArrayList<roomtype> roomlist1 = new ArrayList<>();

    public roomlist() {
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
