import java.util.*;

public class MainMenu{
	private Staff_Menu mStaffMenu;
	//private Moviegoer_Menu mMoviegoerMenu;
	//private CineplexManager mCineplexManager;
	
	public MainMenu() {
		try {
			//mCineplexManager = new CineplexManager();
			mStaffMenu 	   = new Staff_Menu();		
			//mMoviegoerMenu = new Moviegoer_Menu();
		} catch (Exception e) {
			System.out.println("Problem loading the data, please contact the administrator.");
		}
		
	}
	
	public void displayMenu() {
		int choice = 0;
		
		do{
			System.out.println("********************* MOBLIMA *********************");
			System.out.println("1. Staff Login");
			System.out.println("2. Customer");
			System.out.println( "3. Quit");
			Scanner sc = new Scanner(System.in);
			try {
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					mStaffMenu.displayMenu();
					break;
				case 2:
					//mMoviegoerMenu.displayMenu();
					break;
				}
			}catch(Exception e) {
				System.out.println("Invalid Input!");
			}
			
		}while(choice!=3);
	}
}
