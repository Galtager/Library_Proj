package Entities;

import java.util.ArrayList;

import Book.Book;

public class Borrower extends User 
{
	ArrayList<Book> m_loaned_books;

	public Borrower(String id, String name,
					String address, String email,
					String phone_no, String password)
	{
		super(id, name, address, email, phone_no, password);
		
		m_loaned_books = new ArrayList<>();
	}
	
	/***************   Functionality   ***************/
	int PLACE_HOLDER = 5;
	public void loanBook(Book book)
	{
		if(m_loaned_books.size() < PLACE_HOLDER)
		{
			m_loaned_books.add(book);
			book.loan(this);
		}
		else
		{
			System.out.println("Exceeds amount of books per borrower!"); 
		}
	}
	
	public void returnBook(Book book)
	{
		if(m_loaned_books.contains(book))
		{
			m_loaned_books.remove(book);
			book.finishLoan();
		}
		else
		{
			System.out.println("Exceeds amount of books per borrower!"); 
		}
	}

}
