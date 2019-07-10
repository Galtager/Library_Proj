package Collections;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Book.Book;
import Entities.*;
import FileHandler.FileNameDeclrations;
import FileHandler.Reader.Reader;
import FileHandler.Writer.DBWriter;
import FileHandler.Writer.ReportWriter;
import FileHandler.UserReportTemplates.*;

public class UserCollection {
	private static ArrayList<User> s_db = new ArrayList<User>();
	private DBWriter<User> m_dbWriter;
	private static ReportWriter<Person> m_reportWriter;
	private Reader<User> m_reader;
	
	public UserCollection() {
		try {
			this.m_dbWriter = new DBWriter<User>(FileNameDeclrations.DB_PATH, "db_users.ser");
			this.m_reader = new Reader<User>(FileNameDeclrations.DB_PATH, "db_users.ser");
			this.m_reportWriter = new ReportWriter<Person>();
			initCollection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void exportToCSV(File f) 
	{
		List<Person> temp = new ArrayList<>();
		for(User u : s_db)
		{
			temp.add(new Person(u.getID(), u.getName(),
					u.getAddress(), u.getEmail(),
					u.getPhoneNumber()));
		}
		m_reportWriter.writeListToFile(temp, f);
	}
	
	private void initCollection() throws ClassNotFoundException, IOException {
		if(m_reader.getReaderState()) {
			this.s_db = this.m_reader.readToList();
		}
		this.s_db.add(new Manager("0", "root", "----", "----", "----", "0", 0));
		this.s_db.add(new Borrower("6454", "lidor hadjaj", "my address", "my email", "my phone", "6752"));
		this.s_db.add(new Borrower("6454", "my asulin", "her address", "her email", "her phone", "12345"));
	}
	
	public boolean addUser(User a) 
	{
		return s_db.add(a);
	}
	
	public User getUser(String userId) 
	{
		return s_db.stream()
				.filter(user -> userId.trim().equals(user.getID()))
				.findAny()
				.orElse(null);
	}
	
	public List<User> getAllUsers()
	{
		return s_db;
	}
	
	public Boolean deleteUser(String ID)
	{
		User userToRemove = getUser(ID);
		return s_db.remove(userToRemove);
	}
	
	/**
	Try login to system
	@param username - the user ID
	@param password - the user password
	@return the user with the given credentials, else NULL
	*/
	public User checkCredentials(String username, String password) {
		return s_db.stream()
			.filter(user -> user.getID().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0)
			.findAny()
			.orElse(null);
	}
	
	public List<UserUtilization> getUsersUtilization(){
		List<UserUtilization> data = new ArrayList<UserUtilization>();
		for(int i = 0; i <= this.s_db.size(); i++) {
			User u = s_db.get(i);
			UserUtilization userUtilization;
			if((userUtilization = this.adjustUserToUtilizationReport(u)) != null) {
				data.add(userUtilization);
			}
		}
		
		return data;
	}
	
	public static List<User> GetUserByAdress(String address)
	{
		return s_db.stream()
				.filter(user ->user.getAddress().contains(address))
				.collect(Collectors.toList());

	}
	
	public static List<User> GetUserByName(String name)
	{
		return s_db.stream()
				.filter(user ->user.getName().contains(name))
				.collect(Collectors.toList());

	}
	
	private static List<User> GetUserByPhone(String value) {
		return s_db.stream()
				.filter(user ->user.getPhoneNumber().contains(value))
				.collect(Collectors.toList());
	}


	private static List<User> GetUserByEmail(String value) {
		return s_db.stream()
				.filter(user ->user.getEmail().contains(value))
				.collect(Collectors.toList());
	}

	private static List<User> GetUserByID(String value) {
		return s_db.stream()
				.filter(user ->user.getID().contains(value))
				.collect(Collectors.toList());
	}

	public static List<User> filterUserList(String filter, String value) {
		if(filter.compareTo("Name") == 0) {
			return GetUserByName(value);
		}
		else if(filter.compareTo("Address") == 0) {
			return GetUserByAdress(value);
		}
		else if(filter.compareTo("ID") == 0) {
			return GetUserByID(value);
		}
		else if(filter.compareTo("Email") == 0) {
			return GetUserByEmail(value);
		}
		else if(filter.compareTo("Phone") == 0) {
			return GetUserByPhone(value);
		}
		
		return null;
	}

	public void writeObject(User u) {
		this.m_dbWriter.writeObject(u);
	}
	
	public void writeList(ArrayList<User> data) {
		this.m_dbWriter.writeList(data);
	}
	
	private UserUtilization adjustUserToUtilizationReport(User u) {
		if(u instanceof Borrower) {
			return new UserUtilization((Borrower)u);
		}
		
		return null;
	}

}
