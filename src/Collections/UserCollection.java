package Collections;
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
	private ReportWriter<User> m_reportWriter;
	private Reader<User> m_reader;
	
	public UserCollection() {
		try {
			this.m_dbWriter = new DBWriter<User>(FileNameDeclrations.DB_PATH, "db_users.ser");
			this.m_reader = new Reader<User>(FileNameDeclrations.DB_PATH, "db_users.ser");
			this.m_reportWriter = new ReportWriter<User>(FileNameDeclrations.REPORT_PATH, "userReport.csv");
			initCollection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	
	private void initCollection() throws ClassNotFoundException, IOException {
		this.s_db = this.m_reader.readToList();
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
	
	public List<User> GetUserByCity(String city)
	{
		return s_db.stream()
				.filter(user ->user.getAddress().contains(city))
				.collect(Collectors.toList());

	}
	
	public List<User> GetUserByName(String name)
	{
		return s_db.stream()
				.filter(user ->user.getName().contains(name))
				.collect(Collectors.toList());

	}
	
	
	
	public void writeObject(User u) {
		this.m_dbWriter.writeObject(u);
	}
	
	public void writeList(ArrayList<User> data) {
		this.m_dbWriter.writeList(data);
	}
	
	public void writeReport(String reportName, List<User> data) throws IOException {
		this.m_reportWriter.changeFile(reportName);
		this.m_reportWriter.writeListToFile(data);
		
	}
	
	private UserUtilization adjustUserToUtilizationReport(User u) {
		if(u instanceof Borrower) {
			return new UserUtilization((Borrower)u);
		}
		
		return null;
	}
	
	

}
