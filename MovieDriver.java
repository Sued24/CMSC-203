import java.util.Scanner;
public class MovieDriver 
{
	public static void main(String[] args)
	{
		String title, rating, choice;
		int ticketsSold;
		Scanner keyboard = new Scanner(System.in);
		
		do
		{

			Movie peli = new Movie();
			
			System.out.print("Enter the title of a movie: ");
			title = keyboard.nextLine();
			peli.setTitle(title);
			
			System.out.print("Enter the movie's rating: ");
			rating = keyboard.nextLine();
			peli.setRating(rating);
			
			System.out.print("Enter the number of tickets sold at the theater: ");
			ticketsSold = keyboard.nextInt();
			keyboard.nextLine();
			peli.setSoldTickets(ticketsSold);
			
			System.out.println(peli.toString());
			
			System.out.println("Do you want to enter another? (y or n)");
			choice = keyboard.nextLine();
		} while(choice.equals("y"));

		keyboard.close();
	}
}
