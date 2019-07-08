package Library;

import java.util.List;

import Book.Book;
import Entities.Borrower;

public interface ILibraryAction 
{
	
	public boolean issueBook(Book book, Borrower borrower);
	public Book getBook(int bookId);
	public List<Book> getAllBooks();
	public List<Book> getIssuedBooks();
	

}
