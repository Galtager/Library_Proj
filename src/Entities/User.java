package Entities;

import java.io.Serializable;

import FileHandler.Writer.IEntryToString;

public abstract class User extends Person implements Serializable, IEntryToString
{
	private static final long serialVersionUID = 7991694760313521478L;
    protected String m_password;
    
	public User(String id, String name,
				String address, String email,
				String phone_no, String password) 
	{
		super(id, name, address, email, phone_no);
		
		m_password = password;
	}
	
	public void setName(String val) {this.m_name = val;}
	public void setAddress(String val) {this.m_address = val;}
	public void setEmail(String val) {this.m_email = val;}
	public void setPhone (String val) {this.m_phone_no = val;}
	
	
	
	public String getPassword() {
		return m_password;
	}
	
	

}
