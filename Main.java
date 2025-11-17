public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        try {
            sm.addStudent();
            sm.displayStudent(102);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}
