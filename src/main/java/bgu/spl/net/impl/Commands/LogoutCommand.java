package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class LogoutCommand extends Command {

    public LogoutCommand(short optcode) {
        super(optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        String userName=protocol.getUserName();
        if(!userName.isEmpty()){
            database.getUserHashMap().get(userName).setLogin(false);
            protocol.setShouldTerminate(true);
            return new AckCommand(optcode);
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
