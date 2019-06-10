package UserManager;

import Collections.UserCollection;
import Entities.User;

public class UserActions {
	
	private UserCollection m_collection = new UserCollection();
	
	public UserActions() {}
	

	public User checkIfUserExists(String username, String password) {
		return m_collection.checkCredentials(username, password);
	}

}
