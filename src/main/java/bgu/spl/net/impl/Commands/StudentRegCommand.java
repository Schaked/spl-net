package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class StudentRegCommand extends Command {

    public StudentRegCommand(String userName, String password, short optcode) {
        super(userName, password, optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        if(!database.getUserHashMap().containsKey(userName)){
            database.getUserHashMap().put(userName,new User(userName, password));
            return new AckCommand(optcode);
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
