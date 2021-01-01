package bgu.spl.net.srv;

public class User {
    private String userName;
    private String password;
    private boolean isRegistered;
    private boolean isAdmin;

    public User (String userName, String password){
        this.userName=userName;
        this.password=password;
        isRegistered=false;
        isAdmin=false;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
