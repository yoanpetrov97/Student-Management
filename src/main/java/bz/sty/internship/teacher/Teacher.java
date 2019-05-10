package bz.sty.internship.teacher;

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
