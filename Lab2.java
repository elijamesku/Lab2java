/*
Eli james
lab2 
cis 200
using eclipse used the Random class to generate 5 random numbers plus an additional number representing the “Powerball”
number
Declared the constants for the Lower and Upper range of the possible random numbers (use 1-99) and use within
the program.
-Display the winning numbers plus the Powerball number.
-Have the user enter in the 5 numbers on their ticket followed by their PowerBall number.
If Powerball and all 5 numbers match, display a message “All numbers plus Powerball Match! You’ve won
the Grand Prize of 6.5 million dollars!”
If they match all 5 numbers but NOT the Powerball, display the message “All 5 numbers match (but not
the Powerball). You’ve won 1 million dollars!”
 If they only match the Powerball, then display the message “Your Powerball number matches! You’ve won
$1,000 dollars!”
 Otherwise display the message, None of your numbers are winners. Try again soon

*/import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        // Constants for the range of possible random numbers
        final int LOWESTNUM = 1;
        final int HIGHESTNUM = 99;

        // Creating the Random object for random number display
        Random random = new Random();

        // Randomly generating the winning numbers and Powerball number
        int[] wonNumbers = new int[5];
        for (int i = 0; i < 5; i++) {
            wonNumbers[i] = random.nextInt(HIGHESTNUM - LOWESTNUM + 1) + LOWESTNUM;
        }
        int pwbNum = random.nextInt(HIGHESTNUM - LOWESTNUM + 1) + LOWESTNUM;

        // Displaying the winning numbers and Powerball number
        System.out.print("Winning numbers: ");
        for (int number : wonNumbers) {
            System.out.print(number + " ");
        }
        System.out.println("\nPowerball number: " + pwbNum);

        // Getting the ticket numbers from the user
        Scanner scanner = new Scanner(System.in);
        int[] userNums = new int[5];
        for (int i = 0; i < 5; i++) {
            int userNumber;
            do {
                System.out.print("Enter number " + (i + 1) + ": ");
                userNumber = scanner.nextInt();
                if (userNumber < 1 || userNumber >= 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                }
            } while (userNumber < 1 || userNumber >= 100);
            userNums[i] = userNumber;
        }

        int userPwbNum;
        do {
            System.out.print("Enter your Powerball number: ");
            userPwbNum = scanner.nextInt();
            if (userPwbNum < 1 || userPwbNum > 100) {
                System.out.println("Please enter a number between 1 and 100.");
            }
        } while (userPwbNum < 1 || userPwbNum > 100);

        // Check if the user is a winner
        boolean numsMatched = true;
        for (int number : userNums) {
            if (!contains(wonNumbers, number)) {
                numsMatched = false;
                break;
            }
        }

        if (numsMatched && userPwbNum == pwbNum) {
            System.out.println("All numbers plus Powerball Match! You've won the Grand Prize of 6.5 million dollars!");
        } else if (numsMatched) {
            System.out.println("All 5 numbers match (but not the Powerball). You've won 1 million dollars!");
        } else if (userPwbNum == pwbNum) {
            System.out.println("Your Powerball number matches! You've won $1,000 dollars!");
        } else {
            System.out.println("None of your numbers are winners. Try again soon!");
        }
    }

    // Creating a helper method to check if an array contains a specific value
    public static boolean contains(int[] array, int value) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }
}