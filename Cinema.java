import java.io.File;
import java.util.Scanner;

public class Cinema{
	private Cineplex cineplex;
	private boolean isPlatinum;
	private int cinemaID;
	private String cinemaName;
	//private ArrayList<ShowTime> showtimes;
	private int numOfTotalSeats;
	
	public Cinema() {
		cineplex = new Cineplex();
		//showtimes = new ArrayList<>();
	}
	
	/*public Cinema(boolean isPlatinum, String cinemaName, int cinemaID) {
		this.isPlatinum = isPlatinum;
		this.cinemaName = cinemaName;
		this.cinemaID = cinemaID;
		if(isPlatinum)
			this.numOfTotalSeats = 20;
		else
			this.numOfTotalSeats = 40;
	}*/
	
	public int getNumOfTotalSeats(String CineplexID, String CinemaID) {
		int tempseats = 0;
		try {
			Scanner x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\"+CineplexID+"_"+CinemaID+".txt"));
			x.useDelimiter("[,\n]");

			while(x.hasNext()) {
				String tempplat = x.next();
				tempseats = Integer.parseInt(x.next());
				String temp = x.nextLine();
				}
			x.close();
			return tempseats;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return tempseats;
	}
	
	public boolean ifPlatinum(String CineplexID, String CinemaID) {
		String tempplat = "";
		boolean plat = false;
		try {
			Scanner x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\"+CineplexID+"_"+CinemaID+".txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				tempplat = x.next();
				String temp = x.nextLine();
				}
			x.close();
			plat = Boolean.parseBoolean(tempplat);
			return plat;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return plat;
	}
	
	


	/*public void getAllShowtimes() {
		for (int i=0; i<lengthofarray; i++) {
			int a = sc.nextInt()
			if (this.cinemaID == a) {
				for (int j=0, j<lengthofarray; j++) {
					b = sc.next();
					System.out.println(a +" ");
				}
			}
		}
	}*/
}
