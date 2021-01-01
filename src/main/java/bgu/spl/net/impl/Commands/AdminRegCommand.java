package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class AdminRegCommand extends Command {
    private short optcode=1;


    public AdminRegCommand(String userName, String password, short optcode) {
        super(userName, password,optcode);
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        return null;
    }
}
