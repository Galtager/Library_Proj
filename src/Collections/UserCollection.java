package Collections;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Book.Book;
import Entities.*;
import FileHandler.FileNameDeclrations;
import FileHandler.Reader.Reader;
import FileHandler.Writer.DBWriter;
import FileHandler.Writer.ReportWriter;
import FileHandler.UserReportTemplates.*;

public class UserCollection {
	private static Set<User> s_db = new LinkedHashSet<User>();
	private DBWriter<User> m_dbWriter;
	private static ReportWriter<Person> m_reportWriter;
	private Reader<User> m_reader;
	
	public UserCollection() {
		try {
			this.m_reader = new Reader<User>(FileNameDeclrations.DB_PATH, "db_users.ser");
			initCollection();
			this.m_dbWriter = new DBWriter<User>(FileNameDeclrations.DB_PATH, "db_users.ser");
			m_dbWriter.writeList(s_db);
			this.m_reportWriter = new ReportWriter<Person>();

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
			this.s_db = this.m_reader.readToSet();
		}
		this.s_db.add(new Manager("0", "root", "----", "----", "----", "0", 0));
		/*
		this.s_db.add(new Borrower("6452", "semek", "her address", "her email", "her phone", "12345"));
		this.s_db.add(new Borrower("6453", "lidor hadjaj", "my address", "my email", "my phone", "6752"));
		this.s_db.add(new Borrower("6454", "may asulin", "her address", "her email", "her phone", "12345"));*/
	}
	
	public boolean addUser(User a) 
	{
		s_db.add(a);
		m_dbWriter.writeList(s_db);
		
		return true;
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
		return getAsList();
	}
	
	public Boolean deleteUser(String ID)
	{
		User userToRemove = getUser(ID);
		s_db.remove(userToRemove);
		
		m_dbWriter.writeList(s_db);
		
		return true;
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
		User[] temp = (User[]) s_db.toArray();
		for(int i = 0; i <= temp.length; i++) {
			User u = temp[i];
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
	
	public void writeList(ArrayList<User> data) {
		this.m_dbWriter.writeList(s_db);
	}
	
	private UserUtilization adjustUserToUtilizationReport(User u) {
		if(u instanceof Borrower) {
			return new UserUtilization((Borrower)u);
		}
		
		return null;
	}

	private static ArrayList<User> getAsList() {
		// TODO Auto-generated method stub
		ArrayList<User> temp = new ArrayList<>();
		temp.addAll(s_db);
		
		return temp;
	}
	
	public Boolean updateUser(String id, String name, String addr, String email, String phone, Date endDate) {
		User u = getUser(id);
		deleteUser(id);
		
		if(u instanceof Borrower) {
			u.setName(name);
			u.setAddress(addr);
			u.setEmail(email);
			u.setPhone(phone);
			((Borrower)u).setEndDate(endDate);
		}
		
		addUser(u);
		
		return true;
	}
	
}
