package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class LoginCommand extends Command{

    public LoginCommand(String userName, String password, short optcode) {
        super(userName, password, optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        if((database.getUserHashMap().containsKey(userName)) && password.equals(database.getUserHashMap().get(userName).getPassword()) && !database.getUserHashMap().get(userName).isLogin()){
            database.getUserHashMap().get(userName).setLogin(true);
            protocol.setUserName(userName);
            return null; //Ack
        }
        else{
            return null; //Error
        }
    }
}
