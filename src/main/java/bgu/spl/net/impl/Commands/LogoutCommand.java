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
            protocol.setShouldTerminate(true);
        }
        return null;
    }
}
