package StaffTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entities.Manager;
import Entities.Staff;

class getSalaryTest {

	@Test
	public void testgetSalary() {
		Staff test= new Manager("307923789", "Sapir",
				 "Bialik 12", "sapirskop@gmail.com",
				 "0549327110", "1234", 8000);
		 double salaryresult = test.getSalary();
			assertEquals(salaryresult,8000);	}
}
