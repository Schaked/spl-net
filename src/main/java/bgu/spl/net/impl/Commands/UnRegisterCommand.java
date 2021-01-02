package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class UnRegisterCommand extends Command {
    public UnRegisterCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        return null;
    }
}
