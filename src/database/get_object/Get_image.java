package database.get_object;

public class Get_image {
    int id;
    String hotel_name;
    String path;

    public Get_image(int id, String hotel_name, String path) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.path = path;
        print();
    }


    public void print() {
        System.out.println("id: " + id + "\n" +
                "hotel_name:" + hotel_name + "\n" +
                "path:" + path);
    }

}
