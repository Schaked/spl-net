package bgu.spl.net.srv;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class User {
    private String userName;
    private String password;
    private boolean isAdmin;
    protected LinkedList<Integer> coursesReg;

    public User (String userName, String password){
        this.userName=userName;
        this.password=password;
        isAdmin=false;
        this.coursesReg = null;
    }



    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setCourse(Integer course){
        coursesReg.add(course);
    }
    public void isRegister(Integer course){
        coursesReg.contains(course);

    }
}
