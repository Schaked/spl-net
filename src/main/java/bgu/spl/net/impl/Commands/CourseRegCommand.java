package bgu.spl.net.impl.Commands;

import bgu.spl.net.impl.BgrsProtocol;
import bgu.spl.net.srv.Course;

public class CourseRegCommand extends Command {
    private Integer courseNumber;

    public CourseRegCommand(short optcode, int CourseNumber) {
        super(optcode, CourseNumber);
        courseNumber = CourseNumber;
    }

    @Override
    protected Command execute(BgrsProtocol protocol) {
        if((database.getCoursesList().contains(courseNumber))||(database.getCourseHashMap().get(courseNumber).getNumOfMaxStudent()<=0)){//missing Kdam and login
            return null;//Err
        } else {

            return null;//Ack
        }
    }
}
