package bgu.spl.net.impl;

import bgu.spl.net.api.MessageEncoderDecoder;
import bgu.spl.net.impl.Commands.*;
import bgu.spl.net.srv.Course;
import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.User;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

public class BgrsEncoderDecoder implements MessageEncoderDecoder <Command> {
    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int len = 0;
    private int courseNumber=-1;
    private short optcode=0;
    private Command command=null;
    private String userName=null;
    private String password=null;
    private boolean isDoneDecoding=false;
    int temp;

    @Override
    public Command decodeNextByte(byte nextByte) {
        if (len==0){
            command=null;
        }
        if(len<2){
            pushByte(nextByte);
            if(len==2){
                optcode=bytesToShort(Arrays.copyOfRange(bytes,0,2),0);
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
                    courseNumber=bytesToShort(bytes,len-2);
//                    courseNumber = decodeCourseNumberType(bytes);
                    isDoneDecoding=true;
                    break;
                case 8:
                    if(decodeUserNameType(nextByte)){
                        isDoneDecoding=true;
                    }
            }
            if(isDoneDecoding){
                command=getCommand(optcode);
                reset();
            }
        }
        return command;
    }
    public void reset(){
        len=0;
        userName=null;
        password=null;
        courseNumber=-1;
        isDoneDecoding=false;
    }

    public boolean decodeUserNameAndPasswordType(byte nextByte){
        if(nextByte!='\0'){
            pushByte(nextByte);
        }
        else{
            if(userName==null){
                userName=new String(bytes,2,len-2,StandardCharsets.UTF_8);
                temp=len;
            }
            else{
                password=new String(bytes,userName.length()+2,len-temp,StandardCharsets.UTF_8);
            }
        }
        return userName!=null && password!=null;
    }

    public int decodeCourseNumberType(byte[] bytes){
        return ((bytes[len] & 0xff) << 8) | (bytes[len+1] & 0xff);
    }

    public boolean decodeUserNameType(byte nextByte){
        if(nextByte!='\0'){
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
            case 4: return new LogoutCommand(optcode);
            case 5: return new CourseRegCommand(optcode,courseNumber);
            case 6: return new KdamCheckCommand(optcode,courseNumber);
            case 7: return new CourseStatCommand(optcode,courseNumber);
            case 8: return new StudentStatCommand(userName,optcode);
            case 9: return new IsRegisteredCommand(optcode,courseNumber);
            case 10: return new UnRegisterCommand(optcode,courseNumber);
            case 11: return new MyCoursesCommand(optcode);
        }
        return null;
    }


    @Override
    public byte[] encode(Command message) {
        Course course=Database.getInstance().getCourseHashMap().get(message.getCourseNumber());
        User user=Database.getInstance().getUserHashMap().get(message.getUserName());
        if(message instanceof ErrorCommand){
            return ("Error "+optcode+'\0').getBytes();
        }
        else{
            switch (message.getOptcode()){
                case 1://AdminReg
                case 2://StudentReg
                case 3://Login
                case 4://Logout
                case 5://CourseReg
                case 10://UnRegistered
                    return ("ACK "+message.getOptcode()+'\0').getBytes(StandardCharsets.UTF_8);
                case 6://KdamCheck
                    return ("ACK "+message.getOptcode()+"\n"+ Arrays.toString(course.getKdamCoursesList())+'\0').getBytes();
                case 7://CourseStat
                    String Course="Course: ("+message.getCourseNumber()+") "+course.getCourseName();
                    String Seats_Available="Seats Available: "+course.getAvailableSpots()+"/"+course.getNumOfMaxStudent();
                    String Students_Registered="Student Registered: "+ course.getStudentRegToCourse().toString();
                    return ("ACK "+message.getOptcode()+"\n"+Course+"\n"+Seats_Available+"\n"+Students_Registered+'\0').getBytes();
                case 8://StudentStat
                    String Student = "Student: "+message.getUserName();
                    String Courses = "Courses "+user.getRegList().toString();
                    return ("ACK "+message.getOptcode()+"\n"+Student+"\n"+Courses+'\0').getBytes();
                case 9://IsRegistered
                    String isRegistered = "NOT REGISTERED";
                    if(user.isRegister(message.getCourseNumber())){
                        isRegistered = "REGISTERED";
                    }
                    return ("ACK "+message.getOptcode()+"\n"+isRegistered+'\0').getBytes();
                case 11://MyCourses
                    String registeredTo = user.getRegList().toString();
                    return ("ACK "+message.getOptcode()+"\n"+registeredTo+'\0').getBytes();
            }
        }
        return null;
    }

    private void pushByte(byte nextByte) {
        if (len >= bytes.length) {
            bytes = Arrays.copyOf(bytes, len * 2);
        }
        bytes[len++] = nextByte;
    }
    public short bytesToShort(byte[] byteArr, int len)
    {
        short result = (short)((byteArr[len] & 0xff) << 8);
        result += (short)(byteArr[len+1] & 0xff);
        return result;
    }
}
