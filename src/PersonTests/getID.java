package PersonTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entities.Person;

class getIDTest {

	@Test
	public void testgetID() {
		Person test= new Person("307923789","Sapir","Bialik 12",
				"sapirskop@gmail.com", "0549327110");
		String idresult = test.getID();
		assertEquals(idresult,"307923789");
	}

}
