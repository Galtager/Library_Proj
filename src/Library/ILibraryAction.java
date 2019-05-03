package Library;

import java.util.List;

import Book.Book;
import Entities.Borrower;

public interface ILibraryAction {
	
	public boolean IssueBook(Book book, Borrower borrower);
	public Book GetBook(int bookId);
	public List<Book> GetAllBooks();
	public List<Book> GetIssuedBooks();
	

}
