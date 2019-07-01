package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Student;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.*;

public class AddNewStudentCommand implements Command {
    @Override
    public void execute(School school) {
        System.out.println(ADD_STUDENT_NAME_MESSAGE);

        try {
            final String name = AppIO.getSystemScanner().nextLine();

            System.out.println(ADD_STUDENT_AGE_MESSAGE);

            final int age = Integer.parseInt(AppIO.getSystemScanner().nextLine());

            school.addStudent(new Student(name, age));
        } catch (NumberFormatException e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }
}
