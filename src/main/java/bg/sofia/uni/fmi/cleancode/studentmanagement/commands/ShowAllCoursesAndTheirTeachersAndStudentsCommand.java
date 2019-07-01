package bg.sofia.uni.fmi.cleancode.studentmanagement.commands;

import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;

public class ShowAllCoursesAndTheirTeachersAndStudentsCommand implements Command {
    @Override
    public void execute(School school) {
        school.showAllCoursesAndTheirTeachersAndStudents();
    }
}
