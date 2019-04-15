package Book;

import java.util.Date;

public class Book 
{

    private int m_book_ID;         
    private String m_title;       
    private String m_genre;       
    private String m_author;    
    private String m_publisher; 
    private Date m_publishing_date; 
    private boolean m_is_issued;    
    
	static int s_current_ID_number = 0; 
	
	public Book(String title, String genre,
				String author, String publisher,
				Date m_publishing_date, boolean is_issued) 
	{
		s_current_ID_number++;
		
		m_book_ID = s_current_ID_number; 
		m_title = title;	
		m_genre = genre;    
		m_author = author;   	
		m_publisher = publisher;  
		m_is_issued = is_issued;  
	}

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

	public boolean isIissued() 
	{
		return m_is_issued;
	}

	public static int getCurrentIdNumber() 
	{
		return s_current_ID_number;
	}
}