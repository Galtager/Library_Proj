package LoanTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Book.Book;
import Book.Loan;
import Entities.Borrower;
import Entities.Librarian;

class getExpiringDateTest {
	@SuppressWarnings("deprecation")
	@Test
	void testgetExpiringDate() {
		Borrower borrow = new Borrower ("204609861","Gal Tager","ashkelon","galtager@hotmail.com",
				"0507721907","454545");
		Librarian gallib= new Librarian( "204608832" ,"Lidor","Ashkelon","lidor@walla.com","086767073","4545",10000);
		Book book = new Book("Superhero","comedy","Gal","LidorPublish",new Date(93,5,11));
		Loan test = new Loan(borrow,gallib,new Date(93,5,11),book);
		Date result = test.getExpiringDate();
		test.setMaxDays(6);
		assertEquals(new Date(93,5,12), result);
	}
	
}
