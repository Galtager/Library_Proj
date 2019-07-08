package Library;

import java.util.Date;
import java.util.List;

import Book.Book;
import Collections.BookCollection;
import Entities.Borrower;

public class LibraryActionsImpl //implements ILibraryAction 
{

	// instance to library db
	private static BookCollection m_libDB = new BookCollection();
	
	
	// Loan or return a book
	//@Override
	public static boolean issueBook(Book book, Borrower borrower) 
	{
		// TODO Auto-generated method stub
		return !m_libDB.IssueBook(book.getBookID(), borrower);
		
	}

	//@Override
	public static void insertBook(String title, String genre, String author, String publisher, Date publishing_date) 
	{
		m_libDB.addBook(new Book(title, genre, author, publisher, publishing_date));
	}
	
	//@Override
	public static void deleteBook(int ID) 
	{
		m_libDB.deleteBook(ID);
	}
	
	//@Override
	public static Book getBook(int bookId) 
	{
		return m_libDB.getBook(bookId);
	}

	//@Override
	public static List<Book> getAllBooks() 
	{
		return m_libDB.getAllBooks();
	}

	//@Override
	public static List<Book> getIssuedBooks()
	{
		// TODO Auto-generated method stub
		return m_libDB.GetIssuedBooks();
	}
	
	public static List<Book> filterBookList(String filterBy, String value){
		 return BookCollection.filterBookList(filterBy, value);
	} 

}
