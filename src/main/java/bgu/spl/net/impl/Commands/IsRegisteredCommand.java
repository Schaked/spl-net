package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.User;

public class IsRegisteredCommand extends Command {

    public IsRegisteredCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
    }

    @Override
    public Command execute(BgrsProtocol protocol) {
        boolean userExists=database.getUserHashMap().containsKey(protocol.getUserName());
        if(userExists){
            User thisUser = database.getUserHashMap().get(protocol.getUserName());
            if(!thisUser.isAdmin()){
                return new AckCommand(optcode,CourseNumber,protocol.getUserName());
            }
            else{
                return new ErrorCommand(optcode);
            }
        }
        else{
            return new ErrorCommand(optcode);
        }
    }
}
