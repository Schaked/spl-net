package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class IsRegisteredCommand extends Command {

    public IsRegisteredCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        return null;
    }
}
