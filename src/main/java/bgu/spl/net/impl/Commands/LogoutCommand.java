package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class LogoutCommand extends Command {

    public LogoutCommand(short optcode) {
        super(optcode);
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        return null;
    }
}
