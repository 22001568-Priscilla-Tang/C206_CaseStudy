/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Sun Quan Adrian-Cedric, 22035080, Jul 10, 2023 3:42:10 PM
 */

/**
 * @author adrian
 *
 */
public class Account {
	private String uid;
	private int aid;
	private String password;
	private double amount;
	private boolean status;
	private String txnHistory;
	
	public Account(String uid, int aid, String password, double amount) {
		this.uid = uid;
		this.aid = aid;
		this.password = password;
		this.amount = amount;
		this.status = true;
		this.txnHistory = "";
	}
	
	public Account(String uid, int aid, String password) {
		this.uid = uid;
		this.aid = aid;
		this.password = password;
		this.amount = 0;
		this.status = true;
		this.txnHistory = "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUid() {
		return uid;
	}

	public int getAid() {
		return aid;
	}
	
	public String getTxnHistory() {
		return txnHistory;
	}
	
	public void setTxnHistory(String txnHistory) {
		this.txnHistory = txnHistory;
	}
	
}
