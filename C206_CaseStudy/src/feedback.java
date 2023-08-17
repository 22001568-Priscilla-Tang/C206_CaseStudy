public class feedback {
	
	private String feedback_id; // For feedback_id (Verification Purposes)
	private String feedback; // For written feedback
	private String customer_id; // For customer_id 
	private int feedback_rating; // For rating scale
	private String date; // For feedback date given by customer
	
	public feedback(String feedback_id, String customer_id, String date, int feedback_rating, String feedback) {
		this.feedback_id = feedback_id;
		this.customer_id = customer_id;
		this.date = date;
		this.feedback_rating = feedback_rating;
		this.feedback = feedback;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public int getFeedback_rating() {
		return feedback_rating;
	}

	public void setFeedback_rating(int feedback_rating) {
		this.feedback_rating = feedback_rating;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getFeedback_id() {
		return feedback_id;
	}
	
	public void setFeedback_id(String feedback_id) {
		this.feedback_id = feedback_id;
	}

}