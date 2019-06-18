package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;

class getPublisherTest {
	@Test
	public void testgetPublisher() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		String result = test.getPublisher();
		assertEquals(result,"LidorPublish");
	}

}
