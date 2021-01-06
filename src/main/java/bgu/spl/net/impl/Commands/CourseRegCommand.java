package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;



public class CourseRegCommand extends Command {

    public CourseRegCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }
    public boolean KDAMIsOk(String userName){
        int[] kdamArr = database.getCourseHashMap().get(CourseNumber).getKdamCoursesList();
        User thisUser = database.getUserHashMap().get(userName);
        for(int i = 0; i<kdamArr.length;i++){
            if(!thisUser.isRegister(kdamArr[i])){
                return false;
            }
        }
        return true;
    }
    @Override
    public Command execute(BgrsProtocol protocol) {
        boolean courseExists=database.getCourseHashMap().containsKey(CourseNumber);
        boolean userExists=database.getUserHashMap().containsKey(protocol.getUserName());
        if(courseExists && userExists){
            boolean isRegisterToCourse=database.getUserHashMap().get(protocol.getUserName()).isRegister(CourseNumber);
            boolean courseAvailable=database.getCourseHashMap().get(CourseNumber).getAvailableSpots()>0;
            boolean isLogin=database.getUserHashMap().get(protocol.getUserName()).isLogin();
            boolean hasAllKdamCourses=KDAMIsOk(protocol.getUserName());
            if(!isRegisterToCourse && courseAvailable && isLogin && hasAllKdamCourses){
                User user=database.getUserHashMap().get(protocol.getUserName());
                user.setCourse(CourseNumber);
                return new AckCommand(optcode);
            }
            else{
                return new ErrorCommand(optcode);
            }
        }
        else{
            return new ErrorCommand(optcode);
        }
//        if((!database.getCourseHashMap().containsKey(CourseNumber) ||!database.getUserHashMap().get(protocol.getUserName()).isLogin() || database.getUserHashMap().get(protocol.getUserName()).isRegister(CourseNumber) || database.getCourseHashMap().get(CourseNumber).getAvailableSpots()<=0 ||!KDAMIsOk(protocol.getUserName()))){
//            return new ErrorCommand(optcode);
//        } else {
//            database.getUserHashMap().get(protocol.getUserName()).setCourse(CourseNumber);
//            database.getCourseHashMap().get(CourseNumber).setOneLessSpot();
//            return new AckCommand(optcode);
//        }
    }
}
