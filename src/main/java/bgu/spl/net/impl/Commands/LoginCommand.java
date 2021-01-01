package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class LoginCommand extends Command{

    public LoginCommand(String userName, String password, short optcode) {
        super(userName, password, optcode);
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        return null;
    }
}
