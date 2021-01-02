package bgu.spl.net.srv;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class Course {
    private int courseNum;
    private String courseName;
    private int[] KdamCoursesList;
    private int numOfMaxStudents;
    public Course (int courseNum, String courseName, int[] kdamCoursesList, int numOfMaxStudents){
        this.courseNum=courseNum;
        this.courseName=courseName;
        this.KdamCoursesList=kdamCoursesList;
        this.numOfMaxStudents=numOfMaxStudents;
    }
    public Integer getNumOfMaxStudent(){
        return this.numOfMaxStudents;
    }
}
