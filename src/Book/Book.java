package Book;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import Entities.Borrower;
import FileHandler.Reader.IEntityParser;
import FileHandler.Writer.IEntryToString;
import FileHandler.Writer.IPropertyWriter;
import Misc.Globals;

public class Book implements IEntryToString, Serializable {
	enum PropertyIndex {
		BOOK_ID, TITLE, GENER, AUTHOR, PUBLISHER, PUBLISHING_DATE, HOLD_REQUESTS, CURRENT_BORROWER
	};

	@IPropertyWriter(WriteToReport=false)
	private static final long serialVersionUID = 3962597590432442915L;
	
	@IPropertyWriter(FieldName="BookID")
	private int m_book_ID;
	@IPropertyWriter(FieldName="Title")
	private String m_title;
	@IPropertyWriter(FieldName="Genre")
	private String m_genre;
	@IPropertyWriter(FieldName="Author")
	private String m_author;
	@IPropertyWriter(FieldName="Publisher")
	private String m_publisher;
	@IPropertyWriter(FieldName="Publishsing Date")
	private Date m_publishing_date;
	@IPropertyWriter(FieldName="Return Date")
	private Date m_final_return_date;
	@IPropertyWriter(FieldName = "Current Borrower ID", WriteToReport=false)
	private Borrower m_current_borrower;

	@IPropertyWriter(WriteToReport=false)
	static private int s_current_ID_number = 0;
	
	@IPropertyWriter(WriteToReport = false)
	private static Set<Integer> generated_id = new LinkedHashSet<Integer>();

	@IPropertyWriter(WriteToReport = false)
	private Date m_final_date_till_hold_expires;
	@IPropertyWriter(WriteToReport = false)
	private Borrower m_hold_requester;
	@IPropertyWriter(WriteToReport = false)
	private static Random s_id_range = new Random();

	public Book(String title, String genre, String author, String publisher, Date publishing_date) {
		s_current_ID_number++;

		m_book_ID = getNextId();
		m_title = title;
		m_genre = genre;
		m_author = author;
		m_publisher = publisher;
		m_publishing_date = publishing_date;

		m_current_borrower = null;
		m_final_return_date = null;
		
		m_hold_requester = null;
	}
	
	
	private int getNextId() {
		 
		if(s_current_ID_number == 0)
			return (int) System.currentTimeMillis();
		while (generated_id.size() < s_current_ID_number)
		{
		    Integer next = s_id_range.nextInt(Integer.MAX_VALUE) + 1;
		    generated_id.add(next);
		    return next;
		}
		
		return (int) System.currentTimeMillis();
	}
	/*************** Getters ***************/

	public Date getPublishingDate() {
		return m_publishing_date;
	}

	public Borrower getCurrentBorrower() {
		return m_current_borrower;
	}

	public int getBookID() {
		return m_book_ID;
	}

	public String getTitle() {
		return m_title;
	}

	public String getGenre() {
		return m_genre;
	}

	public String getAuthor() {
		return m_author;
	}

	public String getPublisher() {
		return m_publisher;
	}
	
	public Date getReturnDate() {
		return this.m_final_return_date;
	}

	public static int getCurrentIdNumber() {
		return s_current_ID_number;
	}

	public void setBorrower(Borrower b) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, Globals.days_per_borrow);
		
		this.m_final_return_date = c.getTime();
		this.m_current_borrower = b;
	}
	
	
	public void setTitle(String val) { this.m_title = val;}
	public void setAuthor (String val) {this.m_author = val;}
	public void setGenre (String val) {this.m_genre = val;}
	public void setPublisher (String val) {this.m_publisher = val;}
	public void setPublishDate (Date val ) { this.m_publishing_date = val;}

	/*************** Functionality ***************/

	public void addHoldRequrest(Borrower borrower)
	{
		m_hold_requester = borrower;
	}

	public boolean isAvailable(Borrower borrower) 
	{
		boolean result = (m_current_borrower == null && (m_hold_requester == null || m_hold_requester == borrower)); 
		return result;
	}

	@Override
	public String entityReportEntry() {
		String entry = "";
		entry += this.getBookID() + ",";
		entry += this.getTitle() + ",";
		entry += this.getGenre() + ",";
		entry += this.getAuthor() + ",";
		entry += this.getPublisher() + ",";
		entry += this.getPublishingDate();

		return entry;
	}

	

	public boolean isHoldRequested() {
		return (m_hold_requester != null);
	}


}