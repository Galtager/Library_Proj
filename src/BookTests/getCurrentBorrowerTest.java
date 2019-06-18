package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Book.Book;
import Entities.Borrower;

class getCurrentBorrowerTest {

	@Test
	public void testgetCurrentBorrower() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",null);
		Borrower result = test.getCurrentBorrower();
		assertEquals(result,null);
	}

}
