package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class StudentStatCommand extends Command {

    public StudentStatCommand(String userName, short optcode) {
        super(userName, optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        User thisUser=database.getUserHashMap().get(protocol.getUserName());
        if(thisUser.isAdmin()){
            return new AckCommand(userName,optcode);
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
