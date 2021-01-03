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
        User thisUser=database.getUserHashMap().get(protocol.getUserName());
        if(thisUser.isAdmin()){
            return new ErrorCommand(optcode);
        }
        else{
            return new AckCommand(optcode,CourseNumber);
        }
    }
}
