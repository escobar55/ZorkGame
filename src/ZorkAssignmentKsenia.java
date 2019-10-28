import java.util.Scanner;
import java.util.Random;

public class ZorkAssignmentKsenia {

    public static boolean secretOpen;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int answer;
        boolean play;

        System.out.println("Welcome to Zork!");

        System.out.println("Go to room 1 (1) or exit (0)?");
        answer = keyboard.nextInt();
        keyboard.nextLine();

        play = true;
        secretOpen = false;
        while (play) {
            if (answer == 0) {
                play = false;
                System.out.println("Goodbye!");
            } else if (answer == 1) {
                answer = roomOne();
            } else if (answer == 2) {
                answer = roomTwo();
            } else if (answer == 3) {
                answer = roomThree();
            } else if (answer == 4) {
                answer = roomFour();
            } else if (answer == 5) {
                answer = roomFive();
            }  else if (answer == 6) {
                answer = roomSix(secretOpen);
            }

//rooms to be written
//                else if (answer == 7) {
//                    answer = roomSeven();
//                } else if (answer == 8) {
//                    answer = roomEight();
//                } // end else-ifs


        } // end play loop

    } // end main


    public static int roomOne() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 1, the foyer.");
        System.out.println("You see a dead scorpion.");
        System.out.println("You can go North (N) or leave (Q).");

        while (true) {
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                return 2;  // will call method roomTwo from inside main()
            } else if (answer.equalsIgnoreCase("q")) {
                return 0;
            } else {
                System.out.println("Please enter a valid choice (N: North to room 2, Q: to exit castle): ");
            }
        }

    } // end room one method


    public static int roomTwo() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 2, the front room.");
        System.out.println("You see a piano.");
        System.out.println("You can go South (S), or West (W), or East (E)");

        while (true) {
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("s")) {
                return 1;  // will call method roomOne from inside main()
            } else if(answer.equalsIgnoreCase("w")){
                return 3; // will call method roomThree from inside main()
            } else if(answer.equalsIgnoreCase("e")){
                return 4; // will call method roomFour from inside main()
            }  else {
                System.out.println("Please enter a valid choice (S: South to room 1, W: West to room 3, E: East to room 4): ");
            }
        } //end while loop - room 2

    } //end-room two method


    public static int roomThree() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 3, the library.");
        System.out.println("You see a bunch of spiders.");
        System.out.println("You can go North (N) or East (E).");

        while (true) {
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                return 5;  // will call method roomTwo from inside main()
            } else if (answer.equalsIgnoreCase("e")) {
                return 2;
            } else {
                System.out.println("Please enter a valid choice (N: North to room 5, E: East to room 2): ");
            }
        }

    } // end room three method

    public static int roomFour() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 4, the kitchen room.");
        System.out.println("You see bats.");
        System.out.println("You can go West (W) to room 2, or North (N) to room 7");

        while (true) {
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("W")) {
                return 2;  // will call method roomTwo from inside main()
            } else if (answer.equalsIgnoreCase("n")) {
                return 7; // will call method roomSeven from inside main()
            } else {
                System.out.println("Please enter a valid choice (W: West to room 2, N: to room 7): ");
            }
        } //end while loop - room 4

    } // end room four method

    public static int roomFive() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 5, the dining room.");
        System.out.println("You see some dust and an empty box.");
        System.out.println("You can only go back the way you came (S).");

        while (true) {
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("s")) {
                return 3;  // will call method roomTwo from inside main()
            } else {
                System.out.println("Please enter a valid choice (S: South to room 3): ");
            }
        }

    } // end room five method

    public static int roomSix(boolean secretOpen) {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 6, the vault.");
        System.out.println("You see 3 walking skeletons.");

        if(!secretOpen) {  // if secret room is not already open
            // 25% chance that secret will open
            Random randomGenerator = new Random();
            int random = randomGenerator.nextInt(4) + 1;   // make it random in the range of 1 through 4
            if (random == 1) {
                // the secret is opened!
                secretOpen = true;
            }
        }

        if (secretOpen) {
            System.out.println("You can go East (E) to room 7 or East to the Secret Room (*)!");
            while (true) {
                answer = keyboard.nextLine();
                if (answer.equalsIgnoreCase("e")) {
                    return 7;
                } else if (answer.equalsIgnoreCase("*")) {
                    return 8; // will call method roomSeven from inside main()
                } else {
                    System.out.println("Please enter a valid choice (E: East to room 7, *: East to the Secret Room!): ");
                }
            } //end while loop :: secret open !! :)
        }
        else {
            System.out.println("You can go East (E) to room 7.");
            while (true) {
                answer = keyboard.nextLine();
                if (answer.equalsIgnoreCase("e")) {
                    return 7;
                } else {
                    System.out.println("Please enter a valid choice (E: East to room 7): ");
                }
            } //end while loop :: secret NOT open
        } // end if-else whether secret room is available or not

    } // end room six method

}
