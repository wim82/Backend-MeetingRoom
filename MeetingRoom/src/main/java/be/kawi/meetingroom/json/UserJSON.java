package be.kawi.meetingroom.json;

import be.kawi.meetingroom.model.User;

public class UserJSON {

	private Integer userId;
	private String userFullName;
	
	public UserJSON(User user) {
		this.userId=user.getUserId();
		this.userFullName=user.getFullName();
	}
	
	public UserJSON() {
		super();
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	
	
}
