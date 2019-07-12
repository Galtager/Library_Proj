package UserTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Entities.User;
import Entities.Borrower;

public class getPasswordTest {
	
	@Test
	public void testgetPassword() {
	
		
	 User test= new Borrower("307923789", "Sapir","Bialik 12", "sapirskop@gmail.com", "0549327110", "1234");
		String passwordresult = test.getPassword();
		assertEquals(passwordresult,"1234");
	}

}
