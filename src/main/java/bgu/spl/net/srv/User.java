package bgu.spl.net.srv;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class User {
    private String userName;
    private String password;
    private boolean isAdmin;
    private boolean isLogin;
    protected LinkedList<Integer> coursesReg;

    public User (String userName, String password){
        this.userName=userName;
        this.password=password;
        isAdmin=false;
        isLogin=false;
        this.coursesReg = null;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setCourse(Integer course){
        coursesReg.add(course);
    }
    public boolean isRegister(Integer course){
        return coursesReg.contains(course);
    }

    public String getPassword() {
        return password;
    }
    public LinkedList<Integer> getRegList(){
        return coursesReg;
    }
}
