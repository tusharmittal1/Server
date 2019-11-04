package users;

import java.io.Serializable;

public abstract class User implements Serializable {
	
	private int userID;
	private String username;
	private String password;
	
	User(){}
	User( int in_UserID , String in_username , String in_password ){	
		userID = in_UserID;
		username = in_username;
		password = in_password;
	}
	
	public int getUserID(){ return userID;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
}
