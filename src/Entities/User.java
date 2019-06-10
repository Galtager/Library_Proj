package Entities;

import java.io.Serializable;

public abstract class User extends Person implements Serializable
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
	
	

}
