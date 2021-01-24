package database.get_object;

public class Get_image {
    public int id;
    public String hotel_name;
    public String hotle_path;
    public String single_path;
    public String double_path;
    public String tripe_path;
    public String four_path;


    Get_hotel get_hotel;

    public Get_image(int id, String hotel_name, String path, String single_path, String double_path, String tripe_path, String four_path) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotle_path = path;
        this.single_path = single_path;
        this.double_path = double_path;
        this.tripe_path = tripe_path;
        this.four_path = four_path;
//        print();
    }


    public void print() {
        System.out.println("id: " + id + "\n" +
                "hotel_name:" + hotel_name + "\n" +
                "path:" + hotle_path + "\n" +
                "single_path:" + single_path + "\n" +
                "double_path:" + double_path + "\n" +
                "tripe_path:" + tripe_path + "\n" +
                "four_path:" + four_path);
    }

}
