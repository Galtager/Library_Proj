package Book;

import java.util.Date;

import Entities.Borrower;

public class Loan 
{
	Borrower m_borrower;
	Date m_expiring_date;
	
	public Loan(Borrower borrower, Date issue_date) 
	{
		m_borrower = borrower;
		m_expiring_date = issue_date; //TODO: need to add the time until expiring 
	}

}
