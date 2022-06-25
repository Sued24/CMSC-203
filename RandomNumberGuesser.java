import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Random Number Guesser
 * Due: 6/25/2022
 * Platform/compiler: Eclipse / Java Virtual Machine
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Santiago Sued.
*/

public class RandomNumberGuesser // Define RandomNumberGuesser class.
{
	public static void main(String[] args) // Main Argument.
	{
		int guess, answer, min = 0, max = 99; // Define variables.
		boolean inBounds = false, found = false, first = true; 
		answer = RNG.rand(); // Generates random number from RNG class.
		String tryAgain; // tryAgain answer.
		Scanner keyboard = new Scanner(System.in); // Create keyboard Scanner object.
		
		// Print header.
		
		System.out.println("=======| Guess the Number Mini-game|=======");
		System.out.println("\t\t By Santiago Sued");
		
		// Outer loop, this repeats the entire process if the user answers "yes".
		
		do 
		{
			min = 0; // Reset variables for new game.
			max = 99;
			found = false;
			first = true;
			inBounds = false;
			answer = RNG.rand();
			System.out.println();
			System.out.print("Enter your first guess between 0 and 99: "); // Prompt for first guess.
		
			do // This loop repeats the entire guessing process.
			{
				do  // This loop prompts the user to re-guess if their guess is outside of bounds.
				{
					if(first == false) // This if checks to see if it is the first guess, if not, changes prompt message.
						System.out.print("Enter your next guess between " + min + " and " + max + " : ");
					guess = keyboard.nextInt(); // Saves guess.
					if (guess == answer) // If the guess is correct, set found to true.
						found = true;
					keyboard.nextLine(); // Move the input buffer.
					if (found == false) // Only if the guess is not found, do I validate the input.
					{
						inBounds = RNG.inputValidation(guess , min , max); // Utilize inputValidation method
					if (inBounds == true) // If the guess is in bounds, output number of guesses
						System.out.println("Number of guesses is " + RNG.getCount());						
					}

				} while (inBounds == false); // Repeat guess until it is in bounds.
		
				if(guess < answer) // If the guess is lower than the answer, shrink bounds.
				{
					System.out.println("Your guess is too low.");
					min = guess;
				}

				else if (guess > answer) // If the guess is higher than the answer, shrink bounds.
				{
					System.out.println("Your guess is too high.");
					max = guess;
				}
		
				first = false; // After first loop, set first to false.
			} while(found == false); // Repeat until number is found.
			
			// Print congratulations and ask if they want to play again. If so, repeat loop.
			
			System.out.println("Congratulations, you guessed correctly!");
			System.out.println("Try again? (yes or no)");
			tryAgain = keyboard.nextLine();
		} while(tryAgain.equals("yes"));
		
		System.out.println();
		System.out.println("Programmer Name: Santiago Sued"); // Print programmer name.
		keyboard.close(); // Close keyboard resource.
	}
	
}
