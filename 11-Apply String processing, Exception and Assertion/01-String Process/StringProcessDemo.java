/* What is Java String Processing?
* 
* Java String Processing is a set of operations that can be performed on a String. 
* Strings are immutable in Java, meaning a String object cannot be changed once it has been created. 
* The String class provides a set of methods that allow you to perform operations on a String object.
* 
* Java String Processing Methods
* Here are some of the most common String processing methods:
* 
* - indexOf() - Returns the index within this string of the first occurrence of the specified character.
* - lastIndexOf() - Returns the index within this string of the last occurrence of the specified character.
* - replace() - Replaces the old char sequence with the new char sequence.
* - substring() - Returns a new string that is a substring of this string.
* - split() - Splits this string around matches of the given regular expression.
*
* String parsing
* String parsing is the process of converting a string into a data structure. Sometimes it is called data type conversion.
* Example: String to Integer
* 
* String to Integer
* String str = "123";
* int num = Integer.parseInt(str);
*
* StringBuilder provides a mutable sequence of characters for more efficient string manipulation.
* StringBuilder is a class that represents a mutable sequence of characters.
*
* Example: 
* StringBuilder sb = new StringBuilder("Hello");
* sb.append(" World");
* System.out.println(sb); // Output: Hello World
*
* String Formatting (String.format()) is a method in the String class that allows you to format a string with arguments.
* 
* Example: 
* String name = "John";
* int age = 30;
* String formattedString = String.format("My name is %s and I am %d years old.", name, age);
* System.out.println(formattedString); // Output: My name is John and I am 30 years old.
*
* Note: %() is a placeholder for the arguments. commonly used are:
* - %s for String
* - %d for integer
* - %f for float
* - %e for double
* - %b for boolean
* - %c for character
* - %t for short
* - %T for long
* - %n for newline
*
*/

// Sample demo applying String processing methods, String parsing, StringBuilder and String formatting

public class StringProcessDemo {
    public static void main(String[] args) {
        String str = "Hello, World!";
        int index = str.indexOf(',');
        System.out.println(index); // Output: 5
        int lastIndex = str.lastIndexOf('o');
        System.out.println(lastIndex); // Output: 8
        String replacedStr = str.replace("World", "Universe");
        System.out.println(replacedStr); // Output: Hello, Universe!
        String subStr = str.substring(1, 5);
        System.out.println(subStr); // Output: ello
        String[] words = str.split(",");
        System.out.println(words[0]); // Output: Hello
        System.out.println(words[1].trim()); // Output: World!

        //String parsing
        String str2 = "420";
        int num = Integer.parseInt(str2);
        System.out.println(num); // Output: 420

        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Where's");
        sb.append(" Wally");
        System.out.println(sb); // Output: Where's Wally

        //String formatting
        String [] userName = {"Kiko", "Matsing"};
        int height = 165;
        String formattedString = String.format( "%s and %s both have a height of %d", userName[1], userName[0], height);
        System.out.println(formattedString); // Output: Matsing and Kiko both have a height of 165
    }
}