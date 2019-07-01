package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.COURSE_NAME_MESSAGE;
import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.WRONG_COURSE_MESSAGE;

public class ShowAverageGradeForAllStudentsInCourseCommand implements Command {
    @Override
    public void execute(School school) {

        System.out.println(COURSE_NAME_MESSAGE);

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getCourses().get(courseName) == null) {
            System.out.printf(WRONG_COURSE_MESSAGE, courseName);
        } else {
            school.showAverageGradeForAllStudentsInCourse(school.getCourses().get(courseName));
        }
    }
}
