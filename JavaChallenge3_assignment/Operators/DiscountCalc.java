import java.util.Scanner;

public class DiscountCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter original price: ");
        double originalPrice = input.nextDouble();
        System.out.print("Enter discount percentage: ");
        double discountPercentage = input.nextDouble();

        double discountAmount = originalPrice * discountPercentage / 100;
        double discountedPrice = originalPrice - discountAmount;

        System.out.println("Original price: " + originalPrice + "php");
        System.out.println("Discount percentage: " + discountPercentage + "%");
        System.out.println("Discounted price: " + discountedPrice + "php");
    }
}
