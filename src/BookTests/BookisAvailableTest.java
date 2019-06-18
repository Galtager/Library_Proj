package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class BookisAvailableTest {

	@Test
	public void testBookisAvailable() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		boolean result = test.isAvailable();
		assertEquals(result,true);
	}
}
