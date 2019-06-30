package bg.sofia.uni.fmi.cleancode.studentmanagement.entities;

import bg.sofia.uni.fmi.cleancode.studentmanagement.enums.Degree;

public class Teacher {
    public Teacher(String name, Degree degree) {
        this.name = name;
        this.degree = degree;
    }

    private String name;
    private Degree degree;

    public String getName() {
        return name;
    }
}
