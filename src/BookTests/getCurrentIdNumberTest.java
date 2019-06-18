package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class getCurrentIdNumberTest {

	@Test
	public void testCurrentIdNumber() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		int result = test.getCurrentIdNumber();
		assertEquals(result,1);
		Book test2 = new Book("Superhero2","comedy2","Gal2","LidorPublish2",null);
		int result2 = test2.getCurrentIdNumber();
		assertEquals(result2,2);
		Book test3 = new Book("Superhero3","comedy3","Gal3","LidorPublish3",null);
		int result3 = test3.getCurrentIdNumber();
		assertEquals(result3,3);
		
	}

}
