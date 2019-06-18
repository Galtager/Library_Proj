package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class getBookIDTest {

	@Test
	public void testgetBookID() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		int result = test.getBookID();
		assertEquals(result,1);
		Book test2 = new Book("Superhero2","comedy2","Gal2","LidorPublish2",null);
		int result2 = test2.getCurrentIdNumber();
		assertEquals(result2,2);
	}

}
