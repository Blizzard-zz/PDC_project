package GUI;

public class roomtype {
    String roomtypename;
    String picture1;
    String picture2;
    String picture3;

    roomtype next;
    int roomunmber;

    public roomtype(String roomtypename, int roomnumber) {
        this.roomtypename = roomtypename;
        this.roomunmber = roomnumber;


    }

    public int checkin() {
        roomunmber = roomunmber - 1;
        return roomunmber;

    }

    public int Checkout() {
        roomunmber = roomunmber + 1;
        return roomunmber;

    }


}
