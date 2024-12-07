import java.util.*;

// Create manage products class where we add, edit(update), view and delete products. (Products will include ID, name, price, quantity, and category)
class ManageProducts {
    // Create a scanner object to read user input
    Scanner productInput = new Scanner(System.in);

    // Create menu for manage products
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep managing products until they choose to return to admin menu
        boolean keepManaging = true;

        while (keepManaging) {
            // try-catch block to handle InputMismatchException
            try {
                System.out.println("\n=============================================");
                System.out.println("Manage Products");
                System.out.println("---------------------------------------------");
                System.out.println("1. Add Product");
                System.out.println("2. Edit Product");
                System.out.println("3. View Products");
                System.out.println("4. Delete Product");
                System.out.println("5. Return to Admin Menu");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");

                int productOption = productInput.nextInt();

                // Check if the admin wants to add, edit, view, delete, or return to admin menu
                switch (productOption) {
                    case 1:
                        // Go to Add product menu
                        AddProduct addProduct = new AddProduct();
                        addProduct.addProduct();
                        break;
                    case 2:
                        // Go to Update product menu
                        UpdateProduct updateProduct = new UpdateProduct();
                        updateProduct.updateProduct();
                        break;
                    case 3:
                        // Go to View Products menu
                        DisplayProducts displayProducts = new DisplayProducts();
                        displayProducts.displayProduct();
                        break;
                    case 4:
                        // Go to Delete product menu
                        DeleteProduct deleteProduct = new DeleteProduct();
                        deleteProduct.deleteProduct();
                        break;
                    case 5:
                        // Return to admin menu
                        System.out.println("\nReturning to Admin Menu. \n");
                        keepManaging = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                productInput.next(); // Consume the invalid input
            }
        }
    }
}

// Create add product class where we can add products to the system. (Products will include ID, name, price, quantity, and category)
class AddProduct {
    // Create a scanner object to read user input
    Scanner addProductInput = new Scanner(System.in);

    // Create add product menu
    public void addProduct() {
        // try-catch block to handle InputMismatchException
        try {
            System.out.println("\n=============================================");
            System.out.println("Add Product");
            System.out.println("---------------------------------------------");
            System.out.println("Select product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
            System.out.print(">>> ");
            int productCategory = addProductInput.nextInt();
            addProductInput.nextLine(); // Consume the newline character
            System.out.print("Enter product ID: ");
            int productID = addProductInput.nextInt();
            addProductInput.nextLine();
            System.out.print("Enter product name: ");
            String productName = addProductInput.nextLine();
            System.out.print("Enter product price: ");
            double productPrice = addProductInput.nextDouble();
            System.out.print("Enter product quantity: ");
            int productQty = addProductInput.nextInt();

            // Check if the product category is valid
            if (productCategory == 1) {
                // Add product to electronics array
                Electronics.addProduct(productID, productName, productPrice, productQty);
            }
            else if (productCategory == 2) {
                // Add product to clothings array
                Clothings.addProduct(productID, productName, productPrice, productQty);
            }
            else if (productCategory == 3) {
                // Add product to toys array
                Toys.addProduct(productID, productName, productPrice, productQty);
            }
            else if (productCategory == 4) {
                // Add product to furnitures array
                Furnitures.addProduct(productID, productName, productPrice, productQty);
            }
            else {
                System.out.println("Invalid product category input.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid input.");
            addProductInput.next();
        }
    }
}

// Create a class to update/edit the values of a product on a certain category (Electronics, Clothings, Toys, Furnitures)
class UpdateProduct {
    // Create a scanner object to read user input
    Scanner updateProductInput = new Scanner(System.in);

    // Ask user for product category
    public void updateProduct() {
        try {
            System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
            System.out.print(">>> ");
            int productCategory = updateProductInput.nextInt();

            // Check if the product category is valid
            if (productCategory == 1) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Electronics.editProduct(productID);
            }
            else if (productCategory == 2) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Clothings.editProduct(productID);
            }
            else if (productCategory == 3) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Toys.editProduct(productID);
            }
            else if (productCategory == 4) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Furnitures.editProduct(productID);
            }
            else {
                System.out.println("Invalid product category input.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            updateProductInput.next();
        }
    }
}

// Create a class to Delete a product on a certain category (Electronics, Clothings, Toys, Furnitures)
class DeleteProduct {
    // Create a scanner object to read user input
    Scanner deleteProductInput = new Scanner(System.in);

    // Ask user for product category
    public void deleteProduct() {
        // try-catch block to handle InputMismatchException
        try {
            System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
            System.out.print(">>> ");
            int productCategory = deleteProductInput.nextInt();

            // Check if the product category is valid
            if (productCategory == 1) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Electronics.deleteProduct(productID);
            }
            else if (productCategory == 2) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Clothings.deleteProduct(productID);
            }
            else if (productCategory == 3) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Toys.deleteProduct(productID);
            }
            else if (productCategory == 4) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Furnitures.deleteProduct(productID);
            }
            else {
                System.out.println("Invalid product category input.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            deleteProductInput.next();
        }
    }
}

// Create a class to display products according to category requested (Electronics, Clothings, Toys, Furnitures)
class DisplayProducts {
    // Create a scanner object to read user input
    Scanner displayProductInput = new Scanner(System.in);

    // Ask user for product category
    public void displayProduct() {
        // try-catch block to handle InputMismatchException
        try {
            System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures: ");
            System.out.print(">>> ");
            int productCategory = displayProductInput.nextInt();

            // Display products according to category requested
            switch (productCategory) {
                case 1:
                    Electronics.viewProducts();
                    break;
                case 2:
                    Clothings.viewProducts();
                    break;
                case 3:
                    Toys.viewProducts();
                    break;
                case 4:
                    Furnitures.viewProducts();
                    break;
                default:
                    System.out.println("Invalid product category.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            displayProductInput.next();
        }
    }
}

// Create a class to Search for a product on a certain category (Electronics, Clothings, Toys, Furnitures) by traverse the array and check if the product ID or product name is equal to the user input
class SearchProduct {
    // Create a scanner object to read user input
    Scanner searchProductInput = new Scanner(System.in);

    boolean found = false;
    boolean keepSearching = true;
    
    public void searchProduct() {
        try {
            while (keepSearching) {
                // Ask user for product category
                System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures \n5. Return");
                System.out.print(">>> ");
                int productCategory = searchProductInput.nextInt();

                // Check if the product category is valid
                if (productCategory == 1) {
                    // Ask for the product ID input or product name
                    System.out.print("\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (int i = 0; i < Electronics.electronics.size(); i++) {
                            if (Electronics.electronics.get(i).getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n", Electronics.electronics.get(i).getProductID(), Electronics.electronics.get(i).getProductName(), Electronics.electronics.get(i).getProductQty(), Electronics.electronics.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product ID is not found, print a message
                                System.out.println("Product with ID " + productID + " not found in Electronics category.");
                            }
                        }
                    }
                    else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (int i = 0; i < Electronics.electronics.size(); i++) {
                            if (Electronics.electronics.get(i).getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n", Electronics.electronics.get(i).getProductID(), Electronics.electronics.get(i).getProductName(), Electronics.electronics.get(i).getProductQty(), Electronics.electronics.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product name is not found, print a message
                                System.out.println("Product with name " + productName + " not found in Electronics category.");
                            }
                        }
                    }
                }
                else if (productCategory == 2) {
                    // Ask for the product ID input or product name
                    System.out.print("\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (int i = 0; i < Clothings.clothings.size(); i++) {
                            if (Clothings.clothings.get(i).getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  Clothings.clothings.get(i).getProductID(), Clothings.clothings.get(i).getProductName(), Clothings.clothings.get(i).getProductQty(), Clothings.clothings.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product ID is not found, print a message
                                System.out.println("Product with ID " + productID + " not found in Clothings category.");
                            }
                        }
                    }
                    else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (int i = 0; i < Clothings.clothings.size(); i++) {
                            if (Clothings.clothings.get(i).getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  Clothings.clothings.get(i).getProductID(), Clothings.clothings.get(i).getProductName(), Clothings.clothings.get(i).getProductQty(), Clothings.clothings.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product name is not found, print a message
                                System.out.println("Product with name " + productName + " not found in Clothings category.");
                            }
                        }
                    }
                }
                else if (productCategory == 3) {
                    // Ask for the product ID input or product name
                    System.out.print("\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (int i = 0; i < Toys.toys.size(); i++) {
                            if (Toys.toys.get(i).getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  Toys.toys.get(i).getProductID(), Toys.toys.get(i).getProductName(), Toys.toys.get(i).getProductQty(), Toys.toys.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product ID is not found, print a message
                                System.out.println("Product with ID " + productID + " not found in Toys category.");
                            }
                        }
                    }
                    else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (int i = 0; i < Toys.toys.size(); i++) {
                            if (Toys.toys.get(i).getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  Toys.toys.get(i).getProductID(), Toys.toys.get(i).getProductName(), Toys.toys.get(i).getProductQty(), Toys.toys.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product name is not found, print a message
                                System.out.println("Product with name " + productName + " not found in Toys category.");
                            }
                        }
                    }
                }
                else if (productCategory == 4) {
                    // Ask for the product ID input or product name
                    System.out.print("\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (int i = 0; i < Electronics.electronics.size(); i++) {
                            if (Electronics.electronics.get(i).getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n", Furnitures.furnitures.get(i).getProductID(), Furnitures.furnitures.get(i).getProductName(), Furnitures.furnitures.get(i).getProductQty(), Furnitures.furnitures.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product ID is not found, print a message
                                System.out.println("Product with ID " + productID + " not found in Furnitures category.");
                            }
                        }
                    }
                    else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (int i = 0; i < Electronics.electronics.size(); i++) {
                            if (Electronics.electronics.get(i).getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n",  "ID", "Product Name", "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n", Furnitures.furnitures.get(i).getProductID(), Furnitures.furnitures.get(i).getProductName(), Furnitures.furnitures.get(i).getProductQty(), Furnitures.furnitures.get(i).getProductPrice());
                                found = true;
                                break;
                            }
                            else {
                                // If the product name is not found, print a message
                                System.out.println("Product with name " + productName + " not found in Furnitures category.");
                        }
                    }
                }
                else if (productCategory == 5) {
                    // Return to ViewReports display menu
                    ViewReports viewReports = new ViewReports();
                    viewReports.displayMenu();
                    keepSearching = false;
                    break;
                }
            }
        }

        if (!found) {
            // If the product is not found, print a message
            System.out.println("Product not found.");
        }   
    }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            searchProductInput.next();
        }
    }
}

//Note: This can be refined/refactored to make it more efficient