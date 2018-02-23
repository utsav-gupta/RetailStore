package objects;

import java.util.Date;

public class Bill {
	
	private double amt;
	private User user;
	private BillCategory category;
	
	public enum BillCategory{GROCERIES, OTHERS};
	
	public BillCategory getCategory() {
		return category;
	}
	public void setCategory(BillCategory category) {
		this.category = category;
	}
	
	
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	

}
