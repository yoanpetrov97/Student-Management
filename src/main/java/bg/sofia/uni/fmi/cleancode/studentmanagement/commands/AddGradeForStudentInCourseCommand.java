package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.*;

public class AddGradeForStudentInCourseCommand implements Command {
    @Override
    public void execute(School school) {

        System.out.println(STUDENT_NAME_MESSAGE);

        try {
            final String studentName = AppIO.getSystemScanner().nextLine();

            System.out.println(COURSE_NAME_MESSAGE);

            final String courseName = AppIO.getSystemScanner().nextLine();

            System.out.printf(STUDENT_COURSE_GRADE_MESSAGE, studentName, courseName);

            final double grade = Double.parseDouble(AppIO.getSystemScanner().nextLine());


            if (school.getStudents().get(studentName) == null) {
                System.out.printf(WRONG_STUDENT_MESSAGE, studentName);
            }

            if (school.getCourses().get(courseName) == null) {
                System.out.printf(WRONG_COURSE_MESSAGE, courseName);
            }

            if (grade < 2.0 || grade > 6.0) {
                System.out.println(WRONG_GRADE_FORMAT_MESSAGE);
            }

            if (school.getStudents().get(studentName) != null && school.getCourses().get(courseName) != null
                    && grade >= 2.0 && grade <= 6.0) {
                school.addGradeForStudentInCourse(grade, school.getStudents().get(studentName),
                        school.getCourses().get(courseName));
            }
        } catch (NumberFormatException e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }
}
