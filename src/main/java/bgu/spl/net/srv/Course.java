package bgu.spl.net.srv;


import java.util.Collections;
import java.util.LinkedList;

public class Course {
    private int courseNum;
    private String courseName;
    private int[] KdamCoursesList;
    private int numOfMaxStudents;
    private int availableSpots;
    private LinkedList <String> studentRegToCourse;
    public Course (int courseNum, String courseName, int[] kdamCoursesList, int numOfMaxStudents){
        this.courseNum=courseNum;
        this.courseName=courseName;
        this.KdamCoursesList=kdamCoursesList;
        this.numOfMaxStudents=numOfMaxStudents;
        this.availableSpots=numOfMaxStudents;
        studentRegToCourse=new LinkedList<>();
    }

    public int[] getKdamCoursesList() {
        return KdamCoursesList;
    }

    public int getNumOfMaxStudent(){
        return this.numOfMaxStudents;
    }
    public int getAvailableSpots(){
        return this.availableSpots;
    }
    public void setOneLessSpot(){
        this.availableSpots = this.availableSpots-1;
    }
    public void setOneMoreSpot(){
        this.availableSpots = this.availableSpots+1;
    }

    public LinkedList<String> getStudentRegToCourse() {
        return studentRegToCourse;
    }

    public void addStudentToCourse(String userName) {
        studentRegToCourse.add(userName);
        Collections.sort(studentRegToCourse); //Sort the list alphabetically
    }
}
