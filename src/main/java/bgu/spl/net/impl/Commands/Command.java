package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Database;

public abstract class Command {
    protected short optcode;
    protected String userName;
    protected String password;
    protected int CourseNumber;
    protected Database database=Database.getInstance();
    public abstract Command execute(BgrsProtocol protocol);


    public Command(String userName, String password, short optcode) {
        this.userName=userName;
        this.password=password;
        this.optcode=optcode;
    }
    public Command(short optcode){
        this.optcode=optcode;
    }
    public Command(short optcode, int CourseNumber){
        this.optcode=optcode;
        this.CourseNumber=CourseNumber;
    }
    public Command(String userName, short optcode){
        this.userName=userName;
        this.optcode=optcode;
    }
}

