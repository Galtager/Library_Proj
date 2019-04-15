package Entities;

public abstract class Staff extends User 
{
    protected double m_salary;

	public Staff(String id, String name,
				 String address, String email,
				 String phone_no, String password,
				 double salary) 
	{
		super(id, name, address, email, phone_no, password);
		m_salary = salary;
	}
	
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Salary: " + m_salary + "\n");         
    }
    
    public double getSalary()
    {
        return m_salary;
    }

}
