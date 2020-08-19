import java.util.ArrayList;
import java.util.regex.Pattern;


public class C206_CaseStudy {
	

	private static final int OPTION_QUIT = 5;
	private static final String nric_pattern = "[b][0-9]{4}";



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		
		bikeList.add(new Bike ("b001","Merida",10));
		bikeList.add(new Bike ("b002","Trek",5));
		bikeList.add(new Bike ("b003","Specialized",4));
		bikeList.add(new Bike ("b004","Kona",10));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewbikeinfo(bikeList);
			

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");			
				
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a camcorder
					Bike cc = inputbike();
					C206_CaseStudy.addCamcorder(bikeList, cc);

				}/* else if (itemType == 2) {
					// Add Chromebook
					Chromebook cb = inputChromebook();
					ResourceCentre.addChromebook(chromebookList, cb);

				} */else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Loan item
				ResourceCentre.setHeader("LOAN");			
				itemTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder
					ResourceCentre.loanCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Return item
				ResourceCentre.setHeader("RETURN");				
				itemTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder
					ResourceCentre.returnCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}
		

	/**
	 * @param string
	 */
	

	/**
	 * 
	 */
	

	/**
	 * 
	 */



	}
	
	
	
	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}

	private static void menu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Bike");
		System.out.println("2. Add Bike");
		System.out.println("3. Delete Bike");
		System.out.println("4. Return item");
		System.out.println("5. Quit");
		Helper.line(80, "-");
		
	}

	public static void createbikeinfo() {
	}
	

		public static Bike inputbike() {
			String id = Helper.readStringRegEx("Enter asset id > ",nric_pattern);
			String name = Helper.readString("Enter name of bike > ");
			int unit = Helper.readInt("Enter optical unit > ");

			Bike cc= new Bike(id,name,unit);
			return cc;
			
		}
		public static void addbike(ArrayList<Bike> bikeList, Bike cc) {
			
			bikeList.add(cc);
			System.out.println("bike added");
		
		}
	public static String viewbikeinfo(ArrayList<Bike> bikeList) {
		String output = "";
			for (int i = 0; i <bikeList.size(); i++) {

				output += String.format("%-84s\n", bikeList.get(i).toString());
			}
			return output;
		}
		
		
	
	public static Boolean deletebikeinfo(ArrayList<Bike> bikeList, String deleteitem) {
		boolean deleted=false;
		deleteitem=Helper.readStringRegEx("Enter the Id",nric_pattern);
		
		for(int i =0; i<bikeList.size();i++ )
		if( bikeList.get(i).getId().equals(deleteitem)) {
			bikeList.clear();
			break;
			deleted=true;
		}
		}
		
	}


