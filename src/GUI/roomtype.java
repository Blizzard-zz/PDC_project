package GUI;

public class roomtype {
    String roomtypename;
    String picture1;
    String picture2;
    String picture3;
    String description;
    roomtype next;
    int room_number;
    String path;

    public roomtype(String roomtypename, int roomnumber, String description, String path) {
        this.roomtypename = roomtypename;
        this.room_number = roomnumber;
        this.description = description;
        this.path = path;
    }

    public int checkin() {
        room_number = room_number - 1;
        return room_number;

    }

    public int Checkout() {
        room_number = room_number + 1;
        return room_number;

    }


}
