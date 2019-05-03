package FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Writer<E extends IEntryToString> 
{
	private BufferedWriter m_bw = null;
	private File m_report;
	private final String m_path = System.getProperty("user.dir") + "/Reports";
	
	public Writer() throws IOException
	{
		initBufferedWriter(generateFileName());
	}
	
	private void initBufferedWriter(String fileName) throws IOException 
	{
		m_report = new File(m_path, fileName + ".txt");
		m_report.createNewFile();
		
		m_bw = new BufferedWriter(new FileWriter(m_report));
	}
	
	
	private void writeHeaders(E entity) throws IOException 
	{
		Field[] fields = entity.getClass().getDeclaredFields();
		
		for(Field field : fields) 
		{
			m_bw.write(field.getName() + "\t");
		}
		
		m_bw.write("\n");
	}
	
	
	private void writeEntry(E entity) throws IOException 
	{
		m_bw.write(entity.entityReportEntry() + "\n");
	}
	
	private String generateFileName() 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		return "report";
	}
	
	public void writeToFile(E entity) 
	{
		try 
		{
			writeHeaders(entity);
			writeEntry(entity);
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			closeWriter();
		}
	}
	
	public void writeListToFile(List<E> entities) 
	{
		try 
		{
			writeHeaders(entities.get(0));
			entities.stream().forEach(entity -> {
				try 
				{
					writeEntry(entity);
				} 
				
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally 
		{
			closeWriter();
		}
	}
	
	private void closeWriter() 
	{
		try 
		{
			m_bw.close();
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
