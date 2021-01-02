package bgu.spl.net.srv;


public class Course {
    private int courseNum;
    private String courseName;
    private int[] KdamCoursesList;
    private int numOfMaxStudents;
    private int availableSpots;
    public Course (int courseNum, String courseName, int[] kdamCoursesList, int numOfMaxStudents){
        this.courseNum=courseNum;
        this.courseName=courseName;
        this.KdamCoursesList=kdamCoursesList;
        this.numOfMaxStudents=numOfMaxStudents;
        this.availableSpots=numOfMaxStudents;
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
}
