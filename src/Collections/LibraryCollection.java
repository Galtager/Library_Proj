package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Book.Book;
import Entities.Borrower;

public class LibraryCollection 
{
	private static ArrayList<Book> s_books = new ArrayList<Book>();
	
	public static void LoadBooks() 
	{
		// TODO
		// load books from file
	}
	
	// get book by bookId
	public Book getBook(int bookId) 
	{
		return s_books.stream()
				.filter(book -> bookId == book.getBookID())
				.findAny()
				.orElse(null);
	}
	
	public List<Book> getAllBooks()
	{
		return s_books;
	}
	
	public boolean addBook(Book b) 
	{
		return s_books.add(b);
	}
	
	public boolean deleteBook(int bookId) 
	{
		Book bookToRemove = getBook(bookId);
		return s_books.remove(bookToRemove);
	}
	
	public boolean IssueBook(int bookId, Borrower b)
	{
		Book bookToReturn = getBook(bookId);
		bookToReturn.setBorrower(b);
		
		// check for another indication if the book is available!
		return bookToReturn.isAvailable();
		
	}
	
	public List<Book> GetIssuedBooks()
	{
		return s_books.stream()
				.filter(book -> book.getCurrentBorrower() != null)
				.collect(Collectors.toList());

	}
	

	
	
}
