package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.User;

public class UnRegisterCommand extends Command{
    public UnRegisterCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        if(database.getUserHashMap().containsKey(protocol.getUserName())){
            User thisUser = database.getUserHashMap().get(protocol.getUserName());
            if(thisUser.isRegister(CourseNumber)&&!thisUser.isAdmin()){
                thisUser.deleteCourse(CourseNumber);
                database.getCourseHashMap().get(CourseNumber).setOneMoreSpot();
                return new AckCommand(optcode);
            }
            return new ErrorCommand(optcode);
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
