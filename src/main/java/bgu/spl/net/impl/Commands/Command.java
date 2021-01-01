package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Database;

public abstract class Command {
    protected short optcode;
    protected Database database=Database.getInstance();
    protected abstract Command execute(BgrsProtocol protocol);


    public Command(String userName, String password, short optcode) {
        this.optcode=optcode;
    }
    public Command(short optcode){
        this.optcode=optcode;
    }
    public Command(short optcode, int CourseNumber){
        this.optcode=optcode;
    }
    public Command(String userName, short optcode){
        this.optcode=optcode;
    }
}

