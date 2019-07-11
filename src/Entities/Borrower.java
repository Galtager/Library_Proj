package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Book.Book;
import Book.HoldRequest;
import FileHandler.Writer.IEntryToString;

public class Borrower extends User implements Serializable, IEntryToString
{
	public enum book_error_code {
		  book_unavailable,
		  exceeds_amount_of_books_per_borrower,
		  ok
		}
	
	static private int s_max_books_issued = 1;

	private ArrayList<Book> m_issued_books;
	private ArrayList<HoldRequest> m_hold_requests;
	
	private Date m_subscription_ending_date;

	public Borrower(String id, String name,
					String address, String email,
					String phone_no, String password)
	{
		super(id, name, address, email, phone_no, password);
		
		m_issued_books = new ArrayList<>();
		m_hold_requests = new ArrayList<>();
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, 1);
		
		m_subscription_ending_date = c.getTime();;
	}

	/***************   Setters   ***************/
	
	public static void maxBooksIssued(int max_books_issued) 
	{
		s_max_books_issued = max_books_issued;
	}
	
	/***************   Functionality   ***************/

	public book_error_code assignBook(Book book)
	{
		if(m_issued_books.size() > s_max_books_issued)
		{
			System.out.println("Exceeds amount of books per borrower!");
			return book_error_code.exceeds_amount_of_books_per_borrower;
		}
		else if(!book.isAvailable())
		{
			System.out.println("Book unavailable");
			return book_error_code.book_unavailable;
		}
		else
		{
			book.setBorrower(this);
			m_issued_books.add(book);
			return book_error_code.ok;
		}
	}
	
	public book_error_code unassignBook(Book book)
	{
		if(m_issued_books.contains(book))
		{
			book.setBorrower(null);
			m_issued_books.remove(book);
			return book_error_code.ok;
		}
		else
		{
			System.out.println("This book doesnt exist for this borrower"); 
			return book_error_code.book_unavailable;
		}
	}
	
	public int getMaxIssuedBooks() {
		return this.s_max_books_issued;
	}
	
	
	public ArrayList<Book> getIssuedBooks() {
		return this.m_issued_books;
	}
	
	public Date getSubscriptionEndingDate() {
		return m_subscription_ending_date;
	}
	
	public int getIssuedBooksCount() {
		return this.m_issued_books.size();
	}

	@Override
	public String entityReportEntry() {
		String str = "";
		str += this.getID() + ",";
		str += this.getName() + ",";
		str += this.getAddress() + ",";
		str += this.getEmail() + ",";
		str += this.getPhoneNumber() + ",";
		
		return str;
	}

}
