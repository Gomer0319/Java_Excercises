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
            System.out.println("\nManage Products");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. View Products");
            System.out.println("4. Delete Product");
            System.out.println("5. Return to Admin Menu");
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
                    System.out.println("Returning to Admin Menu. \n");
                    keepManaging = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
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
        System.out.println("\nAdd Product");
        System.out.println("Select product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
        System.out.print(">>> ");
        int productCategory = addProductInput.nextInt();
        addProductInput.nextLine(); // Consume the newline character
        System.out.print("\nEnter product ID: ");
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
        /* Add else if statements for other product categories( Furnitures) here */
        else {
            System.out.println("Invalid product category input.");
        }
    }
}

// Create a class to update/edit the values of a product on a certain category (Electronics, Clothings, Toys, Furnitures)
class UpdateProduct {
    // Create a scanner object to read user input
    Scanner updateProductInput = new Scanner(System.in);

    // Ask user for product category
    public void updateProduct() {
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
        /* Add else if statements for other product categories( Furnitures) here */
        else {
            System.out.println("Invalid product category input.");
        }
    }
}

// Create a class to Delete a product on a certain category (Electronics, Clothings, Toys, Furnitures)
class DeleteProduct {
    // Create a scanner object to read user input
    Scanner deleteProductInput = new Scanner(System.in);

    // Ask user for product category
    public void deleteProduct() {
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
        /* Add else if statements for other product categories( Furnitures) here */
        else {
            System.out.println("Invalid product category input.");
        }
    }
}

// Create a class to display products according to category requested (Electronics, Clothings, Toys, Furnitures)
class DisplayProducts {
    // Create a scanner object to read user input
    Scanner displayProductInput = new Scanner(System.in);

    // Ask user for product category
    public void displayProduct() {
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
            /* Add case for other product categories( Furnitures) here */
            default:
                System.out.println("Invalid product category.");
        }
    }
}
