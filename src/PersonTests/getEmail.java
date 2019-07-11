package PersonTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entities.Person;

class getEmailTest {

	@Test
		public void testgetEmail() {
			Person test= new Person("307923789","Sapir","Bialik 12",
					"sapirskop@gmail.com", "0549327110");
			String emailresult = test.getEmail();
			assertEquals(emailresult,"sapirskop@gmail.com");
	}

}



