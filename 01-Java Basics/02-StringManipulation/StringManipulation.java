public class StringManipulation {
    public static void main(String[] args) {
        String greeting = "Hello, world!";
        System.out.println(greeting);

        // concatenation
        String str = "Hello";
        str = str + ", world!";
        System.out.println(str);

        // concatenation
        String part1 = "Hello";
        String part2 = "world!";
        String str2 = part1 + ", " + part2;
        System.out.println(str2);

        // formatting
        String name = "Jordan";
        int age = 23;
        String str3 = String.format("My name is %s and I am %d years old.", name, age);
        System.out.println(str3);

        // length
        String text = "Hello!";
        int length = text.length();
        System.out.println("The length of the string is: " + length);

        // ()toUpperCase() and ()toLowerCase()
        String greeting1 = "Hello!";
        String upperCase = greeting1.toUpperCase();
        String lowerCase = greeting1.toLowerCase();
        System.out.println("upperCase: " + upperCase);
        System.out.println("lowerCase: " + lowerCase);

        // charAt()
        String word = "Java";
        char letter = word.charAt(2);
        System.out.println("The letter at index 2 is: " + letter);

        // substring()
        String sentence = "I love Java!";
        String substring = sentence.substring(7, 12);
        System.out.println("The substring is: " + substring);

        // equals() and equalsIgnoreCase()
        String str4 = "Hello";
        String str5 = "hello";
        boolean isEqual = str4.equalsIgnoreCase(str5);
        System.out.println("Are the strings equal? " + isEqual);
    }
}