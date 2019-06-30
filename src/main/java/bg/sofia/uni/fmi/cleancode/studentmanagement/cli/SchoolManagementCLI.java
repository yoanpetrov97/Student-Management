package bg.sofia.uni.fmi.cleancode.studentmanagement.cli;

import bg.sofia.uni.fmi.cleancode.studentmanagement.io.AppIO;
import bg.sofia.uni.fmi.cleancode.studentmanagement.course.Course;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Student;
import bg.sofia.uni.fmi.cleancode.studentmanagement.enums.Degree;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Teacher;

public class SchoolManagementCLI {
    private static final String WRONG_FORMAT_ERROR_MESSAGE = "Wrong format! Try again.";
    private School school = new School();

    private static SchoolManagementCLI instance;

    static {
        instance = new SchoolManagementCLI();
    }

    public static SchoolManagementCLI getInstance() {
        return instance;
    }

    public void run() {
        printAvailableOptions();

        String currentLine = AppIO.getSystemScanner().nextLine();

        while (!"q".equalsIgnoreCase(currentLine.trim()) && !"exit".equalsIgnoreCase(currentLine.trim())) {
            switch (currentLine.trim()) {
                case "1":
                    addNewCourse();
                    break;
                case "2":
                    addNewStudent();
                    break;
                case "3":
                    addNewTeacher();
                    break;
                case "4":
                    addTeacherToCourse();
                    break;
                case "5":
                    addStudentToCourse();
                    break;
                case "6":
                    addGradeForStudentInCourse();
                    break;
                case "7":
                    school.showAllStudents();
                    break;
                case "8":
                    school.showAllCoursesAndTheirTeachersAndStudents();
                    break;
                case "9":
                    showAverageGradeForAllStudentsInCourse();
                    break;
                case "10":
                    showAverageGradeForAllCourses();
                    break;
                default:
                    System.out.println("Wrong command! Enter an integer number from 0 to 9 or q to quit.");
            }

            printAvailableOptions();

            currentLine = AppIO.getSystemScanner().nextLine();
        }
    }

    private void printAvailableOptions() {
        System.out.println("q - exit\n" +
                "1 - Add a new course\n" +
                "2 - Add a new student\n" +
                "3 - Add a new teacher\n" +
                "4 - Add a teacher to a specific course (max 1)\n" +
                "5 - Add a student to a specific course\n" +
                "6 - Add a grade for student in a specific course (grade 2.0-6.0)\n" +
                "7 - Show all students grouped by course (alphabetically) and then by their " +
                "average grade for the course (ascending)\n" +
                "8 - Show all courses and their teachers and students (without grades)\n" +
                "9 - Show the average grade for all students in a specific course\n" +
                "10 - Show a total average grade for student (between all of his courses)\n");
    }

    private void addNewCourse() {
        System.out.println("Enter the name of the course you want to add:");

        try {
            final String name = AppIO.getSystemScanner().nextLine();

            System.out.println("Enter the total hours of the course you want to add:");

            final int totalHours = Integer.parseInt(AppIO.getSystemScanner().nextLine());

            school.addCourse(new Course(name, totalHours));
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private void addNewStudent() {
        System.out.println("Enter the name of the student you want to add:");

        try {
            final String name = AppIO.getSystemScanner().nextLine();

            System.out.println("Enter the age of the student you want to add:");

            final int age = Integer.parseInt(AppIO.getSystemScanner().nextLine());

            school.addStudent(new Student(name, age));
        } catch (NumberFormatException e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private void addNewTeacher() {
        System.out.println("Enter the name of the teacher you want to add:");

        final String name = AppIO.getSystemScanner().nextLine();

        getTeachersDegree(name);
    }

    private void getTeachersDegree(String name) {

        System.out.println("Enter the teacher's degree:\n" +
                "1 - MSc\n" +
                "2 - BSc\n" +
                "3 - PhD");

        final String degree = AppIO.getSystemScanner().nextLine();

        Degree teacherDegree = null;

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
                System.out.println("Enter an integer number from {1, 2, 3} or {MSc, BSc, PhD}");

        }

        school.addTeacher(new Teacher(name, teacherDegree));

    }

    private void addTeacherToCourse() {
        System.out.println("Enter the teacher's name:");

        final String teacherName = AppIO.getSystemScanner().nextLine();

        System.out.println("Enter the name of the course:");

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getTeachers().get(teacherName) == null) {
            System.out.printf("The teacher %s isn't added to the school.\n", teacherName);
        }

        if (school.getCourses().get(courseName) == null) {
            System.out.printf("The course %s isn't added to the school.\n", courseName);
        }

        if (school.getTeachers().get(teacherName) != null && school.getCourses().get(courseName) != null) {
            school.addTeacherToCourse(school.getTeachers().get(teacherName), school.getCourses().get(courseName));
        }
    }

    private void addStudentToCourse() {
        System.out.println("Enter the student's name:");

        final String studentName = AppIO.getSystemScanner().nextLine();

        System.out.println("Enter the name of the course:");

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getStudents().get(studentName) == null) {
            System.out.printf("The student %s isn't added to the school.\n", studentName);
        }

        if (school.getCourses().get(courseName) == null) {
            System.out.printf("The course %s isn't added to the school.\n", courseName);
        }

        if (school.getStudents().get(studentName) != null && school.getCourses().get(courseName) != null) {
            school.addStudentToCourse(school.getStudents().get(studentName), school.getCourses().get(courseName));
        }
    }


    private void addGradeForStudentInCourse() {
        System.out.println("Enter the student's name:");

        try {
            final String studentName = AppIO.getSystemScanner().nextLine();

            System.out.println("Enter the name of the course:");

            final String courseName = AppIO.getSystemScanner().nextLine();

            System.out.printf("Enter %s's grade in the course %s:\n", studentName, courseName);

            final double grade = Double.parseDouble(AppIO.getSystemScanner().nextLine());


            if (school.getStudents().get(studentName) == null) {
                System.out.printf("The student %s isn't added to the school.\n", studentName);
            }

            if (school.getCourses().get(courseName) == null) {
                System.out.printf("The course %s isn't added to the school.\n", courseName);
            }

            if (grade < 2.0 || grade > 6.0) {
                System.out.println("The grade must be a floating point number in the interval [2.0-6.0]");
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

    private void showAverageGradeForAllStudentsInCourse() {
        System.out.println("Enter the name of the course:");

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getCourses().get(courseName) == null) {
            System.out.printf("The course %s isn't added to the school.\n", courseName);
        } else {
            school.showAverageGradeForAllStudentsInCourse(school.getCourses().get(courseName));
        }
    }

    private void showAverageGradeForAllCourses() {
        System.out.println("Enter the student's name:");

        final String studentName = AppIO.getSystemScanner().nextLine();

        if (school.getStudents().get(studentName) == null) {
            System.out.printf("The student %s isn't added to the school.\n", studentName);
        } else {
            school.showAverageGradeForAllCourses(school.getStudents().get(studentName));
        }
    }
}
