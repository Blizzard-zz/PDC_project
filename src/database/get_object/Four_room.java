package database.get_object;

public class Four_room {
    public int number;
    public String description;

    public Four_room(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public String toString() {
        return "Four_room: " + number + " Description: " + description;
    }
}
