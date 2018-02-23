package objects;

import java.util.List;

public class User {
	
	 public enum UserType{
		AFFILIATE,EMPLOYEE,CUSTOMER
	}
	
	private int timeInYrs;
	private UserType userType;
	
	public int getTimeInYrs() {
		return timeInYrs;
	}
	public void setTimeInYrs(int timeInYrs) {
		this.timeInYrs = timeInYrs;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	

}
