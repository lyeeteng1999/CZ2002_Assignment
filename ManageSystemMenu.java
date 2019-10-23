import java.util.*;
import java.io.*;

public class ManageSystemMenu {
	//ranking of movies
	//private TopRankingMenu mTopRankingMenu;
	
	public ManageSystemMenu() {
		//mTopRankingMenu = new TopRankingMenu();
	}
	
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("********************* System Settings *********************");
			System.out.println("1. Top 5 Movies");
			System.out.println("2. View Ticket Price");
			System.out.println("3. Change Ticket Price");
			System.out.println("4. Manage Public Holiday");
			System.out.println("5. Add staff");
			System.out.println("6. Quit");
			System.out.println("***********************************************************");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			
			try {
				switch(choice) {
				case 1:
					//mTopRankingMenu.displayMenu();
					break;
				case 2:
					//viewTicketPrice();
					break;
				case 3:
					//changeTicketPrice();
					break;
				case 4:
					//managePublicHoliday();
					break;
				case 5:
					addstaff();
					break;
				case 6:
					System.out.println("Quit...");
					break;
				default:
					System.out.println("Invalid choice. Try again!");
				}
			}catch(Exception e) {
				System.out.println("Invalid choice. Try again!");
				break;}
		}while(choice!=6);
	}
	
	/*public void viewTicketPrice() {
		
	}
	public void changeTicketPrice(){
	
	}
	public void managePublicHoliday(){
	
	}*/
	
	public void addstaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of new staff: ");
		String newname = sc.nextLine();
		System.out.println("Enter username of new staff: ");
		String newuser = sc.nextLine();
		System.out.println("Enter password of new staff: ");
		String newpass = sc.nextLine();
		
		Writer output;
		try {
			output = new BufferedWriter(new FileWriter("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\StaffRecord.txt", true));
			//((BufferedWriter)output).newLine();
			output.append(newname+","+newuser+","+newpass+"\n");
			output.close();
			System.out.println("User Created");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

