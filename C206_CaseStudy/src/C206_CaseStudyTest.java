import static org.junit.Assert.assertEquals;  
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
    
	private ExchangeRate er1;
	private ExchangeRate er2;
	private ExchangeRate er3;
	private ExchangeRate er4;
	private ExchangeRate er5;
	
	private ArrayList<ExchangeRate> exchangeRateList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		er1 = new ExchangeRate("ER1", "USD", "EUR", 0.85);
		er2 = new ExchangeRate("ER2", "USD", "GBP", 0.74);
		er3 = new ExchangeRate("ER3", "EUR", "JPY", 128.92);
		er4 = new ExchangeRate("ER4", "SGD", "JPY", 0.01);
		er5 = new ExchangeRate("ER5", "SGD", "HKD", 1000.01);
		
		exchangeRateList = new ArrayList<ExchangeRate>();
		
	}

	@After
	public void tearDown() throws Exception {
		exchangeRateList.clear();
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
   

    }


    
