import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;



public class C206_CaseStudy {
	

	private static final int OPTION_QUIT = 5;
	private static final String nric_pattern = "[b][0-9]{3}";


    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		
		bikeList.add(new Bike ("b001","Merida",10));
		bikeList.add(new Bike ("b002","Trek",5));
		bikeList.add(new Bike ("b003","Specialized",4));
		bikeList.add(new Bike ("b004","Kona",10));
		
		ArrayList<Appointment>appList = new ArrayList<Appointment>();
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = "12/10/2020";
		LocalDate doa=LocalDate.parse(date,formatter);
		appList.add(new Appointment("Yuting",doa,"10:20","Buy Bike"));
		appList.add(new Appointment("YuPing",doa,"11:30","Collect Bike"));
		
	
		
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
            // yuping part 
			if (option == 1) {
				// View all items of bike 
				
				bikeinformationMenu();
				option = Helper.readInt("Enter an option > ");
				
				if(option==1) {
					// view all bike 
					C206_CaseStudy.viewAllbike(bikeList);
					
				}else if(option==2){
					//add bike info
					C206_CaseStudy.setHeader("ADD Bike Information");			
					Bike cc =inputbike();
					
					addbike( bikeList,cc);
				
				}else if(option==3) {
					// delete bike info 
					C206_CaseStudy.setHeader("Delete bike infomation");
					 String deleteitem=Helper.readStringRegEx("Enter the Id >",nric_pattern);
					C206_CaseStudy.deletebikeinfo(bikeList,deleteitem);
				}
			}
				
				//yt option 4 for the appointment menu
			else if (option == 4) {
				
				C206_CaseStudy.setHeader("Appointment");				
				appointmentTypeMenu();
				
				int optionType = Helper.readInt("Enter choice > ");
				if (optionType == 1) {
					C206_CaseStudy.setHeader("Create Appointment");
					Appointment ap =inputAppointment();
					addApp(appList,ap);

				} 
				else if (optionType == 2)
				{
					C206_CaseStudy.setHeader("View Appointment");
					viewAllApp(appList);
					
				}
				else if(optionType == 3)
				{
					C206_CaseStudy.setHeader("Modify Appointment");
					modiffApp(appList);
					
				}
				else if (optionType ==4)
				{
					menu();
				}
				else
				{
					System.out.println("Invalid");
				}
			
		}
		}
	}
				
	
		
		
	
	
	/**
	 * 
	 */
	//yuping
	private static void bikeinformationMenu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("Bike Information ");
		System.out.println("1. View Bike Information");
		System.out.println("2. Add Bike Information");
		System.out.println("3. Delete Bike Information");
		System.out.println("4. Quit");
		Helper.line(80, "-");
		
		
	}

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	private static void menu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("BIKE APP");
		System.out.println("1. Bike information");
		System.out.println("2. BikePart");
		System.out.println("3. --");
		System.out.println("4. Appointment");
		System.out.println("5. Quit");
		Helper.line(80, "-");
		
	}


	//yuping
		public static Bike inputbike() {
			String id = Helper.readStringRegEx("Enter asset id > ",nric_pattern);
			String name = Helper.readString("Enter name of bike > ");
			int unit = Helper.readInt("Enter optical unit > ");

			Bike cc= new Bike(id,name,unit);
			return cc;
			
		}
		//yuping
		public static void addbike(ArrayList<Bike> bikeList, Bike cc) {
			
			bikeList.add(cc);
			System.out.println("bike added");
		
		}
		//yuping
	public static String viewbikeinfo(ArrayList<Bike> bikeList) {
		String output = "";
			for (int i = 0; i <bikeList.size(); i++) {

				output += String.format("%-84s\n", bikeList.get(i).toString());
			}
			return output;
		}
		//yuping 
	public static void viewAllbike(ArrayList<Bike> bikeList) {
		C206_CaseStudy.setHeader("Bike Info List");
		String output = String.format("%-10s %-30s %-10s \n", "ASSET ID", "Brand of Bike","unit");
		 output += viewbikeinfo(bikeList);	
		System.out.println(output);
	}
		
	//yuping
	public static Boolean deletebikeinfo(ArrayList<Bike> bikeList, String deleteitem) {
		
		boolean deleted=false;
		
		for(int i = 0; i<bikeList.size();i++ )
		if( bikeList.get(i).getId().equals(deleteitem)) {
			bikeList.remove(bikeList.get(i));
			System.out.println("Bike info is deleted");
			break;
		}else {
			System.out.println("Invalid ID enter");
		}
		return deleted;
		}
	

	
	//Appointment - YuTing
	private static void appointmentTypeMenu() {
		Helper.line(30, "=");
		System.out.println("1.Create Appointment");
		System.out.println("2.View Appointment[Staff]");
		System.out.println("3.Modify Appointment[Staff]");
		System.out.println("4.Menu");
		Helper.line(30, "=");
	}
	public static Appointment inputAppointment() {
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String name = Helper.readString("Enter name> ");
		String date =Helper.readString("Enter appointment date in this format : dd/MM/yyyy > ");
		LocalDate doa=LocalDate.parse(date,formatter); // using phrase to format the string birth into local time
		String time = Helper.readString("Enter prefernce time in this format : HH:MM > ");
		String reason = Helper.readString("Appointment Reason > ");

		Appointment ap = new Appointment(name,doa,time,reason);
		return ap;
		
	}
	public static void addApp(ArrayList<Appointment> appList,Appointment ap) {
		
		appList.add(ap);
		System.out.println("Appointment added");
	}


	public static String viewAppInfo(ArrayList<Appointment> appList) {
		String output = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int i = 0; i < appList.size(); i ++) {
			output += String.format("%-20s %-20s %-20s %-20s \n",appList.get(i).getName(),appList.get(i).getappointmentDT().format(formatter),appList.get(i).getTime(),appList.get(i).getappointmentReason());
		}
			return output;
		}
		
	public static void viewAllApp(ArrayList<Appointment> appList) {
		
		Helper.line(30, "=");
		String output = String.format("%-20s %-20s %-20s %-20s \n","NAME","APPOINTMENT DATE","TIME", "REASON");
		output += viewAppInfo(appList);	
		System.out.println(output);
	}
	public static void modiffApp(ArrayList<Appointment>appList)
	{
				Helper.line(30, "=");
				System.out.println("1. Edit the appointment");
				System.out.println("2. Delete the appointment");
				System.out.println("3. Back to Appointment Menu");
				int choice = Helper.readInt("Enter your choice > ");
				if(choice == 1)
				{
					//editApp(appList);
				}
				else if (choice == 2)
				{
					deleteApp(appList);
				}
	}
	
	/*public static void editApp(ArrayList<Appointment>appList)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 Helper.line(30, "=");
			System.out.println(String.format("%-20s %-20s %-20s %-20s","NAME","APPOINTMENT DATE","TIME", "REASON"));
			for(Appointment app : appList) {
				System.out.println(String.format("%-20s %-20s %-20s %-20s",app.getName(),app.getappointmentDT().format(formatter),app.getTime(),app.getappointmentReason()));
			}
			String name = Helper.readString("Who's record you want to edit? > ");
			for(int i = 0; i < appList.size(); i ++) {
			if(name.equalsIgnoreCase(appList.get(i).getName()));
			{
				String editDate =Helper.readString("Enter appointment date in this format : dd/MM/yyyy > ");
				LocalDate doa=LocalDate.parse(editDate,formatter); // using phrase to format the string birth into local time
				String time = Helper.readString("Enter prefernce time in this format : HH:MM > ");
				String reason = Helper.readString("Appointment Reason > ");
				appList.get(i).setappointmentDT(doa);
				appList.get(i).setTime(time);
				appList.get(i).setappointmentReason(reason);
				System.out.println("Updaded!");
			}
	}
	
	*/
	// write your doReturnChromebook code here
		public static boolean doDeleteApp(ArrayList<Appointment> appList,String name) {
			boolean isReturned = false;

			for (int i = 0; i < appList.size(); i++) {
				if (name.equalsIgnoreCase(appList.get(i).getName()))
		      	{
					isReturned = true;
					appList.remove(appList.get(i));
				}
			}
			return isReturned;
			
		}
		public static void deleteApp(ArrayList<Appointment> appList) {

			C206_CaseStudy.viewAppInfo(appList);
			String name = Helper.readString("Enter name to delete> ");
			Boolean isReturned = doDeleteApp(appList, name);
			
			if (isReturned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Appointment for " + name + " deleted");
			}
		}


}
	


