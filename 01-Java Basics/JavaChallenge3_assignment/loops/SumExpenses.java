public class SumExpenses {
    public static void main(String[] args) {
        double[] expenses = { 20, 35, 40, 50, 25 };
        System.out.print("Expense : ");
        double total = 0; // initialize total
        for (int i = 0; i < expenses.length; i++) {
            System.out.print(" $" + expenses[i] + ",");
            total = total + expenses[i];
        }
        System.out.println("\nTotal Expenses: $" + total);
    }
}
