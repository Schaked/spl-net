package bgu.spl.net.srv;

import bgu.spl.net.impl.echo.EchoProtocol;
import bgu.spl.net.impl.echo.LineMessageEncoderDecoder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        try(BaseServer<String> server = BaseServer.threadPerClient(7777,()->new EchoProtocol(),()->new LineMessageEncoderDecoder());){
            server.serve();
        }catch(Exception e){
            e.printStackTrace();
        }
//        LinkedList<String> list=new LinkedList<>();
//        list.add("Saba");
//        list.add("Aba");
//        list.add("Mama");
//        String s=list.toString();
//        System.out.println(s);


    }
}
