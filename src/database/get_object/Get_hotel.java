package database.get_object;

public class Get_hotel {
    int id;
    String hotel_name;
    int single_room;
    int double_room;
    int tripe_room;
    int four_room;
    int business_room;
    int presidential_suite;

    public Get_hotel(int id, String hotel_name, int single_room, int double_room, int tripe_room, int four_room, int business_room, int presidential_suite) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.single_room = single_room;
        this.double_room = double_room;
        this.tripe_room = tripe_room;
        this.four_room = four_room;
        this.business_room = business_room;
        this.presidential_suite = presidential_suite;
        print();
    }

    public void print() {
        System.out.println("id: " + id + "\n" +
                "hotel_name:" + hotel_name + "\n" +
                "single_room:" + single_room + "\n" +
                "double_room:" + double_room + "\n" +
                "tripe_room:" + tripe_room + "\n" +
                "four_room:" + four_room + "\n" +
                "business_room:" + business_room + "\n" +
                "presidential_suite:" + presidential_suite);


    }

}
