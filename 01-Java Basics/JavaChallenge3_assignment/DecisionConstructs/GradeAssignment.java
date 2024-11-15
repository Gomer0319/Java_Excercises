import java.util.Scanner;

public class GradeAssignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Score: ");
        int grade = input.nextInt();
        System.out.println("Entered Score: " + grade);

        if (grade >= 90 && grade <= 100) {
            System.out.println("Grade: A");
        } else if (grade >= 80 && grade <= 89) {
            System.out.println("Grade: B");
        } else if (grade >= 70 && grade <= 79) {
            System.out.println("Grade: C");
        } else if (grade >= 61 && grade <= 69) {
            System.out.println("Grade: D");
        } else if (grade <= 60) {
            System.out.println("Grade: E");
        }
    }
}
