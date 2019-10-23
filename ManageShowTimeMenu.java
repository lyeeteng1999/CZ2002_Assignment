import java.util.Scanner;

public class ManageShowTimeMenu {

	public ManageShowTimeMenu() {
		//showtime = new ShowTime();
	}
	
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("********************* Show Time Settings *********************");
			System.out.println("1. Create Show Time");
			System.out.println("2. Update Show Time");
			System.out.println("3. Remove Show Time");
			System.out.println("4. Quit");
			System.out.println("**************************************************************");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			
			try {
				switch(choice) {
				case 1:
					//createShowTime();
					break;
				case 2:
					//updateShowTime();
					break;
				case 3:
					//removeShowTime();
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
