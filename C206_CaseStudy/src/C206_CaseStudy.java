import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 4;
	
	private static final int OPTION_ADD = 1;
	
	private static final int OPTION_VIEW = 2;
	
	private static final int OPTION_DELETE = 3;
	
	public static void main(String[] args) {		
		
        ArrayList<ExchangeRate> exchangeRateList = new ArrayList<ExchangeRate>();
        
        String allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);
        
        exchangeRateList.add(new ExchangeRate("ER1", 23.426));
        exchangeRateList.add(new ExchangeRate("ER2", 0.904));
        
        int option = 0;
        
        while (option != OPTION_QUIT) {
        	C206_CaseStudy.menu();
        	option = Helper.readInt("Enter an option > ");
        	
        	if (option == OPTION_ADD) {
        		//add a new Exchange Rate
        		C206_CaseStudy.setHeader("ADD A NEW EXCHANGE RATE");
        		
        		ExchangeRate er = inputExchangeRate();
        		C206_CaseStudy.addExchangeRate(exchangeRateList, er);
        		System.out.println("Exchange Rate added!");
        		
        }  else if (option == OPTION_VIEW) {

        	C206_CaseStudy.viewAllExchangeRates(exchangeRateList);
        	
        } else if (option == OPTION_DELETE) {
            C206_CaseStudy.setHeader("DELETE EXCHANGE RATE");
            String delExchangeRate = Helper.readString("Enter ID to delete > ");
            
        	C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, delExchangeRate);
        	System.out.println ("Exchange Rate removed!");
        	
        } else if (option == OPTION_QUIT) {
			System.out.println("Thank You for Using Rate Management!");
		} else {
			System.out.println("Invalid option");
		}
        }
	}



	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println (header);
		Helper.line(80, "-");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
		System.out.println ("1. Add a Rate");
		System.out.println ("2. View all Rates");
		System.out.println ("3. Delete an existing Rate");
		System.out.println ("4. Quit");
	}
	
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	//================================= Option 1 Add a Rate =================================
	public static ExchangeRate inputExchangeRate() {
		String ID = Helper.readString("Enter ID > ");
		double Rate = Helper.readDouble("Enter Rate > ");
		
		ExchangeRate er = new ExchangeRate(ID, Rate);
		return er;
	}
	
	public static void addExchangeRate(ArrayList<ExchangeRate> exchangeRateList, ExchangeRate er) {
		ExchangeRate exchangeR;
		for (int i = 0; i < exchangeRateList.size(); i++) {
			exchangeR = exchangeRateList.get(i);
			if (exchangeR.getID().equalsIgnoreCase(er.getID()) )
				return;
		}
		if (er.getID().isEmpty())  {
			return;
		}
		exchangeRateList.add(er);
	}
	
	//================================= Option 2 View Rates =================================
	public static String retrieveAllExchangeRates(ArrayList<ExchangeRate> exchangeRateList) {
		
		String output = "";
		for (int i=0; i< exchangeRateList.size(); i++) {
				    output += exchangeRateList.get(i).toString();
				
			}
		
		return output;
	}

	public static void viewAllExchangeRates(ArrayList<ExchangeRate> exchangeRateList) {
		C206_CaseStudy.setHeader("EXCHANGE RATES LIST");
		String output = String.format("%-10s %-20s\n", "ID", "RATE");
		output += retrieveAllExchangeRates(exchangeRateList);
		System.out.println(output);
		
	}

	//================================= Option 3 Delete Rate =================================
	public static String doDeleteExchangeRate(ArrayList<ExchangeRate> exchangeRateList, String del) {
		// TODO Auto-generated method stub
		String output = "";
		
		boolean found = false;
		for (int i = 0; i < exchangeRateList.size(); i++) {

			if (exchangeRateList.get(i).getID().equalsIgnoreCase(del)) {
				exchangeRateList.remove(i);
				found = true;
				output = "Exchange rate deleted successfully";
				break;
			}
			else {
				found = false;
				output = "Exchange rate cannot be found";
			}
		}
		return output;	
		
	}
}



