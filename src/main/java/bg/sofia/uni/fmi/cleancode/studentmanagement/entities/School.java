package bg.sofia.uni.fmi.cleancode.studentmanagement.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {
    private Map<String, Teacher> teachers;
    private Map<String, Student> students;
    private Map<String, Course> courses;

    public School() {
        this.teachers = new HashMap<>();
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    /**
     * Adds a new course to the school
     */
    public void addCourse(Course course) {
        if (course != null) {
            this.courses.put(course.getName(), course);
        }
    }

    /**
     * Adds a new student to the school
     */
    public void addStudent(Student student) {
        if (student != null) {
            this.students.put(student.getName(), student);
        }
    }

    /**
     * Adds a new teacher to the school
     */
    public void addTeacher(Teacher teacher) {
        if (teacher != null) {
            this.teachers.put(teacher.getName(), teacher);
        }
    }

    /**
     * Adds a teacher to a specific course (max 1)
     */
    public void addTeacherToCourse(Teacher teacher, Course course) {
        if (teacher != null && course != null) {
            course.setTeacher(teacher);
        }
    }

    /**
     * Adds a student to a specific course
     */
    public void addStudentToCourse(Student student, Course course) {
        if (student != null && course != null) {
            course.addStudent(student);
        }
    }

    /**
     * Adds a grade for student in a specific course. (grade 2.0-6.0)
     */
    public void addGradeForStudentInCourse(double grade, Student student, Course course) {
        final int minPossibleGrade = 2;
        final int maxPossibleGrade = 6;
        if (grade >= minPossibleGrade && grade <= maxPossibleGrade && student != null && course != null) {
            course.addGradeForStudent(grade, student);
        }
    }

    /**
     * Shows all students grouped by course (alphabetically) and then by their average grade for the course
     * (ascending).
     */
    public void showAllStudents() {
        courses.values().stream().sorted(Comparator.comparing(Course::getName))
                .forEach(course -> course.getStudents()
                        .stream().sorted(Comparator.comparing(course::getStudentAverageGrade))
                        .forEach(student -> printStudentCourseAndAverageGrade(course, student)));
    }

    private void printStudentCourseAndAverageGrade(Course course, Student student) {
        System.out.printf("Student: %s, Course: %s, Average grade: %f\n",
                student.getName(), course.getName(), course.getStudentAverageGrade(student));
    }

    /**
     * Shows all courses and their teachers and students (without grades)
     */
    public void showAllCoursesAndTheirTeachersAndStudents() {
        courses.values().forEach(this::printTeacherAndStudents);
    }

    private void printTeacherAndStudents(Course course) {
        final String teacher = course.getTeacher() == null ? "N\\A" : course.getTeacher().getName();
        System.out.printf("Course: %s, Teacher: %s, Students: %s\n",
                course.getName(), teacher, course.getStudents());
    }

    /**
     * Shows the average grade for all students in a specific course
     */
    public void showAverageGradeForAllStudentsInCourse(Course course) {
        System.out.println(course.getAverageGradeForAllStudents());
    }

    /**
     * Shows a total average grade for student (between all of his courses).
     */
    public void showAverageGradeForAllCourses(Student student) {
        System.out.println(getAverageGradeForAllCourses(student));
    }

    private double getAverageGradeForAllCourses(Student student) {
        List<Double> allGrades = new ArrayList<>();
        courses.forEach((courseName, course) -> allGrades.addAll(course.getAllGradesOfStudent(student)));
        return allGrades.stream().reduce(0.0, Double::sum) / allGrades.size();
    }

}
