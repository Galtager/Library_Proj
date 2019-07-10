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
	private final String m_default_seperator = ",";
	
	private void initBufferedWriter(File f) throws IOException 
	{
		m_report = f;
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
	
	
	public void writeListToFile(List<E> entities, File f) 
	{
		try 
		{
			initBufferedWriter(f);
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
