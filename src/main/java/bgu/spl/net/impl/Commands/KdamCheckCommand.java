package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class KdamCheckCommand extends Command {
    public KdamCheckCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        return null;
    }
}
