package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class getGenreTest {

	@Test
	public void testgetGenre() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		String result = test.getGenre();
		assertEquals(result,"comedy");
		Book test2 = new Book("Superhero","Horror","Gal","LidorPublish",null);
		String result2 = test2.getGenre();
		assertEquals(result2,"Horror");
	}

}
