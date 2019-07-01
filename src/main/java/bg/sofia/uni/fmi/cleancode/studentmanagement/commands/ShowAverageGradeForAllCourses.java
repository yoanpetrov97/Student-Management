package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.STUDENT_NAME_MESSAGE;
import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.WRONG_STUDENT_MESSAGE;

public class ShowAverageGradeForAllCourses implements Command {
    @Override
    public void execute(School school) {

        System.out.println(STUDENT_NAME_MESSAGE);

        final String studentName = AppIO.getSystemScanner().nextLine();

        if (school.getStudents().get(studentName) == null) {
            System.out.printf(WRONG_STUDENT_MESSAGE, studentName);
        } else {
            school.showAverageGradeForAllCourses(school.getStudents().get(studentName));
        }
    }
}
