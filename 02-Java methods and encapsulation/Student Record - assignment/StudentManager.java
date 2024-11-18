class Student {
    // Declare instance variables
    private int studentId;
    protected String name;
    int age;
    public String school;

    // Create a public constructor that initializes the all the fields
    public Student(int sID, String nameStudent, int ageStudent, String schoolStudent) {
        studentId = sID;
        name = nameStudent;
        age = ageStudent;
        school = schoolStudent;
    }

    // Create a display method
    public void display () {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("School: " + school);
    }
}

class StudentManager {
    public static void main(String[] args) {
        // Create an instance of Student using the public constructor
        Student student = new Student(1, "John Doe", 20, "University of XYZ");

        // Call the display method
        student.display();
    }
}
