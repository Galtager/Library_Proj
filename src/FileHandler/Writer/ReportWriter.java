package FileHandler.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ReportWriter<E extends IEntryToString> 
{

	
	private BufferedWriter m_bw = null;
	private File m_report;
	private String m_path = System.getProperty("user.dir");
	private final String m_default_seperator = ",";
	private final String m_file_extension;
	private final String m_file_name;

	
	
	
	public ReportWriter(String fileExtension, String fileNamePrefix, String path) throws IOException
	{
		this.m_file_extension = ".csv";
		this.m_file_name = fileNamePrefix;
		this.m_path += path;
		initBufferedWriter(generateFileName());
		

		
	}
	
	private void initBufferedWriter(String fileName) throws IOException 
	{
		m_report = new File(m_path, fileName + m_file_extension);
		m_report.createNewFile();
		
		m_bw = new BufferedWriter(new FileWriter(m_report));
	}
	
	
	private void writeHeaders(E entity) throws IOException 
	{
		Field[] fields = entity.getClass().getDeclaredFields();
		
		for(Field field : fields) 
		{
			if(field.getAnnotation(IPropertyWriter.class).WriteToReport())
				m_bw.write(field.getAnnotation(IPropertyWriter.class).FieldName() + m_default_seperator);
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
		
		return this.m_file_name + cal.get(Calendar.DAY_OF_MONTH);
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
