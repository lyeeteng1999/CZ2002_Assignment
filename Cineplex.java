import java.io.File;
import java.util.Scanner;

public class Cineplex {
	private String cineplexName;
	private String cineplexID;
	private Cinema cinemas;
	private String location;
	private int numOfCinemas;
	private String WDopeningHours; // Sunday to Thursday
	private String WEopeningHours; // Friday to Saturday
	
	public Cineplex() {
		//cinemas = new Cinema();
	}
	
	/*public Cineplex(String cineplexName, String cineplexID, String location, String WDopeningHours, String WEopeningHours, int numOfCinemas) {
		this.cineplexName = cineplexName;
		this.cineplexID = cineplexID;
		this.location = location;
		this.WDopeningHours = WDopeningHours;
		this.WEopeningHours = WEopeningHours;
		this.numOfCinemas = numOfCinemas;
		//Cinema[] cinemas = new Cinema[numOfCinemas];
	}*/
	
	private static Scanner x;
	
	public String getCineplexName(String cineplexID) {
		boolean found = false;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) {
				String tempname = x.next();
				String tempid = x.next();
				String temp = x.nextLine();
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					return tempname;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
	
	public String getCineplexLocation(String cineplexID) {
		boolean found = false;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) { 
				String tempname = x.next();
				String tempid = x.next();
				String temploc = x.next();
				String temp = x.nextLine();
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					return temploc;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
	
	public String getCineplexWdOh(String cineplexID) {
		boolean found = false;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) {
				String tempname = x.next();
				String tempid = x.next();
				String temploc = x.next();
				String tempWD = x.next();
				String temp = x.nextLine();
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					return tempWD;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
	
	public String getCineplexWeOh(String cineplexID) {
		boolean found = false;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) {
				String tempname = x.next();
				String tempid = x.next();
				String temploc = x.next();
				String tempWD = x.next();
				String tempWE = x.next();
				String temp = x.nextLine();
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					return tempWE;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
	
	public void getCinemaID(String cineplexID) {
		boolean found = false;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) {
				String tempname = x.next();
				String tempid = x.next();
				String temploc = x.next();
				String tempWD = x.next();
				String tempWE = x.next();
				int tempnum = Integer.parseInt(x.next());
				
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					for(int i=0;i<tempnum;i++) {
						String temphall = x.next(); 
						System.out.println((i+1)+". "+temphall);
					}
				}
				else {
					String temp = x.nextLine();
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean ifCinemaExist(String cineplexID, String CinemaID) {
		boolean found = false;
		boolean foundcin = false;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) {
				String tempname = x.next();
				String tempid = x.next();
				String temploc = x.next();
				String tempWD = x.next();
				String tempWE = x.next();
				int tempnum = Integer.parseInt(x.next());
				
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					for(int i=0;i<tempnum;i++) {
						String temphall = x.next(); 
						if(temphall.trim().contentEquals(CinemaID.trim())) {
							foundcin = true;
							System.out.println(foundcin);
						}
					}
				}
				else {
					String temp = x.nextLine();
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return foundcin;
	}
	
	public int getNumOfCinemas(String cineplexID) {
		boolean found = false;
		int num = 0;
		try {
			x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNextLine() && !found) {
				String tempname = x.next();
				String tempid = x.next();
				String temploc = x.next();
				String tempWD = x.next();
				String tempWE = x.next();
				int tempnum = Integer.parseInt(x.next());
				
				if(tempid.trim().contentEquals(cineplexID.trim())) {
					found = true;
					num = tempnum;
				}
				else {
					String temp = x.nextLine();
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return num;
	}
}
