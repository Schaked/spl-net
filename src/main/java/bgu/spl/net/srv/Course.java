package bgu.spl.net.srv;


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

    public int[] getKdamCoursesList() {
        return KdamCoursesList;
    }

    public Integer getNumOfMaxStudent(){
        return this.numOfMaxStudents;
    }
}
