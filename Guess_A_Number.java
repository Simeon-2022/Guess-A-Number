import java.util.Random;
import java.util.Scanner;

public class Guess_A_Number {
    private static final int LEVEL_1 = 100;
    private static final int LEVEL_2 = 1000;
    private static final int LEVEL_3 = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcomeScreen();

        do {
            Random random = new Random();
            int computerNumber = random.nextInt(LEVEL_1);
            System.out.println("The secret number has been selected! Now it's your turn..");

            int userAttempts = 0;
            while (true) {

                System.out.printf("Pick a number (0 - %d): ", LEVEL_1);
                String userGuess = scanner.nextLine();

                while (!isNumber(String.valueOf(userGuess))) {
                    System.out.print("Please enter a valid number >> ");
                    userGuess = scanner.nextLine();
                }

                userAttempts++;

                int userGuessToInt = Integer.parseInt(userGuess);
                if (userGuessToInt == computerNumber) {
                    if (userAttempts == 1) {
                        System.out.printf("What a genius!! You guessed it on your first attempt! It's %d%n", computerNumber);
                        break;
                    }

                    System.out.printf("You guessed it!!! It's %d indeed!%n", computerNumber);
                    System.out.printf("You made %d attempts", userAttempts);
                    break;
                }

                int diff = userGuessToInt - computerNumber;
                inputValidityCheckLevel_1(diff);

            }
        } while (gameRestart().equalsIgnoreCase("y"));
        exitScreen();
    }

    public static void welcomeScreen() {
        System.out.println("---------------------------------------");
        System.out.println("|---------------Welcome---------------|");
        System.out.println("|------------------to-----------------|");
        System.out.println("|--------Guess-the-Number-Game--------|");
        System.out.println("---------------------------------------");
        System.out.println();
        //TODO:
        // System.out.println("-----Choose your difficulty------");
        // System.out.println("|----Level #1 -> press [1]------|");
        // System.out.println("|----Level #2 -> press [2]------|");
        // System.out.println("|----Level #3 -> press [3]------|");
        // System.out.println("---------------------------------");
    }

    public static String gameRestart() {
        System.out.println();
        System.out.print("Fancy another round? : [y]es or press Enter for exit.. -> ");
        return new Scanner(System.in).nextLine();

    }

    public static void sleep(int count) {
        for (int i = 0; i < count; i++) {

        }
    }

    public static void exitScreen() {
        System.out.println("Goodbye then! Hope to see you soon!");
        System.out.print("Exiting ");
        for (int i = 0; i < 3; i++) {
            sleep(Integer.MAX_VALUE);
            System.out.print(". ");
        }
    }

    public static boolean isNumber(String userInput) {
        if (userInput.isEmpty()) {
            return false;
        }
        for (int i = 0; i < userInput.length(); i++) {

            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void inputValidityCheckLevel_1(int diff) {
        if (diff > 0) {
            if (Math.abs(diff) >= 40) {
                System.out.println("HINT: Shooting in the sky.. Lower your aim!");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 30) {
                System.out.println("HINT: Still too high.. Like the song: Down, down, down!");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 20) {
                System.out.println("HINT: Getting closer but not there yet.. Subtract a few!");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 10) {
                System.out.println("HINT: Not too bad! Just take some off");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 5) {
                System.out.println("HINT: Ok, now concentrate! Shave off a little");
                System.out.println("-------------------------------------------------------");

            } else {
                System.out.println("HINT: Really close! You can do it!");
                System.out.println("-------------------------------------------------------");
            }

        } else {

            if (Math.abs(diff) >= 40) {
                System.out.println("HINT: Come on.. You can do better! Up your aim!");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 30) {
                System.out.println("HINT: Still too low.. Up, up, up!");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 20) {
                System.out.println("HINT: Kind of closer but not there yet.. Add a few, be generous");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 10) {
                System.out.println("HINT: Not too bad! Put some on top");
                System.out.println("-------------------------------------------------------");

            } else if (Math.abs(diff) >= 5) {
                System.out.println("HINT: Ok, now concentrate! Top up a little more");
                System.out.println("-------------------------------------------------------");

            } else {
                System.out.println("HINT: Really close! You can do it!");
                System.out.println("-------------------------------------------------------");
            }
        }
    }
}



