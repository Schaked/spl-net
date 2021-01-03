package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class AdminRegCommand extends Command {


    public AdminRegCommand(String userName, String password, short optcode) {
        super(userName, password,optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        if(!database.getUserHashMap().containsKey(userName)){
            database.getUserHashMap().put(userName,new User(userName, password));
            database.getUserHashMap().get(userName).setAdmin(true);
            return new AckCommand(optcode);
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
