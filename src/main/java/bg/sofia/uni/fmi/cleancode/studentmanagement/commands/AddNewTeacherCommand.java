package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Teacher;
import bg.sofia.uni.fmi.cleancode.studentmanagement.enums.Degree;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.*;
import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.WRONG_DEGREE_MESSAGE;

public class AddNewTeacherCommand implements Command {
    @Override
    public void execute(School school) {

        System.out.println(ADD_TEACHER_NAME_MESSAGE);

        final String name = AppIO.getSystemScanner().nextLine();

        school.addTeacher(new Teacher(name, getTeachersDegree(name)));
    }

    private Degree getTeachersDegree(String name) {

        System.out.println(ADD_TEACHER_DEGREE_MESSAGE);

        final String degree = AppIO.getSystemScanner().nextLine();

        Degree teacherDegree = null;

        while (teacherDegree == null) {
            switch (degree) {
                case "1":
                case "MSc":
                    teacherDegree = Degree.MSc;
                    break;
                case "2":
                case "BSc":
                    teacherDegree = Degree.BSc;
                    break;
                case "3":
                case "PhD":
                    teacherDegree = Degree.PhD;
                    break;
                default:
                    System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
                    System.out.println(WRONG_DEGREE_MESSAGE);
            }
        }

        return teacherDegree;
    }
}
