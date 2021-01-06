package bgu.spl.net.impl;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.impl.Commands.Command;

public class BgrsProtocol implements MessagingProtocol<Command> {

    private boolean shouldTerminate=false;
    private String userName="";
    @Override
    public Command process(Command msg) {
        return msg.execute(this);
    }

    public void setShouldTerminate(boolean shouldTerminate) {
        this.shouldTerminate = shouldTerminate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }

}
