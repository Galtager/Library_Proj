package Collections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import Book.Book;
import Entities.Borrower;
import FileHandler.FileNameDeclrations;
import FileHandler.Reader.Reader;
import FileHandler.Writer.DBWriter;
import FileHandler.Writer.ReportWriter;

public class BookCollection 
{
	private static ArrayList<Book> s_books = new ArrayList<Book>();
	private DBWriter<Book> m_dbWriter;
	private Reader<Book> m_reader;
	private static ReportWriter<Book> m_reportWriter;
	
	public BookCollection(){
		try {
			this.m_reader = new Reader<Book>(FileNameDeclrations.DB_PATH, "db_books.ser");
			LoadBooks();
			this.m_dbWriter = new DBWriter<Book>(FileNameDeclrations.DB_PATH, "db_books.ser");
			m_dbWriter.writeList(s_books);
			this.m_reportWriter = new ReportWriter<Book>();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void exportToCSV(File f ) 
	{
		m_reportWriter.writeListToFile(s_books, f);
	}
	
	public void LoadBooks() throws ClassNotFoundException, IOException 
	{
		if(m_reader.getReaderState()) {
			this.s_books = this.m_reader.readToList();
		}
	}
	
	// get book by bookId
	public Book getBook(int bookId) 
	{
		return s_books.stream()
				.filter(book -> bookId == book.getBookID())
				.findAny()
				.orElse(null);
	}
	
	public static List<Book> getBooksByTitle(String title) 
	{
		return  s_books.stream()
				.filter(book -> book.getTitle().contains(title))
				.collect(Collectors.toList());
	}
	
	public static List<Book> getBooksByGenre(String genre) 
	{
		return  s_books.stream()
				.filter(book -> book.getGenre().contains(genre))
				.collect(Collectors.toList());
	}
	
	public static List<Book> getBooksByAuthor(String author) 
	{
		return  s_books.stream()
				.filter(book -> book.getAuthor().contains(author))
				.collect(Collectors.toList());
	}
	
	public static List<Book> getBooksByPublisher(String publisher) 
	{
		return s_books.stream()
				.filter(book -> book.getPublisher().contains(publisher))
				.collect(Collectors.toList());
	}
	
	public static List<Book> getBooksByPublishingDate(String publishDate) 
	{
		return s_books.stream()
				.filter(book -> book.getPublishingDate().toString().contains(publishDate))
				.collect(Collectors.toList());
	}
	
	public List<Book> getAllBooks()
	{
		return s_books;
	}
	
	public boolean addBook(Book b) 
	{
		s_books.add(b);
		this.m_dbWriter.writeList(s_books);
		
		return true;
	}
	
	public boolean deleteBook(int bookId) 
	{
		Book bookToRemove = getBook(bookId);
		s_books.remove(bookToRemove);
		m_dbWriter.writeList(s_books);
		
		return true;
		
	}
	
	public boolean updateBook(Book b) {
		deleteBook(b.getBookID());
		addBook(b);
		m_dbWriter.writeList(s_books);
		
		return true;
	}
	
	
	public List<Book> GetIssuedBooks()
	{
		return s_books.stream()
				.filter(book -> book.getCurrentBorrower() != null)
				.collect(Collectors.toList());

	}
	
	public static List<Book> filterBookList(String filter, String value){
		if(filter.compareTo("Author") == 0) {
			return getBooksByAuthor(value);
		}
		else if(filter.compareTo("Title") == 0) {
			return getBooksByTitle(value);
		}
		else if(filter.compareTo("Genre") == 0) {
			return getBooksByGenre(value);
		}
		else if(filter.compareTo("Release Date") == 0) {
			return getBooksByPublishingDate(value);
		}
		else if(filter.compareTo("Publisher") == 0) {
			return getBooksByPublisher(value);
		}
		
		return null;
	}
	
	
	public void writeList(ArrayList<Book> data) {
		this.m_dbWriter.writeList(data);
	}
	
}
