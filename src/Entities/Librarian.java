package Entities;

import java.io.Serializable;

public class Librarian extends Staff implements Serializable
{

	public Librarian(String id, String name,
					 String address, String email, 
					 String phone_no, String password,
					 double salary) 
	{
		super(id, name, address, email, phone_no, password, salary);
		
		
	}

	@Override
	public String entityReportEntry() {
		// TODO Auto-generated method stub
		return null;
	}

}
