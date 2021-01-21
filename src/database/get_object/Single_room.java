package database.get_object;

public class Single_room {
    public int number;
    public String description;

    public Single_room(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public String toString() {
        return "Single_room: " + number + " Description: " + description;
    }
}
