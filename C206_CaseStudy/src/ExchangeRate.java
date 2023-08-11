
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22001568, Jul 10, 2023 3:42:10 PM
 */

public class ExchangeRate {
	public String ID;
	public double rate;
	public boolean isAvailable;
	
	public ExchangeRate (String ID, double rate) {
		this.ID = ID;
		this.rate = rate;
		this.isAvailable = true;
       }
	   public String getID() {
		   return ID;
	   }
	  public void setID(String ID) {
		  this.ID = ID;
	  }
       public double getRate() {
    	   return rate;
       }
       public void setRate(double Rate) {
    	   this.rate = Rate;
       }
   	   public boolean getIsAvailable() {
		   return isAvailable;
	   }

	   public void setIsAvailable(boolean isAvailable) {
		   this.isAvailable = isAvailable;
	   }
	   
	   public String toString() {
		   return String.format("%-10s %-20.2f\n", ID, rate, C206_CaseStudy.showAvailability(isAvailable));
	   }
    }


       
