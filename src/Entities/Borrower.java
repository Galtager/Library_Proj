package Entities;

import java.io.Serializable;
import java.util.ArrayList;

import Book.Book;
import Book.HoldRequest;

public class Borrower extends User implements Serializable
{
	static private int s_max_books_issued = 1;

	private ArrayList<Book> m_issued_books;
	private ArrayList<HoldRequest> m_hold_requests;

	public Borrower(String id, String name,
					String address, String email,
					String phone_no, String password)
	{
		super(id, name, address, email, phone_no, password);
		
		m_issued_books = new ArrayList<>();
		m_hold_requests = new ArrayList<>();
	}
	
	/***************   Setters   ***************/
	
	public static void maxBooksIssued(int max_books_issued) 
	{
		s_max_books_issued = max_books_issued;
	}
	
	/***************   Functionality   ***************/

	public void assignBook(Book book)
	{
		if(m_issued_books.size() > s_max_books_issued)
		{
			System.out.println("Exceeds amount of books per borrower!");
		}
		else if(!book.isAvailable())
		{
			System.out.println("Book unavailable");
		}
		else
		{
			m_issued_books.add(book);	 
		}
	}
	
	public void unassignBook(Book book)
	{
		if(m_issued_books.contains(book))
		{
			m_issued_books.remove(book);
		}
		else
		{
			System.out.println("Exceeds amount of books per borrower!"); 
		}
	}

}
