package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.User;

public class AdminRegCommand extends Command {
    private String userName;
    private String password;


    public AdminRegCommand(String userName, String password, short optcode) {
        super(userName, password,optcode);
        this.userName=userName;
        this.password=password;
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        if(!database.getUserHashMap().containsKey(userName)){
            database.getUserHashMap().put(userName,new User(userName, password));
            database.getUserHashMap().get(userName).setAdmin(true);
            return null;//Ack
        }
        else{
            return null;//Error
        }
    }
}
