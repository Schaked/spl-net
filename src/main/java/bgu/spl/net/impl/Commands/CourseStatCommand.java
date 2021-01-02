package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class CourseStatCommand extends Command {
    public CourseStatCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        return null;
    }
}
