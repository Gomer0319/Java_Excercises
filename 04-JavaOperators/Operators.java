public class Operators {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        // Arithmetic Operators
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        // compound(assignment) operators
        a += b;
        System.out.println(a);
        a -= b;
        System.out.println(a);
        a *= b;
        System.out.println(a);
        a /= b;
        System.out.println(a);
        a %= b;

        // increment (pre and post)
        int c = 1;
        System.out.println("Pre and post increment: ");
        System.out.println(c);
        System.out.println(++c);
        System.out.println(c++);
        System.out.println(c);

        // decrement (pre and post)
        int d = 1;
        System.out.println("Pre and post decrement: ");
        System.out.println(d);
        System.out.println(--d);
        System.out.println(d--);
        System.out.println(d);

        // relational operators
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        // logical operators
        boolean aa = true;
        boolean bb = false;

        System.out.println("aa && bb: " + (aa && bb)); // Outputs: false
        System.out.println("aa || bb: " + (aa || bb)); // Outputs: true
        System.out.println("!aa: " + (!aa)); // Outputs: false

    }
}