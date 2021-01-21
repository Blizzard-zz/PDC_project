package database.get_object;

public class Double_room {
    public int number;
    public String description;

    public Double_room(int number, String description) {
        this.number = number;
        this.description = description;

    }

    public String toString() {
        return "Double_room: " + number + " Description: " + description;
    }
}
