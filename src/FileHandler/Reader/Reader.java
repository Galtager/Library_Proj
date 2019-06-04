package FileHandler.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Reader implements IEntityParser {
	protected BufferedReader m_file_reader = null;
	protected final String m_default_seperator = ",";
	protected final String m_file_extension = ".csv";
	protected final String m_path;
	
	public abstract Object parse(String entity);
	
	public Reader(String path, String fileName) throws IOException {
		// example "Files/Reports/"
		this.m_path = System.getProperty("user.dir") + path;
		initScanner(fileName);
	}

	private void initScanner(String fileName) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(m_path, fileName + m_file_extension);
		file.canRead();
		this.m_file_reader = Files.newBufferedReader(Paths.get(m_path + fileName + m_file_extension));
		
		
	}
	
	protected String ReadString() throws IOException {
		 
		String line;
		 while ((line = m_file_reader.readLine()) != null) {
		        return line;
		    }
		 return null;
		 
	}
	

}
