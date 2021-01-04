package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class MyCoursesCommand extends Command{

    public MyCoursesCommand(short optcode) {
        super(optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        User thisUser = database.getUserHashMap().get(protocol.getUserName());
        if(thisUser.isLogin()&&!thisUser.isAdmin()){
            return new AckCommand(protocol.getUserName(), optcode);
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
