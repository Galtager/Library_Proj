package BookTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Book.Book;
import Book.HoldRequest;
import Entities.Borrower;

class addHoldRequrestTest {
	public ArrayList<HoldRequest> hold_test; 
	@SuppressWarnings("deprecation")
	@Test
	
	public void testaddHoldRequrest() 
	{
		Book test = new Book("Superhero","comedy","Gal","LidorPublish",new Date(93,5,18));
		Borrower borrow = new Borrower ("204609861","Gal Tager","ashkelon","galtager@hotmail.com",
		"0507721907","454545");
		test.addHoldRequrest(borrow);
		ArrayList<HoldRequest> result = test.getM_hold_requests();
		HoldRequest test_result = result.get(0);
		HoldRequest test_r = new HoldRequest ( borrow, new Date( 93,5,18));
		assertEquals(test_r,test_result);

}
}
//hold_test = new ArrayList<>();
//hold_test.add(new HoldRequest(borrow, new Date(93,5,11)));
//HoldRequest test_r = hold_test.get(0);

