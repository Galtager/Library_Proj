package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Book.Book;

class getPublishingDateTest {
	@SuppressWarnings("deprecation")
	@Test
	public void testgetPublishingDate() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",new Date(93,2,11));
		Date result = test.getPublishingDate();
		assertEquals(result,new Date(93,2,11));
	}

}
