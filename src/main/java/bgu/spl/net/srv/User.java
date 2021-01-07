package bgu.spl.net.srv;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class User {
    private String userName;
    private String password;
    private boolean isAdmin;
    private boolean isLogin;
    private LinkedList<Integer> coursesReg;

    public User (String userName, String password){
        this.userName=userName;
        this.password=password;
        isAdmin=false;
        isLogin=false;
        this.coursesReg = new LinkedList<>();
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

    public void setCourse(Integer course) {
        boolean isEntered=false;
        Database database=Database.getInstance();
        for(int i=0; i<coursesReg.size()&&!isEntered; i++){
            if(database.getCoursesPlaceAtTheCourseFile().get(course)<database.getCoursesPlaceAtTheCourseFile().get(coursesReg.get(i))){
                coursesReg.add(i,course);
                isEntered=true;
            }
        }
        if(!isEntered){
            coursesReg.add(course);
        }
        database.getCourseHashMap().get(course).setOneLessSpot();
    }
    public void deleteCourse(Integer course){
        coursesReg.remove(course);
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

    public boolean isAdmin(){
        return this.isAdmin;
    }
}
