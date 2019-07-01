package bg.sofia.uni.fmi.cleancode.studentmanagement;

import bg.sofia.uni.fmi.cleancode.studentmanagement.commands.*;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;

import java.util.HashMap;
import java.util.Map;

import static bg.sofia.uni.fmi.cleancode.studentmanagement.utils.CommandMessages.MENU_OPTIONS;

public class SchoolManagementCLI {
    private static SchoolManagementCLI instance;

    static {
        instance = new SchoolManagementCLI();
    }

    public static SchoolManagementCLI getInstance() {
        return instance;
    }

    private School school;
    private Map<String, Command> commands;

    private SchoolManagementCLI() {
        this.school = new School();
        this.commands = new HashMap<>();
        this.initCommands();
    }

    public void initCommands() {
        this.commands.put("1", new AddNewCourseCommand());
        this.commands.put("2", new AddNewStudentCommand());
        this.commands.put("3", new AddNewTeacherCommand());
        this.commands.put("4", new AddTeacherToCourseCommand());
        this.commands.put("5", new AddStudentToCourseCommand());
        this.commands.put("6", new AddGradeForStudentInCourseCommand());
        this.commands.put("7", new ShowAllStudentsCommand());
        this.commands.put("8", new ShowAllCoursesAndTheirTeachersAndStudentsCommand());
        this.commands.put("9", new ShowAverageGradeForAllStudentsInCourseCommand());
        this.commands.put("10", new ShowAverageGradeForAllCourses());
    }

    public void run() {

        boolean isRunning = true;

        while (isRunning) {
            printAvailableOptions();
            String userChoice = AppIO.getSystemScanner().nextLine();

            if ("q".equalsIgnoreCase(userChoice.trim()) || "exit".equalsIgnoreCase(userChoice.trim())) {
                isRunning = false;
            } else {
                this.commands.get(userChoice).execute(this.school);
            }
        }

        AppIO.closeScanner();
    }

    private void printAvailableOptions() {
        System.out.println(MENU_OPTIONS);
    }
}
