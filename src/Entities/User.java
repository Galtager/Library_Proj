package Entities;

import java.io.Serializable;

import FileHandler.Writer.IEntryToString;

public abstract class User extends Person implements IEntryToString, Serializable
{
    protected String m_password;
    
	public User(String id, String name,
				String address, String email,
				String phone_no, String password) 
	{
		super(id, name, address, email, phone_no);
		
		m_password = password;
	}
	
	
	public String getPassword() {
		return m_password;
	}
	
	public String entityReportEntry() {
		String str = "";
		str += this.getID() + "," ;
		str += this.getName() + ",";
		str += this.getAddress() +",";
		str += this.getEmail() + ",";
		str += this.getPhoneNumber();
		
		return str;
	}
	
	
	

}
