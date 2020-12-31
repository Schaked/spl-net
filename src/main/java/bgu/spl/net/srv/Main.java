package bgu.spl.net.srv;

import bgu.spl.net.impl.echo.EchoProtocol;
import bgu.spl.net.impl.echo.LineMessageEncoderDecoder;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        try(BaseServer<String> server = BaseServer.threadPerClient(7777,()->new EchoProtocol(),()->new LineMessageEncoderDecoder());){
            server.serve();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
