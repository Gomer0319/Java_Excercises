public class SalesForecast {
    public static void main(String[] args) {
        int[][] matrix1 = {
                { 10, 20 },
                { 30, 40 },
        };
        int[][] matrix2 = {
                { 5, 10 },
                { 15, 20 },
        };

        /*
         * Calculates and prints the total sales by adding the matrices element by
         * element (matrix 1 and matrix 2)
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
