package bg.sofia.uni.fmi.cleancode.studentmanagement.utils;

public class CommandMessages {
    public static final String WRONG_MENU_OPTION_MESSAGE;
    public static final String WRONG_FORMAT_ERROR_MESSAGE;
    public static final String ADD_COURSE_NAME_MESSAGE;
    public static final String ADD_COURSE_HOURS_MESSAGE;
    public static final String ADD_STUDENT_NAME_MESSAGE;
    public static final String ADD_STUDENT_AGE_MESSAGE;
    public static final String ADD_TEACHER_NAME_MESSAGE;
    public static final String ADD_TEACHER_DEGREE_MESSAGE;
    public static final String WRONG_DEGREE_MESSAGE;
    public static final String TEACHER_NAME_MESSAGE;
    public static final String COURSE_NAME_MESSAGE;
    public static final String WRONG_TEACHER_MESSAGE;
    public static final String WRONG_COURSE_MESSAGE;
    public static final String STUDENT_NAME_MESSAGE;
    public static final String WRONG_STUDENT_MESSAGE;
    public static final String STUDENT_COURSE_GRADE_MESSAGE;
    public static final String WRONG_GRADE_FORMAT_MESSAGE;
    public static final String MENU_OPTIONS;

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
    }
}
