package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.*;
import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.WRONG_COURSE_MESSAGE;

public class AddTeacherToCourseCommand implements Command {
    @Override
    public void execute(School school) {

        System.out.println(TEACHER_NAME_MESSAGE);

        final String teacherName = AppIO.getSystemScanner().nextLine();

        System.out.println(COURSE_NAME_MESSAGE);

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getTeachers().get(teacherName) == null) {
            System.out.printf(WRONG_TEACHER_MESSAGE, teacherName);
        }

        if (school.getCourses().get(courseName) == null) {
            System.out.printf(WRONG_COURSE_MESSAGE, courseName);
        }

        if (school.getTeachers().get(teacherName) != null && school.getCourses().get(courseName) != null) {
            school.addTeacherToCourse(school.getTeachers().get(teacherName), school.getCourses().get(courseName));
        }
    }
}
