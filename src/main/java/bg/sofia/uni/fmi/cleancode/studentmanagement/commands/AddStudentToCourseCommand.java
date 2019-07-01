package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.*;
import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.WRONG_COURSE_MESSAGE;

public class AddStudentToCourseCommand implements Command {
    @Override
    public void execute(School school) {

        System.out.println(STUDENT_NAME_MESSAGE);

        final String studentName = AppIO.getSystemScanner().nextLine();

        System.out.println(COURSE_NAME_MESSAGE);

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getStudents().get(studentName) == null) {
            System.out.printf(WRONG_STUDENT_MESSAGE, studentName);
        }

        if (school.getCourses().get(courseName) == null) {
            System.out.printf(WRONG_COURSE_MESSAGE, courseName);
        }

        if (school.getStudents().get(studentName) != null && school.getCourses().get(courseName) != null) {
            school.addStudentToCourse(school.getStudents().get(studentName), school.getCourses().get(courseName));
        }
    }
}
