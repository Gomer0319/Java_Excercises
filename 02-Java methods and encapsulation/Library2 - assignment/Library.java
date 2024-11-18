import java.util.*;

class Book {
    private String title;
    private String author;

    // Create default constructor
    public Book () {
        title = "Unknown Title";
        author = "Unknown Author";
    }

    // Create overloaded constructor
    public Book (String t, String a) {
        title = t;
        author = a;
    }

    // Create public getter and setter methods for the title and author fields to encapsulate these fields.
    public String getTitle() { // getter method used to retrieve the value of the title field
        return title;
    }

    public void setTitle(String t) { // setter method used to set the value of the title field
        title = t;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
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

        // Call default constructor
        Book defaultBook = new Book ();

        // Initialize book object. Call the overloaded constructor if there are inputs, otherwise call the default constructor.
        Book book;
        if (inputTitle.length() > 0 && inputAuthor.length() > 0) {
            book = new Book (inputTitle, inputAuthor);
        }
        else if (inputTitle.length() > 0) {
            book = new Book (inputTitle, defaultBook.getAuthor()); // else if title is given but not author
        }
        else if (inputAuthor.length() > 0) {
            book = new Book (defaultBook.getTitle(), inputAuthor); // else if author is given but not title
        }
        else {
            book = new Book ();  
        }

        //call display method
        book.display();

        input.close();
    }
}