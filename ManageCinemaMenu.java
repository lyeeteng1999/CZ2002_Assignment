import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ManageCinemaMenu {
	private Cinema cinema;
	private Cineplex cineplex;
	
	public ManageCinemaMenu() {
		cinema = new Cinema();
		cineplex = new Cineplex();
		
	}
	
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("********************* Cinema Settings *********************");
			System.out.println("1. Create Cinema");
			System.out.println("2. Update Cinema");
			System.out.println("3. Remove Cinema");
			System.out.println("4. Quit");
			System.out.println("************************************************************");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			
			try {
				switch(choice) {
				case 1:
					createCinema();
					break;
				case 2:
					updateCinema();
					break;
				case 3:
					removeCinema();
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
	public void createCinema() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Cineplex is this added to? (Cineplex ID): ");
		String cineplexID = sc.nextLine();
		System.out.println("Cinema Name: ");
		String cinemaID = sc.nextLine();
		
		//check if cinema exist
		if(cineplex.ifCinemaExist(cineplexID, cinemaID)) {
			System.out.println("Cinema Exist");
			return;
		}
		System.out.println("Is this cinema Platinum? (Y/N)");
		char plat = sc.next().charAt(0);
		String platinum;
		if (plat == 'Y')
			platinum = "true";
		else
			platinum = "false";
		
		//create file
		final Formatter x;
		try {
			String file = "D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\"+cineplexID+"_"+cinemaID+".txt";
			x = new Formatter(file);
			
			Writer output;
			try {
				output = new BufferedWriter(new FileWriter(file, true));
				//((BufferedWriter)output).newLine();
				int num;
				if(plat == 'Y')
					num = 20;
				else
					num = 40;
				output.append(platinum+","+num+",");
				output.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			//edit cineplex record
			File fileToBeModified = new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt");
			String oldContent = "";
			BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			boolean found = false;
			
			if(line.contains(cineplexID)) {
				found = true;
				String num = Integer.toString(cineplex.getNumOfCinemas(cineplexID));
				num =","+num+",";
				String newnum = Integer.toString(cineplex.getNumOfCinemas(cineplexID)+1);
				newnum = ","+newnum+",";
				String newline = line.replaceAll(num,newnum); 
				line = newline + ","+ cinemaID;
				System.out.println(line);
			}
			
			while(line!=null && !found) {
				oldContent = oldContent + line + "\n";
				line = reader.readLine();
				if(line.contains(cineplexID)) {
					found = true;
					String num = Integer.toString(cineplex.getNumOfCinemas(cineplexID));
					num =","+num+",";
					String newnum = Integer.toString(cineplex.getNumOfCinemas(cineplexID)+1);
					newnum = ","+newnum+",";
					String newline = line.replaceAll(num,newnum); 
					line = newline + ","+ cinemaID;
					System.out.println(line);
				}	
			}
			while(line!=null&&found) {
				oldContent = oldContent + line + "\n";
				line = reader.readLine();
			}
			
			FileWriter writer = new FileWriter(fileToBeModified);
			writer.write(oldContent);
			reader.close();
			writer.close();
			
			System.out.println("You have created a file");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateCinema() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Cineplex is this cinema in? (Cineplex ID): ");
		String cineplexID = sc.nextLine();
		System.out.println("Cinema Name: ");
		String cinemaID = sc.nextLine();
		int choice;
		String platinum = "false";
		String num = "40";
		
		System.out.println("********************* Update Type of Cinema*********************\n"
				 + "1. Platinum Class\n"
				 + "2. Normal Class\n"
				 + "3. Quit");
		choice = sc.nextInt();
		try {
			switch(choice) {
			case 1:
				platinum = "true";
				num = "20";
				break;
			case 2:
				platinum = "false";
				num = "40";
				break;
			case 3:
				System.out.print("Quit...");
				return;
			default:
				System.out.println("Invalid choice. Try again!");
				break;
			}
		}catch(Exception e) {
			System.out.println("Invalid choice. Try again!");
		}
		
		
		//edit cineplex record
		try{
			File fileToBeModified = new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\"+cineplexID+"_"+cinemaID+".txt");
			BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
			Scanner x = new Scanner(fileToBeModified);
			x.useDelimiter("[,\n]");
			
			String line = reader.readLine();
			
			boolean found = false;
			if(line!=null) {
				String tempplat = String.valueOf(cinema.ifPlatinum(cineplexID, cinemaID));
				String tempseats = String.valueOf(cinema.getNumOfTotalSeats(cineplexID, cinemaID));
				String newtemp = tempplat+","+tempseats;
				String newnew = platinum+","+num;
				line = line.replaceAll(newtemp,newnew);
			}
			
			FileWriter writer = new FileWriter(fileToBeModified);
			writer.write(line);
			reader.close();
			writer.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Information Updated.");
	}
	
	public void removeCinema() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Cineplex is this cinema in? (Cineplex ID): ");
		String cineplexID = sc.nextLine();
		System.out.println("Cinema Name: ");
		String cinemaID = sc.nextLine();
		
		try{ 
            Files.deleteIfExists(Paths.get("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\"+cineplexID+"_"+cinemaID+".txt"));
        } catch(Exception e) { 
            System.out.println("No such file/directory exists"); 
        } 
		
		try{
			File fileToBeModified = new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\CineplexRecord.txt");
			String oldContent = "";
			BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			
			boolean found = false;
			
			if(line.contains(cineplexID)) {
				found = true;
				String num = Integer.toString(cineplex.getNumOfCinemas(cineplexID));
				num =","+num+",";
				String newnum = Integer.toString(cineplex.getNumOfCinemas(cineplexID)-1);
				newnum = ","+newnum+",";
				line = line.replaceAll(num,newnum); 
				String tempid = ","+cinemaID;
				line = line.replaceAll(tempid, ""); 
				System.out.println(line);
			}	
			
			while(line!=null && !found) {
				oldContent = oldContent + line + "\n";
				line = reader.readLine();
				if(line.contains(cineplexID)) {
					found = true;
					String num = Integer.toString(cineplex.getNumOfCinemas(cineplexID));
					num =","+num+",";
					String newnum = Integer.toString(cineplex.getNumOfCinemas(cineplexID)-1);
					newnum = ","+newnum+",";
					line = line.replaceAll(num,newnum); 
					String tempid = ","+cinemaID;
					line = line.replaceAll(tempid, ""); 
					System.out.println(line);
				}	
			}
			while(line!=null&&found) {
				oldContent = oldContent + line + "\n";
				line = reader.readLine();
			}
			
			FileWriter writer = new FileWriter(fileToBeModified);
			writer.write(oldContent);
			reader.close();
			writer.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Cinema Removed");
	}
}
