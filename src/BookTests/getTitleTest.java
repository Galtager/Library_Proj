package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class getTitleTest {

	@Test
	public void testTitleTest() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		String result = test.getTitle();
		assertEquals(result,"Superhero");
	}

}
