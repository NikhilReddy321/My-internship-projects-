import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Expense implements Serializable {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getters and setters as needed

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadExpenses(); // Load previously saved expenses

        while (true) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    calculateSummaries();
                    break;
                case 4:
                    saveExpenses(); // Save expenses before exiting
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Expense Summaries");
        System.out.println("4. Save and Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void addExpense() {
        System.out.println("\nAdding Expense:");
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            System.out.print("Enter expense amount: $");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    validAmount = true;
                } else {
                    System.out.println("Invalid amount. Please enter a non-negative value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter expense category (e.g., groceries, transportation, entertainment): ");
        String category = scanner.nextLine();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);

        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses recorded yet.");
        } else {
            System.out.println("\nExpenses:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    private static void calculateSummaries() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses recorded yet.");
            return;
        }

        System.out.println("\nExpense Summaries:");
        System.out.println("1. Total Expenses for a Specific Category");
        System.out.println("2. Total Expenses for a Given Time Period (Not implemented)");

        int summaryChoice = getUserChoice();
        scanner.nextLine(); // Consume newline character

        switch (summaryChoice) {
            case 1:
                System.out.print("Enter the category for which you want to calculate total expenses: ");
                String categoryToSummarize = scanner.nextLine();
                displayTotalExpensesForCategory(categoryToSummarize);
                break;
            case 2:
                // Implement functionality to calculate total expenses for a given time period
                System.out.println("This feature is not implemented yet.");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void displayTotalExpensesForCategory(String category) {
        double totalExpenses = 0;

        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                totalExpenses += expense.getAmount();
            }
        }

        System.out.println("Total expenses for category '" + category + "': $" + totalExpenses);
    }

    private static void saveExpenses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("expenses.dat"))) {
            oos.writeObject(expenses);
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    private static void loadExpenses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("expenses.dat"))) {
            expenses = (ArrayList<Expense>) ois.readObject();
            System.out.println("Expenses loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved expenses found. Starting with a new list.");
        }
    }
}
