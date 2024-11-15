public class BakeryInventory {
    public static void main(String[] args) {
        String[] products = { "Croissants", "Bagels", "Cupcakes", "Muffins", "Cinnamon" };
        int[] stock = { 20, 12, 18, 10, 5 };
        System.out.println(products[0] + " stock: " + stock[0]);
        System.out.println(products[1] + " stock: " + stock[1]);
        System.out.println(products[2] + " stock: " + stock[2]);
        System.out.println(products[3] + " stock: " + stock[3]);
        System.out.println(products[4] + " stock: " + stock[4]);

        int[][] feedbackScores = {
                { 8, 7, 9, 6, 8 },
                { 9, 6, 7, 8, 7 },
                { 8, 9, 6, 7, 8 },
                { 7, 8, 9, 6, 9 },
                { 6, 7, 8, 7, 6 },
                { 9, 6, 7, 8, 8 },
                { 8, 8, 6, 9, 7 }
        };

        System.out.println("Feedback scores:");
        System.out.println(products[2] + " for day 1: " + " " + feedbackScores[0][2]);
        System.out.println(products[3] + " for day 4: " + " " + feedbackScores[3][3]);
    }
}