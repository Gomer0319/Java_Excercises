import java.util.*;

/* Fruit InventoryManagement System
 * 1. Display inventory
 * 2. Customer Purchase
 * 3. Check Fruit Availability
 * 4. Restock Fruit
 * 5. Remove Fruit from Inventory
 * 6. Exit
 * Choose an option:
 */

public class FruitManagement {
    public static void main(String[] args) {
        // Initialize the fruit inventory with some fruits (fruitname, quantity and
        // price)
        String[][] fruits = {
                { "Apple", "30", "100" },
                { "Banana", "20", "60" },
                { "Orange", "25", "80" },
                { "Grapes", "15", "250" },
        };

        Scanner input = new Scanner(System.in);

        while (true) {
            // Display options for the Inventory Management System
            System.out.println("Fruit Inventory Management System");
            System.out.println("1. Display Inventory");
            System.out.println("2. Customer Purchase");
            System.out.println("3. Check Fruit Availability");
            System.out.println("4. Restock Fruit");
            System.out.println("5. Remove Fruit from Inventory");
            System.out.println("6. Exit");

            // Prompt the user to choose an option
            System.out.print("Choose an option (1-6): ");
            int option = input.nextInt();

            // Perform actions based on the user's choice
            if (option == 1) {
                // Display the fruit inventory
                System.out.println("Fruit Inventory:");
                for (String[] fruit : fruits) {
                    System.out.println(
                            "Name :" + fruit[0] + ", Quantity: " + fruit[1] + "kgs, Price: " + fruit[2] + "php");
                }
            }

            else if (option == 2) {
                // Customer purchase (predetermined quantity between banana and orange)
                Random random = new Random();
                boolean isBanana = random.nextBoolean();

                // if the purchase is for banana
                if (isBanana) {
                    String fruitName = "Banana";
                    int quantity = 5;

                    // Update the fruit inventory (banana)
                    for (String[] fruit : fruits) {
                        if (fruit[0].equals(fruitName)) {
                            int currentQuantity = Integer.parseInt(fruit[1]);
                            int updatedQuantity = currentQuantity - quantity;
                            fruit[1] = String.valueOf(updatedQuantity);
                        }
                    }
                }

                // if the purchase is for orange
                else {
                    String fruitName = "Orange";
                    int quantity = 10;

                    // Update the fruit inventory (orange)
                    for (String[] fruit : fruits) {
                        if (fruit[0].equals(fruitName)) {
                            int currentQuantity = Integer.parseInt(fruit[1]);
                            int updatedQuantity = currentQuantity - quantity;
                            fruit[1] = String.valueOf(updatedQuantity);
                        }
                    }
                }
            }

            else if (option == 3) {
                // Check fruit availability
                System.out.print("Enter the fruit name: ");
                String fruitName = input.next();

                for (String[] fruit : fruits) {
                    if (fruit[0].equals(fruitName)) {
                        System.out.println("Fruit Name: " + fruit[0]);
                        System.out.println("Quantity: " + fruit[1]);
                    }
                }
            }

            else if (option == 4) {
                // Restock fruit (Predetermined quantity)
                String restockName = "Apple";
                int restockQuantity = 10;

                for (String[] fruit : fruits) {
                    if (fruit[0].equals(restockName)) {
                        int currentQuantity = Integer.parseInt(fruit[1]);
                        int updatedQuantity = currentQuantity + restockQuantity;
                        fruit[1] = String.valueOf(updatedQuantity);

                        System.out.println("Restocked " + restockQuantity + "kgs of " + restockName);
                    }
                }
            }

            else if (option == 5) {
                // Remove fruit from inventory
                System.out.print("Enter the fruit name: ");
                String fruitName = input.next();

                for (String[] fruit : fruits) {
                    if (fruit[0].equals(fruitName)) {
                        int currentQuantity = Integer.parseInt(fruit[1]);
                        if (currentQuantity > 0) {
                            // Remove the fruit from the inventory
                            int updatedQuantity = 0;
                            fruit[1] = String.valueOf(updatedQuantity);
                            fruit[0] = "";
                            fruit[2] = "";
                            System.out.println("Removed " + fruitName + " from the inventory");
                        } else {
                            System.out.println("Fruit not found in the inventory");
                        }
                    }
                }
            }

            else if (option == 6) {
                // Exit the program
                System.out.println("Goodbye!");
                input.close();
                break;
            }
        }
    }
}