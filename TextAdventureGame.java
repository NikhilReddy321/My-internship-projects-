import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a mysterious land...");

        System.out.println("You encounter a fork in the road.");
        System.out.println("Would you like to go left, right, or straight?");
        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "left":
                pathLeft(scanner);
                break;
            case "right":
                pathRight(scanner);
                break;
            case "straight":
                pathStraight(scanner);
                break;
            default:
                System.out.println("Invalid choice. Game over.");
                break;
        }

        scanner.close();
    }

    public static void pathLeft(Scanner scanner) {
        System.out.println("You chose to go left and come across a haunted mansion.");
        System.out.println("Do you want to enter the mansion? (yes/no)");
        String decision = scanner.nextLine().toLowerCase();

        switch (decision) {
            case "yes":
                System.out.println("You enter the mansion and find it filled with ghosts.");
                System.out.println("Do you explore further or try to escape? (explore/escape)");
                decision = scanner.nextLine().toLowerCase();

                switch (decision) {
                    case "explore":
                        System.out.println("You discover a hidden passage and escape safely!");
                        System.out.println("Congratulations! You survived and won the game!");
                        break;
                    case "escape":
                        System.out.println("You try to escape but get trapped by the ghosts.");
                        System.out.println("Game over!");
                        break;
                    default:
                        System.out.println("Invalid choice. Game over.");
                        break;
                }
                break;
            case "no":
                System.out.println("You decide not to enter the mansion and continue your journey.");
                pathEnd("freedom");
                break;
            default:
                System.out.println("Invalid choice. Game over.");
                break;
        }
    }

    public static void pathRight(Scanner scanner) {
        System.out.println("You chose to go right and encounter a mystical forest.");
        System.out.println("Would you like to explore deeper into the forest? (yes/no)");
        String decision = scanner.nextLine().toLowerCase();

        switch (decision) {
            case "yes":
                System.out.println("As you venture deeper, you find a magical fountain.");
                System.out.println("Will you drink from the fountain? (yes/no)");
                decision = scanner.nextLine().toLowerCase();

                switch (decision) {
                    case "yes":
                        System.out.println("You drink from the fountain and gain eternal youth!");
                        System.out.println("Congratulations! You've found happiness and won the game!");
                        break;
                    case "no":
                        System.out.println("You avoid the fountain and continue your journey.");
                        pathEnd("exploration");
                        break;
                    default:
                        System.out.println("Invalid choice. Game over.");
                        break;
                }
                break;
            case "no":
                System.out.println("You choose not to explore and continue your journey.");
                pathEnd("journey");
                break;
            default:
                System.out.println("Invalid choice. Game over.");
                break;
        }
    }

    public static void pathStraight(Scanner scanner) {
        System.out.println("You chose to go straight and encounter a vast desert.");
        System.out.println("Do you want to search for an oasis or climb a dune? (search/climb)");
        String decision = scanner.nextLine().toLowerCase();

        switch (decision) {
            case "search":
                System.out.println("You find a hidden oasis and quench your thirst!");
                System.out.println("Congratulations! You survived and won the game!");
                break;
            case "climb":
                System.out.println("You climb the dune but get lost in the desert.");
                System.out.println("Game over!");
                break;
            default:
                System.out.println("Invalid choice. Game over.");
                break;
        }
    }

    public static void pathEnd(String reason) {
        System.out.println("You reach the end of your adventure.");

        switch (reason) {
            case "freedom":
                System.out.println("You decided not to enter the mansion and found freedom.");
                break;
            case "exploration":
                System.out.println("You chose not to drink from the fountain and continued your exploration.");
                break;
            case "journey":
                System.out.println("You continued your journey without exploring further.");
                break;
            default:
                System.out.println("Thanks for playing!");
                break;
        }
    }
}
