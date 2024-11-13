public class Array1 {
    public static void main(String[] args) {
        // One Dimensional Array declaration 1
        int[] a = new int[5];
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[3] = 40;
        a[4] = 50;
        System.out.println(a[3]); // result is 40

        // One Dimensional Array declaration 2
        int[] b = { 10, 20, 30, 40, 50 };
        System.out.println(b[3]); // result is 40

        // Two Dimensional Array declaration 1
        int[][] c = new int[3][3];
        c[0][0] = 10;
        c[0][1] = 20;
        c[0][2] = 30;
        c[1][0] = 40;
        c[1][1] = 50;
        c[1][2] = 60;
        c[2][0] = 70;
        c[2][1] = 80;
        c[2][2] = 90;
        System.out.println(c[2][1]); // result is 80

        // Two Dimensional Array declaration 2
        int[][] d = {
                { 10, 20, 30 },
                { 40, 50, 60 },
                { 70, 80, 90 }
        };
        System.out.println(d[1][2]); // result is 60

    }
}