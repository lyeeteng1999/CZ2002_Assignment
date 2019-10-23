import java.util.*;
import java.io.*;


public class Staff_Menu {
	private Staff_Info currentStaff;
	//private ManageMovieMenu mManageMovieMenu;
	//private ManageShowTimeMenu mManageShowTimeMenu;
	private ManageCinemaMenu mManageCinemaMenu;
	private ManageSystemMenu mManageSystemMenu;
	
	public Staff_Menu() {
		//mManageMovieMenu = new ManageMovieMenu();
		//mManageShowTimeMenu = new ManageShowTimeMenu();
		mManageCinemaMenu = new ManageCinemaMenu();
	mManageSystemMenu = new ManageSystemMenu();
	currentStaff = new Staff_Info();
	}
	
	//to login
	private static Scanner x;
	
	private boolean login() {
		System.out.println("********************* Staff Login ********************* ");
		System.out.println("Username: 	");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		System.out.println("Password: ");
		String password = sc.nextLine();
		
		boolean found = false;
		String correctpass = currentStaff.get_staffPwd(username);
		if (correctpass.trim().contentEquals(password.trim())){
			found = true;
			System.out.println("Welcome " + currentStaff.get_StaffName(username));
		}
		else
			System.out.println("Invalid Username/Password!");
		return found;
	}
	
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		if (login()) {
			do {
				System.out.println("********************* Main Staff Menu *********************");
				System.out.println("1. Create/Update Movie Listing");
				System.out.println("2. Create/Update/Remove Cinema Show Times");
				System.out.println("3. Create/Update/Remove Cinema");
				System.out.println("4. Configure System settings");
				System.out.println("5. Logout");
				System.out.println("Enter Choice: ");
				choice = sc.nextInt();
				try {
					switch(choice) {
					case 1:
						//mManageMovieMenu.displayMenu();
						break;
					case 2:
						//mManageShowTimeMenu.displayMenu();
						break;
					case 3:
						mManageCinemaMenu.displayMenu();
						break;
					case 4:
						mManageSystemMenu.displayMenu();
						break;
					case 5:
						System.out.println("Logout...");
						break;
					default:
						System.out.println("Invalid choice. Try again!");
					}
				}catch(Exception e) {
					System.out.println("Invalid choice. Try again!");
					break;}
			}while(choice!=5);
		}
	}
}
