/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Clyde, 15 Aug 2023 5:07:49 pm
 */

/**
 * @author Clyde
 *
 */
public class User {

	private String UserID;
	private String UserName;
	private String PW;
	private String Email;
	private String PHnumber;
	private String Role;
	
	public User(String userID, String userName, String pW, String email, String pHnumber, String role) {
		UserID = userID;
		UserName = userName;
		PW = pW;
		Email = email;
		PHnumber = pHnumber;
		Role = role;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPHnumber() {
		return PHnumber;
	}

	public void setPHnumber(String pHnumber) {
		PHnumber = pHnumber;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
}
