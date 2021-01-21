package GUI;

public class client {
    String name;
    String idnumber;
    String user;
    String password;
    String phone;
    client nextclient;


    public client() {
    }

    public client(String user, String password, String phone) {
        this.user = user;
        this.password = password;
        this.phone = phone;

    }

    public boolean find1(String nmae, String password1) {
        if (user.equals(name) && password.equals(password1)) {
            return true;

        } else if (nextclient != null) {
            return nextclient.find1(name, password1);
        } else {
            return false;
        }

    }


}
