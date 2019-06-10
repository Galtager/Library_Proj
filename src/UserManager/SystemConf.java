package UserManager;

import Entities.Librarian;
import Entities.User;
import Library.LibraryActionsImpl;

public class SystemConf {
	private User m_logged_user;
	private UserActions m_actions;
	
	public SystemConf() {
		this.m_actions = new UserActions();
	}
	
	
	// TODO: create base class of actions? --> usractions, libraryactions etc 
	public Object Login(String username, String password) {
		this.m_logged_user = m_actions.checkIfUserExists(username, password);
		
		if(m_logged_user instanceof Librarian)
			return new LibraryActionsImpl();
		
		return this.m_logged_user;
	}
	
	
	public boolean Logout() {
		this.m_logged_user = null;
		return true;
	}
	
	

}
