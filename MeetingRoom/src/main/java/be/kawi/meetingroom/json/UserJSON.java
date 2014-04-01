package be.kawi.meetingroom.json;

import be.kawi.meetingroom.model.User;

public class UserJSON {

	private Integer userId;
	private String fullName;
	
	public UserJSON(User user) {
		this.userId=user.getUserId();
		this.fullName=user.getFullName();
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	
	
}
