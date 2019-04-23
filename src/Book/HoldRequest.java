package Book;
import java.util.Date;
import Entities.Borrower;

public class HoldRequest 
{

	private Borrower m_borrower;
	private Date m_request_date;
	
	public HoldRequest(Borrower borrower,
					   Date request_date) 
	{
		m_borrower = borrower;
		m_request_date = request_date;
	}

}
