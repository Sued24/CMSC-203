import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Wifi Diagnosis Tool
 * Due: 2/14/2022
 * Platform/compiler: Eclipse / JVM
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Santiago Sued
*/


public class WiFiDiagnosis 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Define and attached Scanner object to "input" variable.
		String choice;
		boolean resolved = true;
		
		// Print program statements and prompt.
		
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n");
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		choice = input.nextLine(); // Save prompt to "choice" variable.
		if (choice.equals("no")) // If issue not resolved, continue with next question.
		{
			System.out.println("Second step: reboot your router");
			System.out.println("Now are you able to connect with the internet? (yes or no)");
			choice = input.nextLine();
			if (choice.equals("no")) // If issue not resolved, continue with next question.
			{
				System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
				System.out.println("Now are you able to connect with the internet? (yes or no)");
				choice = input.nextLine();
				if (choice.equals("no")) // If issue not resolved, continue with next question.
				{
					System.out.println("Fourth step: move the computer closer to the router and try to connect");
					System.out.println("Now are you able to connect with the internet? (yes or no)");
					choice = input.nextLine();
					if (choice.equals("no")) // If issue not resolved, contact ISP.
					{
						System.out.println("Contact your ISP");
						resolved = false; // resolved variable set to false.
					}
				}
			}
		}
		if (resolved) // If resolve variable is true, print "Done" statement, otherwise exit.
			System.out.println("Done");
		input.close(); // Close Scanner resource.
	}
}
