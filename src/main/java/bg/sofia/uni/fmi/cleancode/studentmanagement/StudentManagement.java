package bg.sofia.uni.fmi.cleancode.studentmanagement;

import bg.sofia.uni.fmi.cleancode.studentmanagement.cli.SchoolManagementCLI;

public class StudentManagement {
    public static void main(String[] args) {
        SchoolManagementCLI.getInstance().run();
    }
}
