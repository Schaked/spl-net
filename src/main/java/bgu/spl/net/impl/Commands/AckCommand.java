package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;

public class AckCommand extends Command{
    public AckCommand(short optcode) {
        super(optcode);
    }

    public AckCommand(short optcode, int courseNumber){
        super(optcode,courseNumber);
    }

    public AckCommand(short optcode, int CourseNumber, String userName){
        super(optcode,CourseNumber,userName);
    }

    public AckCommand(String userName, short optcode){
        super(userName, optcode);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        return null;
    }
}
