package database.get_object;

public class Get_hotel {
    public int id;
    public String hotel_name;
    public String hotel_description;
    public Single_room single_room;
    public Double_room double_room;
    public Tripe_room tripe_room;
    public Four_room four_room;


    public Get_hotel(int id, String hotel_name, String hotel_description, Single_room single_room,
                     Double_room double_room, Tripe_room tripe_room, Four_room four_room) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_description = hotel_description;
        this.single_room = single_room;
        this.double_room = double_room;
        this.tripe_room = tripe_room;
        this.four_room = four_room;

//        print();
    }

    public void print() {
        System.out.println("id: " + id + "\n" +
                "hotel_name:" + hotel_name + "\n" +
                "hotel_description:" + hotel_description + "\n" +
                single_room + "\n" +
                double_room + "\n" +
                tripe_room + "\n" +
                four_room + "\n");


    }

}
