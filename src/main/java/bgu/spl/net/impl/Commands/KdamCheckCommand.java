package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Course;
import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.User;

public class KdamCheckCommand extends Command {
    public KdamCheckCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        Course thisCourse = database.getCourseHashMap().get(CourseNumber);
        if(thisCourse.getKdamCoursesList().length>0){
//            return thisCourse.getKdamCoursesList();
        return null;//return ACK and kdam list
        }
        return null;// return ACK and empty string
    }
}
