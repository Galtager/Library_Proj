package FileHandler.UserReportTemplates;

import Entities.Borrower;
import FileHandler.Writer.IEntryToString;

public class UserUtilization extends Borrower implements IEntryToString {
	
	
	private double m_utilization;

	public UserUtilization(Borrower b) {
		super(b.getID(), b.getName(), b.getAddress(), b.getEmail(), b.getPhoneNumber(), b.getPassword());
		// TODO Auto-generated constructor stub
		calcUtilization();
	}
	
	private void calcUtilization() {
		this.m_utilization =  (100 * this.getIssuedBooksCount()) / this.getMaxIssuedBooks();
	}

	@Override
	public String entityReportEntry() {
		// TODO Auto-generated method stub
		String str = this.entityReportEntry() + ",";
		str += this.m_utilization +",";
		
		return str;
	}
	
	

}
