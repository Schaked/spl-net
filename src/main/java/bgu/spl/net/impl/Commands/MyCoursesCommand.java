package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class MyCoursesCommand extends Command {

    public MyCoursesCommand(short optcode) {
        super(optcode);
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        return null;
    }
}
