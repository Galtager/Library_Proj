package Book;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Entities.Borrower;
import FileHandler.IEntityParser;
import FileHandler.IEntryToString;
import FileHandler.IPropertyWriter;

public class Book implements IEntryToString, IEntityParser<Book> {
	enum PropertyIndex {
		BOOK_ID, TITLE, GENER, AUTHOR, PUBLISHER, PUBLISHING_DATE
	};

	@IPropertyWriter(FieldName="BookID")
	private int m_book_ID;
	@IPropertyWriter(FieldName="Title")
	private String m_title;
	@IPropertyWriter(FieldName="Gener")
	private String m_genre;
	@IPropertyWriter(FieldName="Author")
	private String m_author;
	@IPropertyWriter(FieldName="Publisher")
	private String m_publisher;
	@IPropertyWriter(FieldName="Publishsing Date")
	private Date m_publishing_date;
	
	@IPropertyWriter(WriteToFile=false)
	private ArrayList<HoldRequest> m_hold_requests;
	@IPropertyWriter(WriteToFile=false)
	private Borrower m_current_borrower;

	@IPropertyWriter(WriteToFile=false)
	static private int s_current_ID_number = 0;

	public Book(String title, String genre, String author, String publisher, Date m_publishing_date) {
		s_current_ID_number++;

		m_book_ID = s_current_ID_number;
		m_title = title;
		m_genre = genre;
		m_author = author;
		m_publisher = publisher;

		m_hold_requests = new ArrayList<>();
		m_current_borrower = null;
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

	public static int getCurrentIdNumber() {
		return s_current_ID_number;
	}

	public void setBorrower(Borrower b) {
		this.m_current_borrower = b;
	}

	/*************** Functionality ***************/

	public void addHoldRequrest(Borrower borrower) {
		m_hold_requests.add(new HoldRequest(borrower, new Date()));
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
		entry += this.getPublishingDate() + ",";

		return entry;
	}

	@Override
	public Book parse(String entity, String seperator) {
		return parseString(entity, seperator);

	}
	
	private static Book parseString(String entity, String seperator) {
		String args[] = entity.split(seperator);
		
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date publishingDate = null;
		try {
			publishingDate = format.parse(args[PropertyIndex.PUBLISHING_DATE.ordinal()]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error parsing publishing date");
		}
		
		return new Book(args[PropertyIndex.TITLE.ordinal()], args[PropertyIndex.GENER.ordinal()], args[PropertyIndex.AUTHOR.ordinal()], args[PropertyIndex.PUBLISHER.ordinal()], publishingDate);
	}

}