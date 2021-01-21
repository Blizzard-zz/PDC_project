package database.get_object;

public class Tripe_room {
    public int number;
    public String description;

    public Tripe_room(int number, String description) {
        this.number = number;
        this.description = description;

    }

    public String toString() {
        return "Tripe_room: " + number + " Description: " + description;
    }
}
