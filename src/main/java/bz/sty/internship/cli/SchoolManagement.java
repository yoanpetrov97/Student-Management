package bz.sty.internship.cli;

import bz.sty.internship.course.Course;
import bz.sty.internship.school.School;
import bz.sty.internship.student.Student;
import bz.sty.internship.teacher.Degree;
import bz.sty.internship.teacher.Teacher;

import java.util.Scanner;

public class SchoolManagement {
    private static final String WRONG_FORMAT_ERROR_MESSAGE = "Wrong format! Try again.";
    private static School school = new School();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printAvailableOptions();

        String currentLine;
        while (!"q".equalsIgnoreCase(currentLine = scanner.nextLine()) && currentLine != null) {
            switch (currentLine) {
                case "0":
                    addNewCourse();
                    break;
                case "1":
                    addNewStudent();
                    break;
                case "2":
                    addNewTeacher();
                    break;
                case "3":
                    addTeacherToCourse();
                    break;
                case "4":
                    addStudentToCourse();
                    break;
                case "5":
                    addGradeForStudentInCourse();
                    break;
                case "6":
                    school.showAllStudents();
                    break;
                case "7":
                    school.showAllCoursesAndTheirTeachersAndStudents();
                    break;
                case "8":
                    showAverageGradeForAllStudentsInCourse();
                    break;
                case "9":
                    showAverageGradeForAllCourses();
                    break;
                default:
                    System.out.println("Wrong command! Enter an integer number from 0 to 9 or q to quit.");
            }
            printAvailableOptions();
        }
    }

    private static void printAvailableOptions() {
        System.out.println("q - exit\n" +
                "0 - Add a new course\n" +
                "1 - Add a new student\n" +
                "2 - Add a new teacher\n" +
                "3 - Add a teacher to a specific course (max 1)\n" +
                "4 - Add a student to a specific course\n" +
                "5 - Add a grade for student in a specific course (grade 2.0-6.0)\n" +
                "6 - Show all students grouped by course (alphabetically) and then by their " +
                "average grade for the course (ascending)\n" +
                "7 - Show all courses and their teachers and students (without grades)\n" +
                "8 - Show the average grade for all students in a specific course\n" +
                "9 - Show a total average grade for student (between all of his courses)\n");
    }

    private static void addNewCourse() {
        System.out.println("Enter the name of the course you want to add:");

        try {
            final String name = scanner.nextLine();

            System.out.println("Enter the total hours of the course you want to add:");

            final int totalHours = Integer.parseInt(scanner.nextLine());

            school.addCourse(new Course(name, totalHours));
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void addNewStudent() {
        System.out.println("Enter the name of the student you want to add:");

        try {
            final String name = scanner.nextLine();

            System.out.println("Enter the age of the student you want to add:");

            final int age = Integer.parseInt(scanner.nextLine());

            school.addStudent(new Student(name, age));
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void addNewTeacher() {
        System.out.println("Enter the name of the teacher you want to add:");

        try {
            final String name = scanner.nextLine();

            getTeachersDegree(name);
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void getTeachersDegree(String name) {
        try {
            System.out.println("Enter the teacher's degree:\n" +
                    "1 - MSc\n" +
                    "2 - BSc\n" +
                    "3 - PhD");

            final String degree = scanner.nextLine();

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

            }

            school.addTeacher(new Teacher(name, teacherDegree));

        } catch (Exception e) {
            System.out.println("Usage: <degree>\n" +
                    "Possible degrees are:\n" +
                    "\t1 - MSc\n" +
                    "\t2 - BSc\n" +
                    "\t3 - PhD");
        }
    }

    private static void addTeacherToCourse() {
        System.out.println("Enter the teacher's name:");

        try {
            final String teacherName = scanner.nextLine();

            System.out.println("Enter the name of the course:");

            final String courseName = scanner.nextLine();

            if (school.getTeachers().get(teacherName) == null) {
                System.out.printf("The teacher %s isn't added to the school.\n", teacherName);
            }

            if (school.getCourses().get(courseName) == null) {
                System.out.printf("The course %s isn't added to the school.\n", courseName);
            }

            if (school.getTeachers().get(teacherName) != null && school.getCourses().get(courseName) != null) {
                school.addTeacherToCourse(school.getTeachers().get(teacherName), school.getCourses().get(courseName));
            }
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void addStudentToCourse() {
        System.out.println("Enter the student's name:");

        try {
            final String studentName = scanner.nextLine();

            System.out.println("Enter the name of the course:");

            final String courseName = scanner.nextLine();

            if (school.getStudents().get(studentName) == null) {
                System.out.printf("The student %s isn't added to the school.\n", studentName);
            }

            if (school.getCourses().get(courseName) == null) {
                System.out.printf("The course %s isn't added to the school.\n", courseName);
            }

            if (school.getStudents().get(studentName) != null && school.getCourses().get(courseName) != null) {
                school.addStudentToCourse(school.getStudents().get(studentName), school.getCourses().get(courseName));
            }
        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }


    private static void addGradeForStudentInCourse() {
        System.out.println("Enter the student's name:");

        try {
            final String studentName = scanner.nextLine();

            System.out.println("Enter the name of the course:");

            final String courseName = scanner.nextLine();

            System.out.printf("Enter %s's grade in the course %s:\n", studentName, courseName);

            final double grade = Integer.parseInt(scanner.nextLine());

            school.addGradeForStudentInCourse(grade, school.getStudents().get(studentName),
                    school.getCourses().get(courseName));

        } catch (Exception e) {
            System.out.println(WRONG_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void showAverageGradeForAllStudentsInCourse() {
        System.out.println("Enter the name of the course:");

        try {
            final String courseName = scanner.nextLine();

            school.showAverageGradeForAllStudentsInCourse(school.getCourses().get(courseName));
        } catch (Exception e) {
            System.out.println("Usage: <course_name>");
        }
    }

    private static void showAverageGradeForAllCourses() {
        System.out.println("Enter the student's name:");

        try {
            final String studentName = scanner.nextLine();

            school.showAverageGradeForAllCourses(school.getStudents().get(studentName));
        } catch (Exception e) {
            System.out.println("Usage: <student_name>");
        }
    }
}
