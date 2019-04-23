package Book;

import java.util.ArrayList;
import java.util.Date;

import Entities.Borrower;

public class Book 
{

    private int m_book_ID;         
    private String m_title;       
    private String m_genre;       
    private String m_author;    
    private String m_publisher; 
    private Date m_publishing_date;  
    
    private ArrayList<HoldRequest> m_hold_requests; 
    private Loan m_current_loan;

    
	static int s_current_ID_number = 0; 
	
	public Book(String title, String genre,
				String author, String publisher,
				Date m_publishing_date) 
	{
		s_current_ID_number++;
		
		m_book_ID = s_current_ID_number; 
		m_title = title;	
		m_genre = genre;    
		m_author = author;   	
		m_publisher = publisher;   
		
		m_hold_requests = new ArrayList<>();
		m_current_loan = null;
	}

	/***************   Getters   ***************/
	
	public Date getPublishingDate() 
	{
		return m_publishing_date;
	}

	public int getBookID() 
	{
		return m_book_ID;
	}

	public String getTitle() 
	{
		return m_title;
	}

	public String getGenre() 
	{
		return m_genre;
	}

	public String getAuthor() 
	{
		return m_author;
	}

	public String getPublisher() 
	{
		return m_publisher;
	}

	public static int getCurrentIdNumber() 
	{
		return s_current_ID_number;
	}
	
	/***************   Functionality   ***************/
	
	public void addHoldRequrest(Borrower borrower) 
	{
		m_hold_requests.add(new HoldRequest(borrower, new Date()));
	}
	
	public void loan(Borrower borrower) 
	{
		m_current_loan = new Loan(borrower, new Date());
	}
	
	public void finishLoan() 
	{
		m_current_loan = null;
	}
	
	public boolean isAvailable() 
	{
		return (m_current_loan == null);
	}
}