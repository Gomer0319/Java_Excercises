public class PriceList {
    public static void main(String[] args) {
        double[] price = { 12.99, 24.50, 8.75, 15.00, 29.99, };
        System.out.println("Price List: ");

        // loop
        for (int i = 0; i < price.length; i++) {
            System.out.println("Product " + (i + 1) + ": $" + price[i]);
        }
    }
}
