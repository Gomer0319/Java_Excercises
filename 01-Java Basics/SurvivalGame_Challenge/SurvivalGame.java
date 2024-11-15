import java.util.*;

public class SurvivalGame {
    public static void main(String[] args) {
        // Array representing possible available items.
        String[] items = {
                "Water Bottle", "First Aid Kit", "Flashlight", "Map",
                "Rope", "Compass", "Knife", "Energy Bar", "Tent", "Blanket"
        };

        // Fixed-size inventory for up to 5 items.
        String[] inventory = new String[5];
        int itemCount = 0; // Tracks the number of items in the inventory.

        // Locations to search.
        String[] area = {
                "Campsite", "Forest", "Riverbank", "Abandoned Cabin", "Mountain Base"
        };

        // Scanner for user input.
        Scanner input = new Scanner(System.in);

        while (itemCount < 5) {
            // Prompt the player to choose a location.
            System.out.println(
                    "Where would you like to search? (Available locations: Campsite, Forest, Riverbank, Abandoned Cabin, Mountain Base)");
            String location = input.nextLine();

            // Check if the input location is valid.
            boolean validLocation = Arrays.asList(area).contains(location);
            if (validLocation) {
                // Determine if the search is successful.
                Random random = new Random();
                boolean foundItem = random.nextBoolean(); // 50% chance to find an item.

                if (foundItem) {
                    // Randomly find an item.
                    int randomIndex = random.nextInt(items.length);
                    String foundItemName = items[randomIndex];
                    System.out.println("You found a " + foundItemName + "!");

                    // Ask if the player wants to add it to their inventory.
                    System.out.println("Would you like to add this item to your inventory? (yes/no)");
                    String answer = input.nextLine();

                    if (answer.equalsIgnoreCase("yes")) {
                        // Check if the item already exists in the inventory.
                        boolean itemExists = false;
                        for (String item : inventory) {
                            if (foundItemName.equals(item)) {
                                itemExists = true;
                                break;
                            }
                        }

                        if (itemExists) {
                            System.out.println("You already have " + foundItemName + " in your inventory.");
                        } else if (itemCount < 5) {
                            // Add item to the next available slot in the inventory.
                            inventory[itemCount] = foundItemName;
                            itemCount++;
                            System.out.println(foundItemName + " has been added to your inventory.");
                        }
                    } else {
                        System.out.println("You leave the " + foundItemName + " behind.");
                    }
                } else {
                    // Search failure message.
                    System.out.println("You searched the area but didn't find anything useful.");
                }
            } else {
                System.out.println("Invalid location.");
            }

            // Display remaining slots or completion message.
            if (itemCount < 5) {
                System.out.println("You have " + (5 - itemCount) + " more slots in your inventory.");
            } else {
                System.out.println("You have found all 5 items! Game over.");
            }
        }

        // Display final inventory.
        System.out.println("Your final inventory: " + Arrays.toString(inventory));

        // Close the scanner.
        input.close();
    }
}
