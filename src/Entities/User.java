package Entities;

public abstract class User extends Person
{
    protected String m_password;
    
	public User(String id, String name,
				String address, String email,
				String phone_no, String password) 
	{
		super(id, name, address, email, phone_no);
		
		m_password = password;
	}

}
