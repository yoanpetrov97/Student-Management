package bg.sofia.uni.fmi.cleancode.studentmanagement;

import bg.sofia.uni.fmi.cleancode.studentmanagement.commands.Command;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;

public class ShowAllCoursesAndTheirTeachersAndStudentsCommand implements Command {
    @Override
    public void execute(School school) {
        school.showAllCoursesAndTheirTeachersAndStudents();
    }
}
