package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Course;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.*;

public class AddNewCourseCommand implements Command {
    @Override
    public void execute(School school) {
        System.out.println(ADD_COURSE_NAME_MESSAGE);

        try {
            final String name = AppIO.getSystemScanner().nextLine();

            System.out.println(ADD_COURSE_HOURS_MESSAGE);

            final int totalHours = Integer.parseInt(AppIO.getSystemScanner().nextLine());

            school.addCourse(new Course(name, totalHours));
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }
}
