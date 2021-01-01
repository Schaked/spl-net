package bgu.spl.net.srv;

public class User {
    private String userName;
    private String password;
    private boolean isAdmin;

    public User (String userName, String password){
        this.userName=userName;
        this.password=password;
        isAdmin=false;
    }



    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
