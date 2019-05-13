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
    public void testAddTeacher() {
        School school = new School();
        school.addTeacher(new Teacher("Bogomil", Degree.BSc));

        Assert.assertTrue(school.getTeachers().containsKey("Bogomil"));
    }

    @Test
    public void testAddTeacherToCourse() {
    }

    @Test
    public void testAddStudentToCourse() {
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