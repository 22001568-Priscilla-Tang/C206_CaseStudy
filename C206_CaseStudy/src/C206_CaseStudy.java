import java.util.ArrayList;

public class C206_CaseStudy {

	// Pris
	private static final int OPTION_QUIT = 4;

	private static final int OPTION_ADD = 1;

	private static final int OPTION_VIEW = 2;

	private static final int OPTION_DELETE = 3;

	private static final String idPattern = "ER\\d+$";

	private static final double MIN_RATE = 0.0;

	
	//
	//shuyan
	private static final int MAX_OPTION = 4;
	//

	// User Clyde
	private static ArrayList<User> UserList = new ArrayList<User>();

	public static void main(String[] args) {		

		// ====================================== Initialising Phase =============================//
		//SHUYAn
		ArrayList<Currency> currencyList = new ArrayList<Currency>();

		currencyList.add(new Currency("CP1", "TWD", "SGD", 1.77));
		currencyList.add(new Currency("CP2", "AUD", "SGD", 1995.76));


		// Pris 
		ArrayList<ExchangeRate> exchangeRateList = new ArrayList<ExchangeRate>();
		String allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);

		exchangeRateList.add(new ExchangeRate("ER1", "SGD", "TWD",23.426));
		exchangeRateList.add(new ExchangeRate("ER2", "AUD", "SGD", 0.904));
		//

		// Clyde

		C206_CaseStudy c206_CaseStudy = new C206_CaseStudy();
		UserList.add(new User("A1122334I", "Clyde", "Password", "clydechuaky@gmail.com", "88112581", "Administrator"));
		UserList.add(new User("C1122334I", "Sheng Hao", "Password", "shenghao@gmail.com", "98788722", "Customer"));

		//

		// Adrian
		ArrayList<Account> aList = new ArrayList<Account>();
		aList.add(new Account("C1122334I",001, "Password2", 50.0));
		aList.add(new Account("C7654321I",002, "Password3", 80.0));
		aList.add(new Account("C1234567I", 003, "Password3", 100.0));
		//

		// =======================================================================================//

		int start = 0;
		while (start != 3) {
			StartMenu();
			start = Helper.readInt("Enter an option > ");
			if (start == 1) {
				String userID = Helper.readString("Enter your UserID > ");
				String pw = Helper.readString("Enter your password > ");
				int result = C206_CaseStudy.FindUser(UserList, userID, pw);
				if (result >= 0) {
					System.out.println("Successful Login");
					if (UserList.get(result).getRole() == "Customer") {
						// Display the Customer Menu
						int customer = 0;
						while (customer != 6) {
							Customermenu();
							customer = Helper.readInt("Enter an option > ");
							if (customer == 1) {
								// Viewing Exchange Rate
								// View Exchange Rate
								C206_CaseStudy.viewAllExchangeRates(exchangeRateList);
							} else if (customer == 2) {
								// Viewing Currency
								C206_CaseStudy.ViewCurrency(currencyList);

							} else if (customer == 3) {
								// Account

								int account = 4;
								accountMenu();
								while (account != 4) {

									if (account == 1) {

										addAccount(aList, new Account(uid(),accId(),password()));
										account = Helper.readInt("1-3 > ");
									} else if (account == 2) {
										System.out.println(viewAllAccounts(aList, uid()));
									} else if (account == 3) {
										removeAccount(aList, accId(), password());

									} else if (account == 4) {
										changeStatus(aList, accId(),password(),status());
									}
									account = Helper.readInt("Enter option 1-3 > ");
									accountMenu();
								}

							} else if (customer == 4) {
								// FeedBack

							} else if (customer == 5) {
								// Transaction

							} else if (customer == 6) {
								System.out.println("Logging Out");
							} else {
								System.out.println("Invalid Option");
							}
						}

					} else {
						// Display Admin Menu
						int admin = 0;
						while (admin != 6) {
							Adminmenu();
							admin = Helper.readInt("Enter an option > ");
							if (admin == 1) {
								// User
								int userOpt = 0;
								while (userOpt != 4) {
									Usermenu();
									userOpt = Helper.readInt("Enter an Option > ");
									if (userOpt == 1) {
										C206_CaseStudy.setHeader("ADDING USER");
										// Add User
										User cc = inputUser();
										c206_CaseStudy.addUser(UserList, cc);
										System.out.println("User Added Succesfully");
									} else if (userOpt == 2) {
										C206_CaseStudy.setHeader("VIEWING ALL USERS");
										c206_CaseStudy.viewAllAdmins(UserList);
										c206_CaseStudy.viewAllCustomer(UserList);
									} else if (userOpt == 3) {
										C206_CaseStudy.setHeader("DELETE USER");
										// Asking for USERID of User that you want to delete
										String UserID = Helper.readString("Enter the UserID of the User you want to delete: ");
										c206_CaseStudy.DeleteUser(UserList, UserID);
									} else if (userOpt == 4) {
										System.out.println("Going Back to Admin Menu");
									} else {
										System.out.println("Invalid Option");
									}
								}
							} else if (admin == 2) {
								// Exchange Rate
								int ExOpt = 0;
								while (ExOpt != 4) {
									Exchangemenu();
									ExOpt = Helper.readInt("Enter an Option > ");
									if (ExOpt == 1) {
										//add a new Exchange Rate
										C206_CaseStudy.setHeader("ADD A NEW EXCHANGE RATE");
										ExchangeRate er = inputExchangeRate();
										C206_CaseStudy.addExchangeRate(exchangeRateList, er);
										System.out.println("Exchange Rate added!");
									} else if (ExOpt == 2) {
										// View Exchange Rate
										C206_CaseStudy.viewAllExchangeRates(exchangeRateList);
									} else if (ExOpt == 3) {
										// Delete Exchange Rate
										C206_CaseStudy.setHeader("DELETE EXCHANGE RATE");
										String delExchangeRate = Helper.readStringRegEx("Enter ID to delete > ", idPattern);
										C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, delExchangeRate);
									} else if (ExOpt == 4) {
										System.out.println("Going Back to Admin Menu");
									} else {
										System.out.println("Invalid Option");
									}
								}
							} else if (admin == 3) {
								// Currency
								int currencyOption = 0;
								while (currencyOption != 4) {
									displayCurrencyMenu();
									 currencyOption = Helper.readInt("Enter the option you want for Currency > ");

									if (currencyOption == OPTION_ADD) {
										Currency newCurrency = inputCurrency();
										addCurrency(currencyList, newCurrency);
									} else if (currencyOption == OPTION_VIEW) {
										ViewCurrency(currencyList);
									} else if (currencyOption == OPTION_DELETE) {
										String currencyToDelete = inputDelete(currencyList);
										DeleteCurrency(currencyList, currencyToDelete);
									}
									else if (currencyOption == MAX_OPTION) {
										System.out.println("Going Back to Admin Menu");
									}
									else {
										System.out.println("Invalid Option");
									}
								}


							} else if (admin == 4) {
								// Account

							} else if (admin == 5) {
								// FeedBack

							} else if (admin == 6) {
								System.out.println("Logging Out");
							} else {
								System.out.println("Invalid Option");
							}
						}
					}
				} else if (result == -1) {
					System.out.println("Invalid Login"); 
				}
			} else if (start == 2) {
				// Insert Creating Account Here
			} else if (start == 3) {
				System.out.println("Thanks For Using Money Exchange Management System");
			} else {
				System.out.println("Invalid Option");
			}
		}

	}

	public static void StartMenu() {
		C206_CaseStudy.setHeader("*** WELCOME TO MONEY EXCHANGE MANAGEMENT SYSTEM ***");
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("3. Quit");
	}

	public static void Adminmenu() {
		C206_CaseStudy.setHeader("ADMIN MENU");
		System.out.println("1. User");
		System.out.println("2. Exchange Rate");
		System.out.println("3. Currency");
		System.out.println("4. Account");
		System.out.println("5. FeedBack");
		System.out.println("6. LogOut");
		Helper.line(80, "-");

	}

	public static void Customermenu() {
		C206_CaseStudy.setHeader("CUSTOMER MENU");
		System.out.println("1. View Exchange Rate");
		System.out.println("2. View Currency");
		System.out.println("3. Account");
		System.out.println("4. Feedback");
		System.out.println("5. Transaction");
		System.out.println("6. LogOut");
		Helper.line(80, "-");

	}

	public static void Usermenu() {
		C206_CaseStudy.setHeader("USER FUNCTIONS");
		System.out.println("1. Add User");
		System.out.println("2. View All Users");
		System.out.println("3. Delete User");
		System.out.println("4. Back");
		Helper.line(80, "-");
	}


	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println (header);
		Helper.line(80, "-");
	}

	public static void Exchangemenu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
		System.out.println ("1. Add a Rate");
		System.out.println ("2. View all Rates");
		System.out.println ("3. Delete an existing Rate");
		System.out.println ("4. Back");
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

	public static void displayCurrencyMenu() {
		C206_CaseStudy.setHeader("CURRENCY MANAGEMENT SYSTEM");
		System.out.println("1. Add Currency");
		System.out.println("2. View Currency");
		System.out.println("3. Delete Currency");
		System.out.println("4. Back");
	}



	//================================= Option 1 Add a Rate =================================
	public static ExchangeRate inputExchangeRate() {

		String ID = Helper.readStringRegEx("Enter ID > ", idPattern);
		String SourceC = Helper.readString("Enter Source Currency > ");
		String TargetC = Helper.readString("Enter Target Currency > ");
		double Rate = Helper.readDouble("Enter Rate > ");

		while (isValidRate(Rate) == false) {
			System.out.println ("Rate cannot be negative");
			Rate = Helper.readDouble("Enter new Rate > ");
		}
		ExchangeRate er = new ExchangeRate(ID, SourceC, TargetC, Rate);
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
		String output = String.format("%-10s %-30s %-20s %-20s\n", "ID", "SOURCE CURRENCY", "TARGET CURRENCY",  "RATE");
		output += retrieveAllExchangeRates(exchangeRateList);
		System.out.println(output);

	}

	//================================= Option 3 Delete Rate =================================
	public static void doDeleteExchangeRate(ArrayList<ExchangeRate> exchangeRateList, String del) {
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
		System.out.println (output);

	}

	//function to validate rate
	public static boolean isValidRate(double rate) {
		return rate >= MIN_RATE;
	}

	//======================================== User ========================================//
	// User Clyde

	public static int FindUser(ArrayList<User> UserList, String UserID, String password) {
		int result = -1;
		for (int i = 0; i < UserList.size(); i++) {
			if (UserList.get(i).getUserID().equalsIgnoreCase(UserID) && UserList.get(i).getPW().equals(password)) {
				result = i;
				return result;
			}
		}
		return result;
	}

	public static User inputUser() {
		String UserID = Helper.readString("Enter UserID > ");
		String name = Helper.readString("Enter name > ");
		String pw = Helper.readString("Enter password > ");
		String email = Helper.readString("Enter email > ");
		String phnumber = Helper.readString("Enter phone number > ");
		String role = Helper.readString("Enter Role (Either 'Customer' or 'Administrator') > ");

		User cc= new User(UserID, name, pw, email, phnumber, role);
		return cc;

	}
	public void addUser(ArrayList<User> UserList, User cc) {
		User user;
		for(int i = 0; i < UserList.size(); i++) {
			user = UserList.get(i);
			if (user.getUserID().equalsIgnoreCase(cc.getUserID()) || user.getEmail().equalsIgnoreCase(cc.getEmail()) || user.getPHnumber().equalsIgnoreCase(cc.getPHnumber()))
				return;
		}
		if (cc.getUserID().isEmpty() || cc.getUserName().isEmpty() || cc.getPW().isEmpty() || cc.getEmail().isEmpty() || cc.getPHnumber().isEmpty() || cc.getRole().isEmpty())
			return;

		if (!checkUserID(cc.getUserID()))
			return;

		if (!checkEmail(cc.getEmail()))
			return;

		if (!verifyPhoneNumber(cc.getPHnumber()))
			return;

		if (!verifyRole(cc.getRole()))
			return;

		UserList.add(cc);
	}

	public String RetriveAllAdmin(ArrayList<User> UserList) {
		String output = "";
		boolean anyAdmin = false;
		for (User user : UserList) {
			if (user.getRole().equals("Administrator")) {
				anyAdmin = true;
				output += String.format("%-15s %-15s %-15s %-25s %-15s\n", user.getUserID(), user.getUserName(), 
						user.getPW(), user.getEmail(), user.getPHnumber());
			}
		}
		if (anyAdmin == false) {
			output = String.format("NO ADMIN ROLES\n");
		} else {
			output += String.format("---------------------------------------------------------------------------------------");
		}
		return output;
	}

	public void viewAllAdmins(ArrayList<User> UserList) {
		// Base Output for Admin
		String output = String.format("ROLE: ADMINISTRATOR\n");
		output += String.format("%-15s %-15s %-15s %-25s %-15s\n", "USERID", "USERNAME", "PASSWORD", "EMAIL", "PHONE NUMBER");
		output += RetriveAllAdmin(UserList);
		System.out.println(output);
	}

	public String RetrieveAllCustomers(ArrayList<User> UserList) {
		String output = "";
		boolean anyCustomer = false;
		for (User user : UserList) {
			if (user.getRole().equals("Customer")) {
				anyCustomer = true;
				output += String.format("%-15s %-15s %-15s %-25s %-15s\n", user.getUserID(), user.getUserName(),
						user.getPW(), user.getEmail(), user.getPHnumber());
			}
		}
		if (anyCustomer == false) {
			output = String.format("NO CUSTOMER ROLES\n");
		} else {
			output += String.format("---------------------------------------------------------------------------------------");
		}
		return output;
	}

	public void viewAllCustomer(ArrayList<User> UserList) {
		// Base Output for Admin
		String output = String.format("\nROLE: CUSTOMER\n");		
		output += String.format("%-15s %-15s %-15s %-25s %-15s\n", "USERID", "USERNAME", "PASSWORD", "EMAIL", "PHONE NUMBER");
		output += RetrieveAllCustomers(UserList);
		System.out.println(output);
	}

	public void DeleteUser (ArrayList<User> UserList, String UserID) {

		Helper.line(50, "-");
		System.out.println("DELETING USER");
		Helper.line(50, "-");

		boolean isFound = false;

		// Verify whether User is in the system
		for (int i = 0; i < UserList.size(); i++) {
			User user = UserList.get(i);
			if (user.getUserID().equals(UserID)) {
				isFound = true;
				// Displaying the User that has been found in the UserList
				String output = String.format("%-20s\n", "USER FOUND");
				output += String.format("%-20s\n", "-------------------------");
				output += String.format("UserID: %-20s\n", user.getUserID());
				output += String.format("UserName: %-20s\n", user.getUserName());
				output += String.format("Password: %-20s\n", user.getPW());
				output += String.format("Email: %-20s\n", user.getEmail());
				output += String.format("Phone Number: %-20s\n", user.getPHnumber());
				output += String.format("Role: %-20s\n", user.getRole());
				output += String.format("%-20s\n", "-------------------------");
				System.out.println(output);
				UserList.remove(i);
				break;
			}
		}
		if (isFound == false) {
			System.out.println("This User does not exist");
		}
	}

	public static boolean checkUserID (String UserID) {
		if (UserID.charAt(0) == 'A' || UserID.charAt(0) == 'C') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkEmail(String email) {
		int count = 0;
		int count2 = 0;

		if (email.contains("@") == false || email.contains(".") == false) {
			return false;
		}

		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				count++;
			}
		}

		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				count2++;
			}
		}
		if (count > 1 || count2 > 1) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean verifyPhoneNumber(String phnumber) {
		if (phnumber.length() == 8) {
			if (phnumber.charAt(0) == '8' || phnumber.charAt(0) == '9') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public static boolean verifyRole (String role) {
		if (role.equalsIgnoreCase("Administrator") || role.equalsIgnoreCase("Customer")) {
			return true;
		} else {
			return false;
		}
	}





	//======================================== Currency SHU YAN ========================================//

	public static Currency inputCurrency() {
		String inputCurrencyPair = Helper.readString("Enter Currency Pair(CP#): ");
		String inputCurrencyCode = Helper.readString("Enter Currency Code: ");
		String inputCurrencyCode2 = Helper.readString("Enter Currency Code 2: ");
		double inputExchangeRate = Helper.readDouble("Enter Exchange Rate: ");
		inputCurrencyPair = inputCurrencyPair.toUpperCase();
		inputCurrencyCode = inputCurrencyCode.toUpperCase();
		inputCurrencyCode2 = inputCurrencyCode2.toUpperCase();

		return new Currency(inputCurrencyPair, inputCurrencyCode, inputCurrencyCode2, inputExchangeRate);
	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency newCurrency) {
		boolean validCurrencyPair = isValidCurrencyPair(newCurrency.getCurrencyPair());
		boolean validCurrencyCodes = isValidCurrencyCode(newCurrency.getCurrencyCode())
				&& isValidCurrencyCode(newCurrency.getCurrencyCode2());

		if (!validCurrencyPair) {
			System.out.println("Invalid currency pair format. Please try again.");
		} else if (!validCurrencyCodes) {
			System.out.println("Invalid currency code format. Please try again.");
		} else if (currencyPairExists(currencyList, newCurrency.getCurrencyPair())) {
			System.out.println("Currency pair already exists. Please try again.");
		} else if (currencyCodesSame(newCurrency)) {
			System.out.println("Currency codes cannot be the same. Please try again.");
		} else {
			currencyList.add(newCurrency);
			System.out.println("Currency added successfully!");
		}
	}

	private static boolean currencyPairExists(ArrayList<Currency> currencyList, String currencyPair) {
		for (Currency currency : currencyList) {
			if (currency.getCurrencyPair().equalsIgnoreCase(currencyPair)) {
				return true;
			}
		}
		return false;
	}

	private static boolean currencyCodesSame(Currency currency) {
		return currency.getCurrencyCode().equalsIgnoreCase(currency.getCurrencyCode2());
	}

	public static void ViewCurrency(ArrayList<Currency> currencyList) {
		if (currencyList.isEmpty()) {
			Helper.line(50,"-");
			System.out.println("No currencies available.");
			Helper.line(50,"-");
		}
		else {
			C206_CaseStudy.setHeader("CURRENCY LIST");
			String output = String.format("%-15s %-15s %-18s %-15s\n","CURRENCY PAIR", "CURRENCY CODE", "CURRENCY CODE 2", "EXCHANGE RATE");
			output += retrieveAllCurrency(currencyList);
			System.out.println(output);

		}
	}
	public static String retrieveAllCurrency(ArrayList<Currency> currencyList) {
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {
			output += String.format("%-15s %-15s %-18s %-15.2f\n", currencyList.get(i).getCurrencyPair(),currencyList.get(i).getCurrencyCode(), currencyList.get(i).getCurrencyCode2(), currencyList.get(i).getExchangeRate());
		}
		return output; 
	}
	public static String inputDelete(ArrayList<Currency> currencyList) {
		ViewCurrency(currencyList);
		String inputToDelete = Helper.readString("Enter the currency pair you want to delete> ");


		return inputToDelete;

	}

	public static void DeleteCurrency(ArrayList<Currency> currencyList, String inputToDelete) {
		if (currencyList.isEmpty()) {
			System.out.println("No currencies available to delete!");
		} else {
			boolean foundAndDeleted = false;

			for (int i = 0; i < currencyList.size(); i++) {
				if (inputToDelete.equalsIgnoreCase(currencyList.get(i).getCurrencyPair().trim().toUpperCase())) {
					currencyList.remove(i);
					foundAndDeleted = true;
					System.out.println("Currency deletion successful!");
					break; 
				}
			}

			if (!foundAndDeleted) {
				System.out.println("Currency pair not found. No currency deleted.");
			}
		}
	}
	private static boolean isValidCurrencyPair(String currencyPair) {

		return currencyPair.matches("^CP\\d+$");
	}

	private static boolean isValidCurrencyCode(String currencyCode) {

		return currencyCode.matches("^[A-Z]{3}$");
	}

	//=========================================================================================//

	//======================================== Account Adrian ========================================//

	public static String uid() {
		String uid = Helper.readString("Enter user ID > ");
		return uid;
	}

	public static void accountMenu() {
		System.out.println("------------------------------");
		System.out.println("1. ADD ACCOUNT");
		System.out.println("2. VIEW ALL ACCOUNTS");
		System.out.println("3. REMOVE ACCOUNTS");
		System.out.println("4. CHANGE STATUS OF ACCOUNT");
		System.out.println("------------------------------");
	}

	public static void addAccount(ArrayList<Account> aList, Account ac) {
		Account validate;

		for(int i = 0; i < aList.size(); i++) {
			validate = aList.get(i);
			if (validate.getAid() == ac.getAid()) {
				return;
			}
		}

		if(ac.getUid().isEmpty() || ac.getAid() == 0 || ac.getPassword().isEmpty()) {
			return;
		}

		aList.add(ac);

	}

	public static String viewAllAccounts(ArrayList<Account> aList, String uid) {


		String output = String.format("ACCOUNT LIST FOR USER ID %s \n------------------------------------------------------------------\n%-10s %-11s %-10s\n",uid , "ACCOUNT ID", "STATUS", "BALANCE");


		String stat;

		for(int i = 0; i < aList.size(); i++) {
			if(uid.equals(aList.get(i).getUid())) {

				if(aList.get(i).isStatus() == true) {
					stat = "ACTIVE";
				} else {
					stat = "INACTIVE";
				}

				output += String.format("%-10d %-12s $%-10.2f\n", aList.get(i).getAid(), stat, aList.get(i).getAmount());
			}
		}


		return output;
	}

	public static int accId() {
		int accId = Helper.readInt("Enter the account ID > ");
		return accId;
	}

	public static String password() {
		String password = Helper.readString("Enter password for account");
		return password;
	}

	public static boolean removeAccount(ArrayList<Account> aList, int accId, String password) {

		boolean z = false;
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).getAid() == accId && aList.get(i).getPassword().equals(password)) {
				aList.remove(i);
				z = true;
			}
		}

		if (z == true) {
			System.out.println("Account successfully removed!");
		} else {
			System.out.println("Removal failed!");
		}

		return z;
	}

	public static String status() {
		String status = Helper.readString("Enter new status of account (Active/Inactive) > ");
		return status;
	}

	public static boolean changeStatus(ArrayList<Account> aList, int aid, String password, String status) {

		boolean x = false;
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).getAid() == aid && aList.get(i).getPassword().equals(password)) {

				if (status.equalsIgnoreCase("Active")) {

					aList.get(i).setStatus(true);



				} else if (status.equalsIgnoreCase("Inactive")) {

					aList.get(i).setStatus(false);
				}

				x = true;
				break;

			}
		}

		if (x == true) {
			System.out.println(String.format("STATUS SUCCESSFULLY CHANGED TO %s", status));
		} else {
			System.out.println("SATUS CHANGE FAILED!");
		}

		return x;

	}
	//=========================================================================================//


	//=========================================== FeedBack =========================================//


































































	//=========================================================================================//

	//======================================== Transaction ========================================//


















































	//=========================================================================================//



}
