import java.util.*;

class Book {
    String title;
    String author;

    // Create default constructor
    Book () {
        title = "Unknown Title";
        author = "Unknown Author";
    }

    // Create overloaded constructor
    Book (String t, String a) {
        title = t;
        author = a;
    }

    // create public method display()
    public void display() {
        // print the title and author. 
        System.out.println ( title + " by " + author + " is added to the library.");
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input title and author
        System.out.println ("Enter title of the book: ");
        String inputTitle = input.nextLine();
        System.out.println ("Enter author of the book: ");
        String inputAuthor = input.nextLine();

        // Initialize book object. Call the overloaded constructor if there are inputs, otherwise call the default constructor.
        if (inputTitle.length() > 0 && inputAuthor.length() > 0) {
            Book book = new Book (inputTitle, inputAuthor);

            //call display method
            book.display();
        } else {
            Book book = new Book ();

            //call display method
            book.display();
        }

        input.close();
    }
}