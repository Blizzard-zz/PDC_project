package database.get_object;

public class Get_customer {
    int id;
    String username;
    String firstname;
    String lastname;
    String phone_number;
    String password;
    String security_question;

    public Get_customer(int id, String username, String firstname, String lastname, String phone, String password, String question) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_number = phone;
        this.password = password;
        this.security_question = question;
        print();
    }

    public void print() {

//        System.out.println("successfully create customer: "+id+" "+firstname+" "+lastname+" "+phone_number+" "+password+" "+security_question);
        System.out.println("id: " + id + "\n" +
                "firstname:" + firstname + "\n" +
                "lastname:" + lastname + "\n" +
                "phone_number:" + phone_number + "\n" +
                "password:" + password + "\n" +
                "security_question:" + security_question);
    }
}

