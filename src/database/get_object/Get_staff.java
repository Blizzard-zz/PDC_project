package database.get_object;

public class Get_staff {
    int id;
    String firstname;
    String lastname;
    String phone_number;
    String password;
    String register;
    String question;

    public Get_staff(int id, String firstname, String lastname, String phone, String password, String register, String question) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_number = phone;
        this.password = password;
        this.register = register;
        this.question = question;
        print();
    }

    public void print() {

//        System.out.println("successfully create customer: "+id+" "+firstname+" "+lastname+" "+phone_number+" "+password+" "+register);
        System.out.println("id: " + id + "\n" +
                "firstname:" + firstname + "\n" +
                "lastname:" + lastname + "\n" +
                "phone_number:" + phone_number + "\n" +
                "password:" + password + "\n" +
                "register:" + register + "\n +" +
                "question:" + question);
    }


}
