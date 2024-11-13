public class HighestPrice {
    public static void main(String[] args) {
        double[] price = { 12.99, 24.50, 8.75, 15.00, 29.99 };

        // for-eachloop for the highest price
        double highestPrice = 0.0;
        for (double currentPrice : price) {
            if (currentPrice > highestPrice) {
                highestPrice = currentPrice;
            }
        }
        System.out.println("The highest price: $" + highestPrice);
    }
}
