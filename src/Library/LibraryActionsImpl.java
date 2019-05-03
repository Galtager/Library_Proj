package Library;

import java.util.List;

import Book.Book;
import Collections.LibraryCollection;
import Entities.Borrower;

public class LibraryActionsImpl implements ILibraryAction {

	// instance to library db
	private LibraryCollection m_libDB = new LibraryCollection();
	
	
	// Loan or return a book
	@Override
	public boolean IssueBook(Book book, Borrower borrower) {
		// TODO Auto-generated method stub
		return !m_libDB.IssueBook(book.getBookID(), borrower);
		
	}

	
	@Override
	public Book GetBook(int bookId) {
		return m_libDB.getBook(bookId);
	}

	@Override
	public List<Book> GetAllBooks() {
		return m_libDB.getAllBooks();
	}

	@Override
	public List<Book> GetIssuedBooks() {
		// TODO Auto-generated method stub
		return m_libDB.GetIssuedBooks();
	}

}
