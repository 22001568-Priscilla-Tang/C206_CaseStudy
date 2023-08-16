import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	// Exchange Pris
	private ExchangeRate er1;
	private ExchangeRate er2;
	private ExchangeRate er3;
	private ExchangeRate er4;
	private ExchangeRate er5;

	private ArrayList<ExchangeRate> exchangeRateList;
	//

	//User Clyde
	private User cc1;
	private User cc2;
	private User cc3;
	private User cc4_missing;
	private User cc5;
	private User cc6;

	private User ca1;
	private User ca2;
	private User ca3;
	private User ca4;
	private ArrayList<User> UserList;
	//

	// Account Adrian
	
	
	private Account a1;
	private Account a2;
	private ArrayList<Account> aList;
	
	
	//
	

	//SHUYAN
	private ArrayList<Currency> currencylist;
	private Currency ccr1;
	private Currency ccr2;	
	//
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// Exchange Pris
		er1 = new ExchangeRate("ER1", "USD", "EUR", 0.85);
		er2 = new ExchangeRate("ER2", "USD", "GBP", 0.74);
		er3 = new ExchangeRate("ER3", "EUR", "JPY", 128.92);
		er4 = new ExchangeRate("ER4", "SGD", "JPY", 0.01);
		er5 = new ExchangeRate("ER5", "SGD", "HKD", 1000.01);

		exchangeRateList = new ArrayList<ExchangeRate>();

		// User Clyde
		UserList = new ArrayList<User>();
		cc1 = new User("C1122334I", "Sheng Hao", "Password", "shenghao@gmail.com", "98788722", "Customer");
		cc2 = new User("C5551232K", "Shu Yan", "password", "shuyan@yahoo.com", "90062523", "Customer");
		cc3 = new User("C1234567F", "Bob", "password", "bob@gmail.com", "88297361", "Customer");
		cc4_missing = new User("", "Timmy", "password", "bob@gmail.com", "88297361", "Customer");
		cc5 = new User("C5552922K", "hello", "coolpassword", "hello@hotmail.com", "80064231", "Customer");
		cc6 = new User("C0992562E", "chingchong", "verycoolpassword", "chingchong@hotmail.com", "80092631", "Customer");
		ca1 = new User("A1122334I", "Clyde", "Password", "clydechuaky@gmail.com", "88112581", "Administrator");
		ca2 = new User("A6622838D", "Adrian", "CoolPassword", "Cedric@hotmail.com", "83220688", "Administrator");
		ca3 = new User("A9283922K", "tom", "coolpassword", "tom@hotmail.com", "98982231", "Administrator");
		ca4 = new User("A9512562E", "jimm", "verycoolpassword", "jimm@hotmail.com", "99172631", "Administrator");
		
		// Account Adrian
		
		a1 = new Account("12345", 001, "alice123");
		a2 = new Account("12345", 002, "johnlol123", 600.70);
	    aList = new ArrayList<Account>();
		
		//
	    // SHUYAN
	    ccr1 = new Currency("CP1", "USD", "SGD", 1.99);
		ccr2 =  new Currency("CP2", "EUR", "CHF", 100.7);
		currencylist = new ArrayList<Currency>();	
	 	//
		
	}

	@After
	public void tearDown() throws Exception {
		exchangeRateList.clear();
		UserList.clear();
		ccr1 = null;
		ccr2 = null;
		currencylist.clear();
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest",true);

	}
	@Test 
	public void testAddExchangeRate() {

		//TEST CASE 1 - Normal
		//Exchange Rate list is not null and it is empty
		assertNotNull("Test if there is valid Exchange Rate arraylist to add to", exchangeRateList);
		assertEquals("Test that the Exchange Rate arraylist is empty", 0, exchangeRateList.size());

		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
		assertEquals("Test that the Exchange Rate arraylist size is 1.", 1, exchangeRateList.size());
		assertSame("Test that Exchange Rate is added to the end of the list.", er1, exchangeRateList.get(0));

		//TEST CASE 2 - Error
		//Add an item that already exists in the list
		C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
		assertEquals("Test that the Exchange Rate arraylist size remains unchanged.", 1, exchangeRateList.size());

		//TEST CASE 3 - Boundary
		//add a min and max exchange rate
		C206_CaseStudy.addExchangeRate(exchangeRateList, er4); //min rate
		C206_CaseStudy.addExchangeRate(exchangeRateList, er5); //max rate
		assertEquals("Test that the Exchange Rate arraylist size is 3.", 3, exchangeRateList.size());


	}
	@Test 
	public void testViewAllExchangeRate() {

		//TEST CASE 1 - Error
		//Test if Exchange Rate list is not null and empty
		assertNotNull("Test if there is valid Exchange Rate arraylist to add to", exchangeRateList);
		assertEquals("Test that the Exchange Rate List is empty.", 0 , exchangeRateList.size());

		//attempt to retrieve exchange rates
		String allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);
		String testOutput = "";

		//test if output is empty
		assertEquals("Test that nothing is displayed", testOutput, allExchangeRates);

		//TEST CASE 2 - Normal
		//add 2 exchange rates
		C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
		C206_CaseStudy.addExchangeRate(exchangeRateList, er2);

		//test that list is not empty - size is 2 after adding 2 exchange rates
		assertEquals("Test that Exchange Rate arraylist size is 2.", 2, exchangeRateList.size());

		//attempt to retrieve exchange rates
		allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);
		testOutput += String.format("%-10s %-30s %-20s %-20s\n", er1.getID(),er1.getSourceCurrency(), er1.getTargetCurrency(), er1.getRate());
		testOutput += String.format("%-10s %-30s %-20s %-20s\n", er2.getID(),er2.getSourceCurrency(), er2.getTargetCurrency(), er2.getRate());

		assertEquals("Test that output is correct", testOutput, allExchangeRates);

		//TEST CASE 3 - Boundary
		//add 2 exchange rates (min and max rates)
		C206_CaseStudy.addExchangeRate(exchangeRateList, er4);
		C206_CaseStudy.addExchangeRate(exchangeRateList, er5);

		//test that list is not empty - 4 exchange rates as we added 2 from previous test case 
		assertEquals("Test that Exchange Rate arraylist size is 4.", 4, exchangeRateList.size()); 

		//attempt to retrieve exchange rates
		allExchangeRates = C206_CaseStudy.retrieveAllExchangeRates(exchangeRateList);
		testOutput += String.format("%-10s %-30s %-20s %-20s\n", er4.getID(), er4.getSourceCurrency(), er4.getTargetCurrency(),er4.getRate());
		testOutput += String.format("%-10s %-30s %-20s %-20s\n", er5.getID(),  er5.getSourceCurrency(), er5.getTargetCurrency(), er5.getRate());

		assertEquals("Test that output is correct", testOutput, allExchangeRates);
	}
	@Test
	public void testDoDeleteExchangeRate() {

		//TEST CASE 1 - Normal
		//add 2 exchange rates and delete first exchange rate
		C206_CaseStudy.addExchangeRate(exchangeRateList, er1);
		C206_CaseStudy.addExchangeRate(exchangeRateList, er2);

		//test that list is not empty
		assertEquals("Test that Exchange Rate arraylist size is 2.", 2, exchangeRateList.size());

		//attempt to delete one exchange rate 
		C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, er1.getID());

		//test that list size becomes 1
		assertEquals("Test that Exchange Rate arraylist size is 1.", 1, exchangeRateList.size());

		//TEST CASE 2 - Error
		//delete non-existent exchange rate
		C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, er4.getID());
		assertEquals("Test that Exchange Rate arraylist size is 1", 1, exchangeRateList.size());

		//TEST CASE 3 - Boundary
		//add 2 exchange rates (min and max) and delete the minimum exchange rate in the list
		C206_CaseStudy.addExchangeRate(exchangeRateList, er4);
		C206_CaseStudy.addExchangeRate(exchangeRateList, er5);

		//attempt to delete minimum exchange rate 
		C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, er4.getID());

		//test that list size becomes 2 since there are 1(from previous test case) + 2 then minus 1 exchange rate
		assertEquals("Test that Exchange Rate arraylist size is 2.", 2, exchangeRateList.size());

		//attempt to delete maximum exchange rate
		C206_CaseStudy.doDeleteExchangeRate(exchangeRateList, er5.getID());

		//test that list size becomes 1 
		assertEquals("Test that Exchange Rate arraylist size is 1.", 1, exchangeRateList.size());


	}


	// User Clyde
	@Test
	public void testAddUser() {
		C206_CaseStudy c206_CaseStudy = new C206_CaseStudy();
		// User list is not null and its size is 0
		assertNotNull("Test if there is valid UserList arraylist to add to", UserList);
		assertEquals("Test if the size of the UserList arraylist is 0", 0, UserList.size());

		//Given an empty list, after adding 1 item, the size of the list is 1
		c206_CaseStudy.addUser(UserList, ca1);		
		assertEquals("Test that the User arraylist size is 1.", 1, UserList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", ca1, UserList.get(0));

		// Add a User
		c206_CaseStudy.addUser(UserList, cc2);
		assertEquals("Test that the User arraylist size is now 2.", 2, UserList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", cc2, UserList.get(1));

		// Add an item that already exists in the list
		c206_CaseStudy.addUser(UserList, cc2);
		assertEquals("Test that the User arraylist size is unchange.", 2, UserList.size());

		// Add an item that has missing detail
		c206_CaseStudy.addUser(UserList, cc4_missing);
		assertEquals("Test that the User arraylist size is unchange.", 2, UserList.size());
	}

	@Test
	public void testRetrieveAllAdmin() {
		C206_CaseStudy c206_CaseStudy = new C206_CaseStudy();
		// Test Case 1
		// Test if the user list is empty and is not null
		assertNotNull("Test that if there is a valid userlist to add to", UserList);
		assertEquals("Test that the userlist is empty", 0, UserList.size());
		// Attempt to view the lsit
		String allAdmin = c206_CaseStudy.RetriveAllAdmin(UserList);
		String testOutput = "NO ADMIN ROLES\n";
		// Test if the output is correct
		assertEquals("Test that it displays correctly", testOutput, allAdmin);

		// Test Case 2
		c206_CaseStudy.addUser(UserList, ca3);
		c206_CaseStudy.addUser(UserList, ca4);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, UserList.size());
		// Attempt to retrieve the Admins 
		allAdmin = c206_CaseStudy.RetriveAllAdmin(UserList);
		testOutput = String.format("%-15s %-15s %-15s %-25s %-15s\n", "A9283922K", "tom", "coolpassword", "tom@hotmail.com", "98982231");
		testOutput += String.format("%-15s %-15s %-15s %-25s %-15s\n", "A9512562E", "jimm", "verycoolpassword", "jimm@hotmail.com", "99172631");
		testOutput += String.format("---------------------------------------------------------------------------------------");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allAdmin);
	}

	@Test
	public void testRetrieveAllCustomers() {
		C206_CaseStudy c206_CaseStudy = new C206_CaseStudy();
		// Test Case 1
		// Test if the user list is empty and is not nullUserList
		assertNotNull("Test that if there is a valid userlist to add to", UserList);
		assertEquals("Test that the userlist is empty", 0, UserList.size());
		// Attempt to view the lsit
		String allCustomer = c206_CaseStudy.RetrieveAllCustomers(UserList);
		String testOutput = "NO CUSTOMER ROLES\n";
		// Test if the output is correct
		assertEquals("Test that it displays correctly", testOutput, allCustomer);

		// Test Case 2
		c206_CaseStudy.addUser(UserList, cc5);
		c206_CaseStudy.addUser(UserList, cc6);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, UserList.size());
		// Attempt to retrieve the Customers 
		allCustomer = c206_CaseStudy.RetrieveAllCustomers(UserList);
		testOutput = String.format("%-15s %-15s %-15s %-25s %-15s\n", "C5552922K", "hello", "coolpassword", "hello@hotmail.com", "80064231");
		testOutput += String.format("%-15s %-15s %-15s %-25s %-15s\n", "C0992562E", "chingchong", "verycoolpassword", "chingchong@hotmail.com", "80092631");
		testOutput += String.format("---------------------------------------------------------------------------------------");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCustomer);
	}

	@Test
	public void testDeleteUser() {
		C206_CaseStudy c206_CaseStudy = new C206_CaseStudy();
		// Test Case 1
		// Test if the user list is empty and is not nullUserList
		assertNotNull("Test that if there is a valid userlist to add to", UserList);
		assertEquals("Test that the userlist is empty", 0, UserList.size());

		// Test Case 2
		c206_CaseStudy.addUser(UserList, cc1);
		c206_CaseStudy.addUser(UserList, cc2);
		c206_CaseStudy.addUser(UserList, ca1);

		// Test that the list is not empty
		assertEquals("Test that the User arraylist size is 3", 3, UserList.size());
		// Attempt to remove Customer Sheng Hao
		c206_CaseStudy.DeleteUser(UserList, "C1122334I");
		assertEquals("Test that the User arraylist size is now 2", 2, UserList.size());

		// Test Case 3
		// Delete a User that does not exist in the list
		c206_CaseStudy.DeleteUser(UserList, "C8282227B");
		assertEquals("Test tha the userlist size is unchange.", 2, UserList.size());
	}
	
	@Test
	public void testAddAccount() {
		assertNotNull("Check if there is valid Account arraylist to add to", aList);
		
		C206_CaseStudy.addAccount(aList, a1);
		assertEquals("Check that Account arraylist size is 1", 1, aList.size());
		assertSame("Check that Account is added", a1, aList.get(0));
		
		C206_CaseStudy.addAccount(aList, a2);
		assertEquals("Check that Account arraylist size is now 2", 2, aList.size());
		assertSame("Check that Account is added", a2, aList.get(1));
		
	}

	@Test
	public void testViewAccounts() {
		
		assertNotNull("Check if there is valid Account arraylist to retrieve from", aList);
		
		String allAccounts= C206_CaseStudy.viewAllAccounts(aList, "12345");
		String testOutput = String.format("ACCOUNT LIST FOR USER ID %s \n------------------------------------------------------------------\n%-10s %-11s %-10s\n","12345" , "ACCOUNT ID", "STATUS", "BALANCE");
		
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allAccounts);
		
		C206_CaseStudy.addAccount(aList, a1);
		C206_CaseStudy.addAccount(aList, a2);
		
		assertEquals("Check that Account arraylist size is 2", 2, aList.size());
		
		allAccounts = C206_CaseStudy.viewAllAccounts(aList, "12345");
		
		testOutput += String.format("%-10d %-12s $%-10.2f\n", 001, "ACTIVE", 0.00);
		testOutput += String.format("%-10d %-12s $%-10.2f\n", 002, "ACTIVE", 600.70);
		
		assertEquals("Test the viewAccounts", allAccounts, testOutput);
		
	}
	@Test
	public void testRemoveAccount() {
		
		assertNotNull("Check if there is a valid Account arraylist to add to", aList);
		
		C206_CaseStudy.addAccount(aList, a1);
		
		assertEquals("Check that the Account arraylist size is 1", 1, aList.size());
		
		assertTrue("Check that the account is removed", C206_CaseStudy.removeAccount(aList, 001, "alice123"));
		
		assertTrue("Check that the Account arraylist is now empty", aList.isEmpty());
		
		assertFalse("Check that an empty account cannot be removed.", C206_CaseStudy.removeAccount(aList, 005, ""));
		
	}
	@Test
    public void testAddCurrency() {
        assertEquals("Test that currency list is empty.", 0, currencylist.size());
        
        C206_CaseStudy.addCurrency(currencylist, ccr1);
        assertEquals("Test that currency list size is 1 after adding a currency.", 1, currencylist.size());
        
        assertEquals("test that element added is the same as the arraylist element",currencylist.get(0), ccr1);
        
        C206_CaseStudy.addCurrency(currencylist, ccr2);
        assertEquals("Test that currency list size is 2 after adding another currency.", 2, currencylist.size());

        // error
        C206_CaseStudy.addCurrency(currencylist, ccr2);
        assertEquals("Test that currency list size remains 2 after adding an existing currency.", 2, currencylist.size());
        // boundary
    	Currency cc_missing = new Currency("CP4", "", "USD", 100.0);
		C206_CaseStudy.addCurrency(currencylist, cc_missing);
		assertEquals("Test that the Currency arraylist size is unchange.", 2, currencylist.size());
    }
    @Test
    public void testViewCurrency() {
    assertNotNull("Test that currency arraylist is not null",currencylist);
    assertEquals("test that currency arraylist is  empty",0, currencylist.size() );
    
    	C206_CaseStudy.addCurrency(currencylist, ccr1);
    	C206_CaseStudy.addCurrency(currencylist, ccr2);
    	
    	String actualoutput = C206_CaseStudy.retrieveAllCurrency(currencylist);
		assertEquals("Test that Currency arraylist size is 2.", 2, currencylist.size());
		
		String expectedOutput = String.format("%-15s %-15s %-18s %-15.2f\n", "CP1", "USD", "SGD", 1.99);
        expectedOutput += String.format("%-15s %-15s %-18s %-15.2f\n", "CP2", "EUR", "CHF", 100.7);
		
        
        assertEquals("Test that currency list is not empty and displays correctly.", expectedOutput,actualoutput);
        
        
    }
    @Test
    public void testDeleteCurrency() {
        assertEquals("Test that currency list is empty.", 0, currencylist.size());

        C206_CaseStudy.addCurrency(currencylist,ccr1);
        assertEquals("Test that currency list size is 1 after adding a currency.", 1, currencylist.size());

        C206_CaseStudy.DeleteCurrency(currencylist, "CP1");
        assertEquals("Test that currency list is empty after deleting a currency.", 0, currencylist.size());

        // Add a currency before testing delete
        C206_CaseStudy.addCurrency(currencylist,ccr2);

        C206_CaseStudy.DeleteCurrency(currencylist, "CP2");
        assertEquals("Test that currency list size remains 0 after deleting a currency.", 0, currencylist.size());
        
        C206_CaseStudy.DeleteCurrency(currencylist, "Cp3");
        assertEquals("Test that currency list size remains 0 after attempting to delete a non-existent currency.", 0, currencylist.size());
    }


}



