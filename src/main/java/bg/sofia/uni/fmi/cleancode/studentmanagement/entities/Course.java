package bg.sofia.uni.fmi.cleancode.studentmanagement.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Course {
    private String name;
    private int totalHours;
    private Teacher teacher;
    private List<Student> students;
    private Map<Student, List<Double>> grades;

    public Course(String name, int totalHours) {
        this();
        this.name = name;
        this.totalHours = totalHours;
    }

    private Course() {
        this.students = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<Student, List<Double>> getGrades() {
        return grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addGradeForStudent(double grade, Student student) {
        final int minGrade = 2;
        final int maxGrade = 6;

        if (grade >= minGrade && grade <= maxGrade) {
            this.grades.putIfAbsent(student, new ArrayList<>());
            this.grades.get(student).add(grade);
        }
    }

    public double getStudentAverageGrade(Student student) {
        if (this.grades.size() == 0) {
            return 0;
        }

        return grades.get(student).stream().reduce(0.0, Double::sum) / this.grades.get(student).size();
    }

    public double getAverageGradeForAllStudents() {
        final List<Double> grades = this.grades.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        final Double sumOfAllGrades = grades.stream().reduce(0.0, Double::sum);
        return sumOfAllGrades / grades.size();
    }

    public List<Double> getAllGradesOfStudent(Student student) {
        return grades.getOrDefault(student, new ArrayList<>());
    }
}
