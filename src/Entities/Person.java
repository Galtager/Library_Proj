package Entities;

import java.io.Serializable;

public abstract class Person implements Serializable
{   
    protected String m_id;         
    protected String m_name;    
    protected String m_address;  
    protected String m_email;  
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