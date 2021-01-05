package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.impl.BgrsEncoderDecoder;
import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Server;

public class TPCMain {
    public static void main(String[] args){
        Server.threadPerClient(
                7777, //port
                BgrsProtocol::new, //protocol factory
                BgrsEncoderDecoder::new //message encoder decoder factory
        ).
                serve();
    }
}
