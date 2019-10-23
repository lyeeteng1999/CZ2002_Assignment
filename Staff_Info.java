import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Staff_Info {
	private String staffName; //make all caps
	private String staffID; //assume 4 digit numbers
	private String staffPwd; //simple password will do in numbers for easy login
	
	public Staff_Info() {
	}
	
	public String get_StaffName(String staffID){
		boolean found = false;
		
		try {
			Scanner x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\StaffRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext() && !found) {
				String tempname = x.next();
				String tempuser = x.next();
				String temppass = x.next();
				
				if(tempuser.trim().contentEquals(staffID.trim())) {
					return tempname;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
	
	public String get_staffID(String staffName) {
		boolean found = false;
		
		try {
			Scanner x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\StaffRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext() && !found) {
				String tempname = x.next();
				String tempuser = x.next();
				String temppass = x.next();
				
				if(tempname.trim().contentEquals(staffName.trim())) {
					return tempuser;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
	
	
	public String get_staffPwd(String staffID) {
		boolean found = false;
		
		try {
			Scanner x = new Scanner(new File("D:\\School\\Y2S1\\CZ2002\\Assignment\\src\\StaffRecord.txt"));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext() && !found) {
				String tempname = x.next();
				String tempuser = x.next();
				String temppass = x.next();
				
				if(tempuser.trim().contentEquals(staffID.trim())) {
					return temppass;
				}
			}
			x.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Not Found";
	}
}
