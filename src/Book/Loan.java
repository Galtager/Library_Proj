package Book;

import java.util.Calendar;
import java.util.Date;

import Entities.Borrower;

public class Loan 
{
	static private int s_max_days = 1;
	
	private Borrower m_borrower;
	private Date m_expiring_date;
	private Book m_book;
	
	public Loan(Borrower borrower,
				Date issue_date,
				Book book) 
	{
		m_borrower = borrower;
		m_book = book;
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(issue_date);
        cal.add(Calendar.DATE, s_max_days);
        m_expiring_date = cal.getTime();
	}
	
	/***************   Getters   ***************/
	
	public Borrower getBorrower() 
	{
		return m_borrower;
	}

	public Date getExpiringDate() 
	{
		return m_expiring_date;
	}

	public Book getBook() 
	{
		return m_book;
	}

	public static void setMaxDays(int max_days) 
	{
		s_max_days = max_days;
	}

}
