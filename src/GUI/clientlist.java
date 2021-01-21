package GUI;

public class clientlist {
    client firstclient;
    client nextclient;

    public clientlist() {

    }

    public void setclient(client client1) {
        if (firstclient == null) {
            this.firstclient = client1;
        } else {
            firstclient.nextclient = client1;

        }

    }

    public boolean find(String name, String password) {
        if (firstclient != null) {
            return firstclient.find1(name, password);
        } else {

            return false;

        }
    }


}
