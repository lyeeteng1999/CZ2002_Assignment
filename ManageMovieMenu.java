import java.util.Scanner;

public class ManageMovieMenu {

	public ManageMovieMenu() {
		//movie = new Movie();
	}
	
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("********************* Movie Settings *********************");
			System.out.println("1. Create Movie");
			System.out.println("2. Update Movie Status");
			System.out.println("3. Remove Movie");
			System.out.println("4. Quit");
			System.out.println("**************************************************************");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			
			try {
				switch(choice) {
				case 1:
					//createMovie();
					break;
				case 2:
					//updateMovie();
					break;
				case 3:
					//removeMovie();
					break;
				case 4:
					System.out.println("Quit...");
					break;
				default:
					System.out.println("Invalid choice. Try again!");
				}
			}catch(Exception e) {
				System.out.println("Invalid choice. Try again!");
				break;}
		}while(choice!=4);
	}
}
