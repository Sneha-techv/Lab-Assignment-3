public class Student {
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public Integer getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public Double getMarks() { return marks; }

    public String getGrade() {
        double m = marks;
        if (m >= 90) return "A";
        else if (m >= 75) return "B";
        else if (m >= 60) return "C";
        else if (m >= 40) return "D";
        else return "F";
    }
}
