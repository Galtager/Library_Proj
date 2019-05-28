package FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader<E extends IEntityParser> {
	private BufferedReader m_file_reader = null;
	private final String m_default_seperator = ",";
	private final String m_file_extension = ".csv";
	private final String m_path = System.getProperty("user.dir") + "/Reports/";
	
	public Reader(String fileName) throws IOException {
		initScanner(fileName);
	}

	private void initScanner(String fileName) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(m_path, fileName + m_file_extension);
		file.canRead();
		this.m_file_reader = Files.newBufferedReader(Paths.get(m_path + fileName + m_file_extension));
		
		
	}
	
	public String ReadString() throws IOException {
		 
		String line;
		 while ((line = m_file_reader.readLine()) != null) {
		        return line;
		    }
		 return null;
		 
	}
	
	private E ProcessLine(String entity) {
		
		
		return null;
	}

}
