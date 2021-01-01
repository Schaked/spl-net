package bgu.spl.net.impl;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.impl.Commands.Command;

public class BgrsProtocol implements MessagingProtocol<Command> {
    @Override
    public Command process(Command msg) {
//        return msg.execute(this);
        return null;
    }

    @Override
    public boolean shouldTerminate() {
        return false;
    }

}
