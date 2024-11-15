public class StringManipulationAssignment {
    public static void main(String[] args) {
        String name = "Gintoki";
        int birthYear = 1889;
        // concatinate
        System.out.println(name + " " + birthYear);
        System.out.println(name + " was born in " + birthYear);

        // formatting strings
        System.out.println(String.format("%s was born in %d", name, birthYear));

        // toUpperCase
        String upperCase = name.toUpperCase();
        System.out.println(upperCase);
        System.out.println(name.toUpperCase());

        // substring
        String substring = name.substring(0, 3);
        System.out.println(substring);
        System.out.println(name.substring(0, 3));

        // equalsIgnoreCase
        String name2 = "GINTOKI";
        System.out.println(name.equalsIgnoreCase(name2));
        System.out.println(name.equalsIgnoreCase(upperCase));
    }
}