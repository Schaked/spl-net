package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class StudentStatCommand extends Command {

    public StudentStatCommand(String userName, short optcode) {
        super(userName, optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
//        User studentUser=database.getUserHashMap().get(userName);
        if(database.getUserHashMap().containsKey(protocol.getUserName())){
            User user=database.getUserHashMap().get(protocol.getUserName());
            if(user.isAdmin()){
                return new AckCommand(userName,optcode);
            }
            else{
                return new ErrorCommand(optcode);
            }
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
