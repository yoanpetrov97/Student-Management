package bg.sofia.uni.fmi.cleancode.studentmanagement.school;

import bg.sofia.uni.fmi.cleancode.studentmanagement.course.Course;
import bg.sofia.uni.fmi.cleancode.studentmanagement.student.Student;
import bg.sofia.uni.fmi.cleancode.studentmanagement.teacher.Degree;
import bg.sofia.uni.fmi.cleancode.studentmanagement.teacher.Teacher;
import org.junit.Assert;
import org.junit.Test;


public class SchoolTest {
    @Test
    public void testAddCourse() {
        School school = new School();
        school.addCourse(new Course("Java", 60));

        Assert.assertTrue(school.getCourses().containsKey("Java"));
    }

    @Test
    public void testAddCourseWithInvalidData() {
        School school = new School();
        school.addCourse(null);

        Assert.assertTrue(school.getCourses().isEmpty());
    }

    @Test
    public void testAddStudent() {
        School school = new School();
        school.addStudent(new Student("Yoan", 21));

        Assert.assertTrue(school.getStudents().containsKey("Yoan"));
    }

    @Test
    public void testAddStudentWithInvalidData() {
        School school = new School();
        school.addStudent(null);

        Assert.assertTrue(school.getStudents().isEmpty());
    }

    @Test
    public void testAddTeacher() {
        School school = new School();
        school.addTeacher(new Teacher("Bogomil", Degree.BSc));

        Assert.assertTrue(school.getTeachers().containsKey("Bogomil"));
    }

    @Test
    public void testAddTeacherWithInvalidData() {
        School school = new School();
        school.addTeacher(null);

        Assert.assertTrue(school.getTeachers().isEmpty());
    }

    @Test
    public void testAddTeacherToCourse() {
        School school = new School();
        Teacher exampleTeacher = new Teacher("Bogomil", Degree.BSc);
        Course exampleCourse = new Course("Java", 60);
        school.addTeacher(exampleTeacher);
        school.addCourse(exampleCourse);
        school.addTeacherToCourse(exampleTeacher, exampleCourse);

        Assert.assertEquals(school.getCourses().get(exampleCourse.getName()).getTeacher(), exampleTeacher);
    }

    @Test
    public void testAddTeacherToCourseWithInvalidData() {
        School school = new School();
        Teacher exampleTeacher = new Teacher("Bogomil", Degree.BSc);
        Course exampleCourse = new Course("Java", 60);
        school.addTeacher(exampleTeacher);
        school.addCourse(exampleCourse);

        school.addTeacherToCourse(null, exampleCourse);
        school.addTeacherToCourse(exampleTeacher, null);
        school.addTeacherToCourse(null, null);

        Assert.assertNull(school.getCourses().get(exampleCourse.getName()).getTeacher());
    }

    @Test
    public void testAddStudentToCourse() {
        School school = new School();
        Student exampleStudent = new Student("Yoan", 21);
        Course exampleCourse = new Course("Java", 60);
        school.addStudent(exampleStudent);
        school.addCourse(exampleCourse);
        school.addStudentToCourse(exampleStudent, exampleCourse);

        Assert.assertTrue(school.getCourses().get(exampleCourse.getName()).getStudents().contains(exampleStudent));
    }

    @Test
    public void testAddStudentToCourseWithInvalidData() {
        School school = new School();
        Student exampleStudent = new Student("Yoan", 21);
        Course exampleCourse = new Course("Java", 60);
        school.addStudent(exampleStudent);
        school.addCourse(exampleCourse);

        school.addStudentToCourse(null, exampleCourse);
        school.addStudentToCourse(exampleStudent, null);
        school.addStudentToCourse(null, null);

        Assert.assertTrue(school.getCourses().get(exampleCourse.getName()).getStudents().isEmpty());
    }

    @Test
    public void testAddGradeForStudentInCourse() {
        School school = new School();
        Student exampleStudent = new Student("Yoan", 21);
        Course exampleCourse = new Course("Java", 60);
        school.addStudent(exampleStudent);
        school.addCourse(exampleCourse);
        school.addStudentToCourse(exampleStudent, exampleCourse);

        school.addGradeForStudentInCourse(6.0, exampleStudent, exampleCourse);
        school.addGradeForStudentInCourse(2.0, exampleStudent, exampleCourse);
        school.addGradeForStudentInCourse(3.0, exampleStudent, exampleCourse);
        school.addGradeForStudentInCourse(4.0, exampleStudent, exampleCourse);


        double[] exampleGrades = new double[]{6.0, 2.0, 3.0, 4.0};

        for (int i = 0; i < exampleGrades.length; i++) {
            Assert.assertEquals(school.getCourses().get(exampleCourse.getName())
                    .getAllGradesOfStudent(exampleStudent).get(i), exampleGrades[i], 0.0001);
        }
    }
}