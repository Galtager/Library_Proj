package Library;

import java.util.List;
import Book.Book;
import Entities.Librarian;

public class Library extends LibraryActionsImpl 
{
	private Library m_libraryInstance = null;
	private List<Book> m_books;
	private List<Librarian> m_librarians;
	
	
	private Library() 
	{
		// TODO implement library constructor
	}
	
	// singleton 
	public Library getLibraryInstance() 
	{
		if(m_libraryInstance == null) 
		{
			m_libraryInstance = new Library();
		}
		
		return this.m_libraryInstance;
	}
	

}
