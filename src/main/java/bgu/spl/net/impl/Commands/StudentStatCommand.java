package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class StudentStatCommand extends Command {

    public StudentStatCommand(String userName, short optcode) {
        super(userName, optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        return null;
    }
}
