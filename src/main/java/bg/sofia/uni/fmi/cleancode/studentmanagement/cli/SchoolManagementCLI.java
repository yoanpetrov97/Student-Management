package bg.sofia.uni.fmi.cleancode.studentmanagement.cli;

import bg.sofia.uni.fmi.cleancode.studentmanagement.cli.io.AppIO;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Course;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.School;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Student;
import bg.sofia.uni.fmi.cleancode.studentmanagement.enums.Degree;
import bg.sofia.uni.fmi.cleancode.studentmanagement.entities.Teacher;

public class SchoolManagementCLI {
    private static final String WRONG_MENU_OPTION_MESSAGE;
    private static final String WRONG_FORMAT_ERROR_MESSAGE;
    private static final String ADD_COURSE_NAME_MESSAGE;
    private static final String ADD_COURSE_HOURS_MESSAGE;
    private static final String ADD_STUDENT_NAME_MESSAGE;
    private static final String ADD_STUDENT_AGE_MESSAGE;
    private static final String ADD_TEACHER_NAME_MESSAGE;
    private static final String ADD_TEACHER_DEGREE_MESSAGE;
    private static final String WRONG_DEGREE_MESSAGE;
    private static final String TEACHER_NAME_MESSAGE;
    private static final String COURSE_NAME_MESSAGE;
    private static final String WRONG_TEACHER_MESSAGE;
    private static final String WRONG_COURSE_MESSAGE;
    private static final String STUDENT_NAME_MESSAGE;
    private static final String WRONG_STUDENT_MESSAGE;
    private static final String STUDENT_COURSE_GRADE_MESSAGE;
    private static final String WRONG_GRADE_FORMAT_MESSAGE;
    private static final String MENU_OPTIONS;
    private School school;

    private static SchoolManagementCLI instance;

    static {
        MENU_OPTIONS = "q - exit\n" +
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
                "10 - Show a total average grade for student (between all of his courses)\n";
        WRONG_GRADE_FORMAT_MESSAGE = "The grade must be a floating point number in the interval [2.0-6.0]";
        STUDENT_COURSE_GRADE_MESSAGE = "Enter %s's grade in the course %s:\n";
        WRONG_STUDENT_MESSAGE = "The student %s isn't added to the school.\n";
        STUDENT_NAME_MESSAGE = "Enter the student's name:";
        WRONG_COURSE_MESSAGE = "The course %s isn't added to the school.\n";
        WRONG_TEACHER_MESSAGE = "The teacher %s isn't added to the school.\n";
        COURSE_NAME_MESSAGE = "Enter the name of the course:";
        TEACHER_NAME_MESSAGE = "Enter the teacher's name:";
        WRONG_DEGREE_MESSAGE = "Enter an integer number from {1, 2, 3} or {MSc, BSc, PhD}";
        ADD_TEACHER_DEGREE_MESSAGE = "Enter the teacher's degree:\n1 - MSc\n2 - BSc\n3 - PhD";
        ADD_TEACHER_NAME_MESSAGE = "Enter the name of the teacher you want to add:";
        ADD_STUDENT_AGE_MESSAGE = "Enter the age of the student you want to add:";
        ADD_STUDENT_NAME_MESSAGE = "Enter the name of the student you want to add:";
        ADD_COURSE_HOURS_MESSAGE = "Enter the total hours of the course you want to add:";
        ADD_COURSE_NAME_MESSAGE = "Enter the name of the course you want to add:";
        WRONG_MENU_OPTION_MESSAGE = "Wrong command! Enter an integer number from 0 to 9 or q to quit.";
        WRONG_FORMAT_ERROR_MESSAGE = "Wrong format! Try again.";
        instance = new SchoolManagementCLI();
    }

    private SchoolManagementCLI() {
        school = new School();
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
                    System.out.println(WRONG_MENU_OPTION_MESSAGE);
            }

            printAvailableOptions();

            currentLine = AppIO.getSystemScanner().nextLine();
        }

        AppIO.closeScanner();
    }

    private void printAvailableOptions() {
        System.out.println(MENU_OPTIONS);
    }

    private void addNewCourse() {
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

    private void addNewStudent() {
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

    private void addNewTeacher() {
        System.out.println(ADD_TEACHER_NAME_MESSAGE);

        final String name = AppIO.getSystemScanner().nextLine();

        getTeachersDegree(name);
    }

    private void getTeachersDegree(String name) {

        System.out.println(ADD_TEACHER_DEGREE_MESSAGE);

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
                System.out.println(WRONG_DEGREE_MESSAGE);
        }

        school.addTeacher(new Teacher(name, teacherDegree));

    }

    private void addTeacherToCourse() {
        System.out.println(TEACHER_NAME_MESSAGE);

        final String teacherName = AppIO.getSystemScanner().nextLine();

        System.out.println(COURSE_NAME_MESSAGE);

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getTeachers().get(teacherName) == null) {
            System.out.printf(WRONG_TEACHER_MESSAGE, teacherName);
        }

        if (school.getCourses().get(courseName) == null) {
            System.out.printf(WRONG_COURSE_MESSAGE, courseName);
        }

        if (school.getTeachers().get(teacherName) != null && school.getCourses().get(courseName) != null) {
            school.addTeacherToCourse(school.getTeachers().get(teacherName), school.getCourses().get(courseName));
        }
    }

    private void addStudentToCourse() {
        System.out.println(STUDENT_NAME_MESSAGE);

        final String studentName = AppIO.getSystemScanner().nextLine();

        System.out.println(COURSE_NAME_MESSAGE);

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getStudents().get(studentName) == null) {
            System.out.printf(WRONG_STUDENT_MESSAGE, studentName);
        }

        if (school.getCourses().get(courseName) == null) {
            System.out.printf(WRONG_COURSE_MESSAGE, courseName);
        }

        if (school.getStudents().get(studentName) != null && school.getCourses().get(courseName) != null) {
            school.addStudentToCourse(school.getStudents().get(studentName), school.getCourses().get(courseName));
        }
    }


    private void addGradeForStudentInCourse() {
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

    private void showAverageGradeForAllStudentsInCourse() {
        System.out.println(COURSE_NAME_MESSAGE);

        final String courseName = AppIO.getSystemScanner().nextLine();

        if (school.getCourses().get(courseName) == null) {
            System.out.printf(WRONG_COURSE_MESSAGE, courseName);
        } else {
            school.showAverageGradeForAllStudentsInCourse(school.getCourses().get(courseName));
        }
    }

    private void showAverageGradeForAllCourses() {
        System.out.println(STUDENT_NAME_MESSAGE);

        final String studentName = AppIO.getSystemScanner().nextLine();

        if (school.getStudents().get(studentName) == null) {
            System.out.printf(WRONG_STUDENT_MESSAGE, studentName);
        } else {
            school.showAverageGradeForAllCourses(school.getStudents().get(studentName));
        }
    }
}
