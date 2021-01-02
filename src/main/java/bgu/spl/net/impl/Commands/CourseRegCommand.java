package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;



public class CourseRegCommand extends Command {

    public CourseRegCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }
    public boolean KDAMIsOk(){
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

        if((!database.getCourseHashMap().containsKey(CourseNumber))||(database.getCourseHashMap().get(CourseNumber).getAvailableSpots()<=0)||(!database.getUserHashMap().get(protocol.getUserName()).isLogin())||(!this.KDAMIsOk())){
            return null;//Err
        } else {
            database.getUserHashMap().get(protocol.getUserName()).setCourse(CourseNumber);
            database.getCourseHashMap().get(CourseNumber).setOneLessSpot();
            return null;//Ack
        }
    }
}
