package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class ErrorCommand extends Command{
    public ErrorCommand(short optcode) {
        super(optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        return null;
    }
}
