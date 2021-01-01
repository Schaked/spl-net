package bgu.spl.net.impl;

import bgu.spl.net.api.MessageEncoderDecoder;
import bgu.spl.net.impl.Commands.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BgrsEncoderDecoder implements MessageEncoderDecoder <Command> {
    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int len = 0;
    private short optcode=0;
    private Command command;
    private String userName=null;
    private String password=null;
    private int courseNumber=-1;
    private boolean isDoneDecoding=false;

    @Override
    public Command decodeNextByte(byte nextByte) {
        if(len<2){
            pushByte(nextByte);
            if(len==2){
                optcode=bytesToShort(Arrays.copyOfRange(bytes,0,2));
                command=null;
                len=0;
            }
        }
        else {
            switch (optcode){
                case 1:
                case 2:
                case 3:
                    if(decodeUserNameAndPasswordType(nextByte)){
                        isDoneDecoding=true;
                    }
                    break;
                case 4:
                case 11:
                    isDoneDecoding=true;
                    break;
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                    courseNumber=decodeCourseNumberType(bytes);
                    isDoneDecoding=true;
                    break;
                case 8:
                    if(decodeUserNameType(nextByte)){
                        isDoneDecoding=true;
                    }
            }
            command=getCommand(optcode);
        }
        return command;
    }

    public boolean decodeUserNameAndPasswordType(byte nextByte){
        if(nextByte!='0'){
            pushByte(nextByte);
        }
        else{
            if(userName==null){
                userName=new String(bytes,0,len,StandardCharsets.UTF_8);
                len=0;
            }
            else{
                password=new String(bytes,0,len,StandardCharsets.UTF_8);
                len=0;
            }
        }
        return userName!=null && password!=null;
    }

    public int decodeCourseNumberType(byte[] bytes){
        return ((bytes[len] & 0xff) << 8) | (bytes[len+1] & 0xff);
    }

    public boolean decodeUserNameType(byte nextByte){
        if(nextByte!='0'){
            pushByte(nextByte);
        }
        else{
            userName=new String(bytes,0,len,StandardCharsets.UTF_8);
            len=0;
        }
        return userName!=null;
    }

    public Command getCommand(short optcode){
        switch (optcode){
            case 1: return new AdminRegCommand(userName,password,optcode);
            case 2: return new StudentRegCommand(userName,password,optcode);
            case 3: return new LoginCommand(userName, password,optcode);
            case 4: return new LogoutCommand()
        }

    }


    @Override
    public byte[] encode(Command message) {
        return new byte[0];
    }

    private void pushByte(byte nextByte) {
        if (len >= bytes.length) {
            bytes = Arrays.copyOf(bytes, len * 2);
        }
        bytes[len++] = nextByte;
    }
    public short bytesToShort(byte[] byteArr)
    {
        short result = (short)((byteArr[0] & 0xff) << 8);
        result += (short)(byteArr[1] & 0xff);
        return result;
    }
    private String popString() {
        String result = new String(bytes, 2, len, StandardCharsets.UTF_8);
        len = 2;
        return result;
    }
}
