package bz.sty.internship.school;

import bz.sty.internship.course.Course;
import bz.sty.internship.student.Student;
import bz.sty.internship.teacher.Degree;
import bz.sty.internship.teacher.Teacher;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        Assert.assertEquals(school.getCourses().get("Java").getTeacher(), exampleTeacher);
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

        Assert.assertNull(school.getCourses().get("Java").getTeacher());
    }

    @Test
    public void testAddStudentToCourse() {
        School school = new School();
        Student exampleStudent = new Student("Yoan", 21);
        Course exampleCourse = new Course("Java", 60);
        school.addStudent(exampleStudent);
        school.addCourse(exampleCourse);
        school.addStudentToCourse(exampleStudent, exampleCourse);

        Assert.assertTrue(school.getCourses().get("Java").getStudents().contains(exampleStudent));
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

        Assert.assertTrue(school.getCourses().get("Java").getStudents().isEmpty());
    }

    @Test
    public void testAddGradeForStudentInCourse() {
    }

    @Test
    public void testShowAllStudents() {
    }

    @Test
    public void testShowAllCoursesAndTheirTeachersAndStudents() {
    }

    @Test
    public void testShowAverageGradeForAllStudentsInCourse() {
    }

    @Test
    public void testShowAverageGradeForAllCourses() {
    }
}