package Collections;
import java.util.ArrayList;

import Entities.*;

public class UserCollection {
	private static ArrayList<User> s_db = new ArrayList<User>();
	
	public UserCollection() {
		initCollection();
	}
	
	private void initCollection() {
		// TODO: load data from file
	}
	
	/**
	Try login to system
	@param username - the user ID
	@param password - the user password
	@return the user with the given credentials, else NULL
	*/
	public User checkCredentials(String username, String password) {
		return s_db.stream()
			.filter(user -> user.getID() == username && user.getPassword() == password)
			.findAny()
			.orElse(null);
	}
	
	

}
