package Library;

import java.util.List;

import Book.Book;
import Collections.BookCollection;
import Entities.Borrower;

public class LibraryActionsImpl implements ILibraryAction 
{

	// instance to library db
	private BookCollection m_libDB = new BookCollection();
	
	
	// Loan or return a book
	@Override
	public boolean issueBook(Book book, Borrower borrower) 
	{
		// TODO Auto-generated method stub
		return !m_libDB.IssueBook(book.getBookID(), borrower);
		
	}

	
	@Override
	public Book getBook(int bookId) 
	{
		return m_libDB.getBook(bookId);
	}

	@Override
	public List<Book> getAllBooks() 
	{
		return m_libDB.getAllBooks();
	}

	@Override
	public List<Book> getIssuedBooks()
	{
		// TODO Auto-generated method stub
		return m_libDB.GetIssuedBooks();
	}

}
