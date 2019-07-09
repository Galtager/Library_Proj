package Collections;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
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
	private ReportWriter<Book> m_reportWriter;
	
	public BookCollection(){
		try {
			this.m_dbWriter = new DBWriter<Book>(FileNameDeclrations.DB_PATH, "db_books.ser");
			this.m_reader = new Reader<Book>(FileNameDeclrations.DB_PATH, "db_books.ser");
			this.m_reportWriter = new ReportWriter<Book>(FileNameDeclrations.REPORT_PATH,  "BookReport.csv");
			LoadBooks();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void LoadBooks() throws ClassNotFoundException, IOException 
	{
		if(m_reader.getReaderState()) {
			this.s_books = this.m_reader.readToList();
		}
		
		s_books.add(new Book("bla", "bla", "bla bla aaaaaaa", "blaaa", new Date()));
		s_books.add(new Book("bla1", "bla1", "bla bla", "blaaa", new Date()));
		s_books.add(new Book("bla2", "bla2", "bla bla", "blaaa", new Date()));
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
		return s_books.stream()
				.filter(book -> book.getTitle().contains(title))
				.collect(Collectors.toList());
	}
	
	public static List<Book> getBooksByGenre(String genre) 
	{
		return s_books.stream()
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
	
	public static List<Book> getBooksByPublishingDate(Date publishDate) 
	{
		return s_books.stream()
				.filter(book -> book.getPublishingDate().compareTo(publishDate) == 0)
				.collect(Collectors.toList());
	}
	
	public List<Book> getAllBooks()
	{
		return s_books;
	}
	
	public static void addBook(Book b) 
	{
		s_books.add(b);
		int i = 0;
	}
	
	public boolean deleteBook(int bookId) 
	{
		Book bookToRemove = getBook(bookId);
		return s_books.remove(bookToRemove);
	}
	
	public boolean IssueBook(int bookId)
	{
		Book bookToReturn = getBook(bookId);
		if(bookToReturn == null)
			return false;
		bookToReturn.setBorrower(bookToReturn.getNextBorrower());
		
		// check for another indication if the book is available!
		return bookToReturn.isAvailable();
		
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
		
		if(filter.compareTo("Genre") == 0) {
			return getBooksByGenre(value);
		}
		
		if(filter.compareTo("Publisher") == 0) {
			return getBooksByPublisher(value);
		}
		
		if(filter.compareTo("Title") == 0) {
			return getBooksByTitle(value);
		}
		
		if(filter.compareTo("Release Date") == 0) {
			java.util.Calendar cal = java.util.Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
			Date parsedDate;
			try {
				parsedDate = formatter.parse(value);
				return getBooksByPublishingDate(parsedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	public void writeObject(Book b) {
		this.m_dbWriter.writeObject(b);
	}
	
	public void writeList(ArrayList<Book> data) {
		this.m_dbWriter.writeList(data);
	}
	
	public void writeReport(ArrayList<Book> data, String fileName) throws IOException {
		this.m_reportWriter.changeFile(fileName);
		this.m_reportWriter.writeListToFile(data);
	}
	

	
	
}
