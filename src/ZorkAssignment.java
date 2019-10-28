/**
 * Zork Assignment Group Project
 * October 28, 2019
 */

import java.awt.image.BandedSampleModel;
import java.util.Scanner;

public class ZorkAssignment {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int answer;
        boolean play = true;

        System.out.println("Welcome to Zork!");

        System.out.println("Go to room 1 (1) or exit (0)?");
        answer = keyboard.nextInt();
        keyboard.nextLine();

        while (play) {
            if (answer == 0) {
                play = false;
                System.out.println("Goodbye!");
            } else if (answer == 1) {
                answer = roomOne();
            }
        }

    }

    public static int roomOne() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Welcome to room 1.");
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

    }

}
