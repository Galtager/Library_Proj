package Entities;

import java.io.Serializable;

import FileHandler.Writer.IEntryToString;
import FileHandler.Writer.IPropertyWriter;

public class Person implements Serializable, IEntryToString
{   
	@IPropertyWriter(FieldName="ID")
    protected String m_id;  
	@IPropertyWriter(FieldName="Name")
    protected String m_name;    
	@IPropertyWriter(FieldName="Address")
    protected String m_address;  
	@IPropertyWriter(FieldName="Email")
    protected String m_email;  
	@IPropertyWriter(FieldName="Phone")
    protected String m_phone_no;  

    public Person(String id, String name,
    			  String address, String email, 
    			  String phone_no) 
    {
    	m_id = id;
        m_name = name;
        m_address = address;
        m_email = email;
        m_phone_no = phone_no;
    }        
    
	@Override
	public String entityReportEntry() {
		String entry = "";
		entry += this.m_id + ",";
		entry += this.m_name + ",";
		entry += this.m_address + ",";
		entry += this.m_email + ",";
		entry += this.m_phone_no + ",";

		return entry;
	}
    
    // Printing Info of a Person
    public void printInfo()
    {
        System.out.println("-----------------------------------------");
        System.out.println("\nThe details are: \n");
        System.out.println("ID: " + m_id);
        System.out.println("Name: " + m_name);
        System.out.println("Address: " + m_address);
        System.out.println("email: " + m_email);
        System.out.println("Phone No: " + m_phone_no + "\n");
    }
    
    /*---------Setter FUNCs.---------*/
    public void updateAddress(String address)
    {
        m_address = address;
    }
    
    public void updatePhone(String phone_no)
    {
        m_phone_no = phone_no;
    }
    
    public void updateEmail(String email)
    {
        m_email = email;
    }
    /*----------------------------*/
    
    /*-------Getter FUNCs.--------*/
    public String getName()
    {
        return m_name;
    }
    
    public String getEmail()
    {
        return m_email;
    }
    
     public String getAddress()
    {
        return m_address;
    }
     
     public String getPhoneNumber()
    {
        return m_phone_no;
    }
    public String getID()
    {
        return m_id;
    }
    
    /*---------------------------*/

} // Person Class Closed