package database.get_object;

public class Get_staff {
    public int id;
    public String username;
    public String firstname;
    public String lastname;
    public String phone_number;
    public String password;
    public String register;
    public String question;

    public Get_staff(int id, String username, String firstname, String lastname, String phone, String password, String register, String question) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_number = phone;
        this.password = password;
        this.register = register;
        this.question = question;
//        print();
    }

    public void print() {

        System.out.println("id: " + id + "\n" +
                "firstname:" + firstname + "\n" +
                "lastname:" + lastname + "\n" +
                "phone_number:" + phone_number + "\n" +
                "password:" + password + "\n" +
                "register:" + register + "\n" +
                "question:" + question);
    }


}
