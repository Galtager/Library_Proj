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
	
	@IPropertyWriter(FieldName = "Hold Request", WriteToReport=false)
	private ArrayList<HoldRequest> m_hold_requests;
	@IPropertyWriter(FieldName = "Current Borrower ID", WriteToReport=false)
	private Borrower m_current_borrower;

	@IPropertyWriter(WriteToReport=false)
	static private int s_current_ID_number = 0;
	
	@IPropertyWriter(WriteToReport = false)
	private static Set<Integer> generated_id = new LinkedHashSet<Integer>();

	public Book(String title, String genre, String author, String publisher, Date publishing_date) {
		s_current_ID_number++;

		m_book_ID = s_current_ID_number;
		m_title = title;
		m_genre = genre;
		m_author = author;
		m_publisher = publisher;
		m_publishing_date = publishing_date;

		m_hold_requests = new ArrayList<>();
		m_current_borrower = null;
		m_final_return_date = null;
	}
	
	public Book (int id,String title, String genre, String author, String publisher, Date m_publishing_date) {
		this.m_book_ID = id;
		m_title = title;
		m_genre = genre;
		m_author = author;
		m_publisher = publisher;
		
		m_hold_requests = new ArrayList<>();
		m_current_borrower = null;
		m_final_return_date = null;
	}
	
	private int getNextId() {
		Random rng = new Random(); 
		while (generated_id.size() < s_current_ID_number)
		{
		    Integer next = rng.nextInt(Integer.MAX_VALUE) + 1;
		    generated_id.add(next);
		    return next;
		}
		
		return 0;
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

	/*************** Functionality ***************/

	public void addHoldRequrest(Borrower borrower) {
		m_hold_requests.add(new HoldRequest(borrower, new Date()));
	}
	
	public Borrower getNextBorrower() {
		if(m_hold_requests.isEmpty()){
			return null;
		}
		else {
			HoldRequest holder = m_hold_requests.get(0);
			m_hold_requests.remove(holder);
			return holder.getBorrower();
		}
	}

	public boolean isAvailable() {
		return (m_current_borrower == null);
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

	


}