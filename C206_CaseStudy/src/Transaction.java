import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: {Glendon Goh}
 * Student ID: {22014691}
 * Class: {W64E}
 * Date/Time created: Sunday 13-08-2023 22:24
 */

/**
 * @author Glrndon Goh
 *
 */
public class Transaction {

	private String date;
	private String description;
	private double amount;
	private String transactionType;
	private String transaction_id;
	/**
	 * @param date
	 * @param description
	 * @param amount
	 * @param transactionType
	 */
	public Transaction(String transaction_id ,String date, String description, double amount, String transactionType) {
		this.transaction_id = transaction_id;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.transactionType = transactionType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getTransaction_id() {
		return transaction_id;
	}
	
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}


}


