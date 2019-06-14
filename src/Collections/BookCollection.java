package Collections;

import java.io.IOException;
import java.util.ArrayList;
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
		this.s_books = this.m_reader.readToList();
	}
	
	// get book by bookId
	public Book getBook(int bookId) 
	{
		return s_books.stream()
				.filter(book -> bookId == book.getBookID())
				.findAny()
				.orElse(null);
	}
	
	public Book getBooksByTitle(String title) 
	{
		return s_books.stream()
				.filter(book -> book.getTitle().contains(title))
				.findAny()
				.orElse(null);
	}
	
	public Book getBooksByGenre(String genre) 
	{
		return s_books.stream()
				.filter(book -> book.getGenre().contains(genre))
				.findAny()
				.orElse(null);
	}
	
	public Book getBooksByAuthor(String author) 
	{
		return s_books.stream()
				.filter(book -> book.getAuthor().contains(author))
				.findAny()
				.orElse(null);
	}
	
	public Book getBooksByPublisher(String publisher) 
	{
		return s_books.stream()
				.filter(book -> book.getPublisher().contains(publisher))
				.findAny()
				.orElse(null);
	}
	
	public Book getBooksByPublishingDate(Date publishDate) 
	{
		return s_books.stream()
				.filter(book -> book.getPublishingDate().compareTo(publishDate) == 0)
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
