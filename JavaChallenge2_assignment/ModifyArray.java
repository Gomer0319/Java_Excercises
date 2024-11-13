public class ModifyArray {
    public static void main(String[] args) {
        int[] temperatures = { 10, 20, 30 };
        temperatures[1] = 25;

        for (int i = 0; i < temperatures.length; i++) {
            System.out.println(temperatures[i]);
        }
    }
}
