package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class getAuthorTest {

	@Test
	public void testgetAuthor() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		String result = test.getAuthor();
		assertEquals(result,"Gal");
		
		Book test2 = new Book("Superhero","comedy","1223","LidorPublish",null);
		String result2 = test2.getAuthor();
		assertEquals(result2,"1223");
	}

}
