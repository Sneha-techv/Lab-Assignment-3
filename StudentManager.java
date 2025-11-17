import java.util.*;

public class StudentManager implements RecordActions {
    private Map<Integer, Student> db = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent() throws Exception {
        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) throw new Exception("Name cannot be empty!");

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            Double marks = Double.parseDouble(sc.nextLine());
            if (marks < 0 || marks > 100) throw new Exception("Marks must be between 0 and 100!");

            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            Student s = new Student(roll, name, email, course, marks);
            db.put(roll, s);

            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format! " + e.getMessage());
        } finally {
            System.out.println("Add operation completed.");
        }
    }

    @Override
    public void displayStudent(Integer rollNo) throws Exception {
        if (!db.containsKey(rollNo)) {
            throw new StudentNotFoundException("Student with Roll No " + rollNo + " not found!");
        }

        Student s = db.get(rollNo);
        System.out.println("Roll No: " + s.getRollNo());
        System.out.println("Name: " + s.getName());
        System.out.println("Email: " + s.getEmail());
        System.out.println("Course: " + s.getCourse());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Grade: " + s.getGrade());
    }
}
