public class TwoDArrayAccess {
    public static void main(String[] args) {
        int[][] numbers = {
                { 1, 2, 3, 4 },
                { 1, 2, 3, 4 },
        };
        System.out.println(numbers[1][3]); // result should be 4 (bottom-right corner value)
    }
}
