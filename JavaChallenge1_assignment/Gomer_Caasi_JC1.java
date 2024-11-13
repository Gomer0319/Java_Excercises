public class Gomer_Caasi_JC1 {
    public static void main(String[] args) {

        // challenge 1
        System.out.println("Welcome to JAVA Programming!");

        // challenge 2
        int a = 9;
        int b = 2;
        int addition = a + b;
        int subtraction = a - b;
        int multiplication = a * b;
        int division = a / b;
        int remainder = a % b;
        System.out.println(addition);
        System.out.println(subtraction);
        System.out.println(multiplication);
        System.out.println(division);
        System.out.println(remainder);

        // challenge 3
        int z = 20;
        z += 10;
        System.out.println("After +=10: " + z);
        z -= 5;
        System.out.println("After -=5: " + z);
        z *= 2;
        System.out.println("After *=2: " + z);
        z /= 3;
        System.out.println("After /=4: " + z);
        z %= 4;
        System.out.println("After %=3: " + z);

        // challenge 4
        int score = 10;
        System.out.println("Using pre-increment:");
        System.out.println("Before pre-increment: " + score);
        System.out.println("After pre-increment: " + ++score);
        System.out.println("Before post-increment: " + score);
        System.out.println("After post-increment: " + score++);
        System.out.println("Final score after both increments: " + score);

        // challenge 5
        // values of a and b from challenge 2
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // challenge 6
        boolean isSunny = true;
        boolean isWeekend = false;
        System.out.println("Is today sunny? " + (isSunny && isWeekend));
        System.out.println("Is today sunny? " + (isSunny || isWeekend));
        System.out.println("Is today sunny? " + (!isSunny));

        // challenge 7
        int result = 10 + 5 * 3 - 2 / 1; // expected result is 23 (followed the MDAS rule)
        System.out.println("Result: " + result);

        // challenge 8
        int x = 5;
        int y = 10;
        int w = ++x + y-- - x;
        System.out.println("x: " + x); // 6
        System.out.println("y: " + y); // 9
        System.out.println("w: " + w); // 10

        // challenge 9
        double m = 8.5;
        int n = 3;
        m += n;
        System.out.println("m: " + m);// 11.5
    }
}