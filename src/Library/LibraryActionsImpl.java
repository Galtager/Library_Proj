package Library;

import java.io.File;
import java.util.Date;
import java.util.List;

import Book.Book;
import Collections.BookCollection;
import Collections.UserCollection;
import Entities.Borrower;
import Entities.User;

public class LibraryActionsImpl
{

	// instance to books db
	private static BookCollection m_books_DB = new BookCollection();
	
	// instance to users db
	private static UserCollection m_users_DB = new UserCollection();
	
	/***********************************************************************/
    				/*            USERS OPERATIONS            */
	/***********************************************************************/

	//@Override
	public static void insertUser(String id, String name,
								 String address, String email,
								 String phone_no, String password) 
	{
		m_users_DB.addUser(new Borrower(id, name, address, email, phone_no, password));
	}
	
	//@Override
	public static List<User> getAllUsers() 
	{
		return m_users_DB.getAllUsers();
	}
	
	//@Override
	public static void deleteUser(String ID) 
	{
		m_users_DB.deleteUser(ID);
	}
	
	//@Override
	public static List<User> filterUsersList(String filterBy, String value){
		 return UserCollection.filterUserList(filterBy, value);
	} 
	
	//@Override
	public static void exportUsersToCSV(File f){
		 UserCollection.exportToCSV(f) ;
	} 
	
	public void updateUser(String id, String name, String addr, String email, String phone, Date endDate) {
		m_users_DB.updateUser(id, name, addr, email, phone, endDate);
	}
	
	/***********************************************************************/
	               /*            BOOKS OPERATIONS            */
	/***********************************************************************/

	//@Override
	public static void insertBook(String title, String genre, String author, String publisher, Date publishing_date) 
	{
		m_books_DB.addBook(new Book(title, genre, author, publisher, publishing_date));
	}
	
	//@Override
	public static void deleteBook(int ID) 
	{
		m_books_DB.deleteBook(ID);
	}
	
	//@Override
	public static Book getBook(int bookId) 
	{
		return m_books_DB.getBook(bookId);
	}

	//@Override
	public static List<Book> getAllBooks() 
	{
		return m_books_DB.getAllBooks();
	}

	//@Override
	public static List<Book> getIssuedBooks()
	{
		// TODO Auto-generated method stub
		return m_books_DB.GetIssuedBooks();
	}
	
	//@Override
	public static List<Book> filterBookList(String filterBy, String value){
		 return BookCollection.filterBookList(filterBy, value);
	} 
	
	//@Override
	public static void exportBooksToCSV(File f){
		BookCollection.exportToCSV(f) ;
	} 
	
	public static void updateBook(int id, String title, String genre, String author, String publisher, Date publishDate) {
		m_books_DB.updateBook(id, title, genre, author, publisher, publishDate);
	}

}
