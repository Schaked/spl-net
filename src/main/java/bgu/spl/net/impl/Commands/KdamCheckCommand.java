package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class KdamCheckCommand extends Command {
    public KdamCheckCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        User thisUser = database.getUserHashMap().get(userName);
        if(thisUser.isLogin()){
           return thisUser.getRegList();
        }
    }
}
