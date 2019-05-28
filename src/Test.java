import FileHandler.IEntryToString;

public class Test implements IEntryToString 
{
	private String hi;
	private String wow;
	
	public Test() 
	{
		this.hi = "hi";
		this.wow = "wow";
	}
	
	
	@Override
	public String entityReportEntry() 
	{
		// TODO Auto-generated method stub
		return this.hi + "," + this.wow;
	}

}
