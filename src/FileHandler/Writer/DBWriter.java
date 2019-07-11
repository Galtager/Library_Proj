package FileHandler.Writer;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DBWriter <E> {
	private String m_path = System.getProperty("user.dir");
	private FileOutputStream m_fileOut = null;
	private ObjectOutputStream m_outputStream = null;
	private File m_dbFile = null;
	private String m_file_name;
	private String m_full_path;
	
	public DBWriter(String path, String fileName) {
		m_file_name = fileName;
		m_full_path = m_path + path;
		init();
	}
	
	private void writeObject(E entity) throws IOException {
		this.m_outputStream.writeObject(entity);
	}
	
	public void writeList (Set<E> data) {
		try {
			clearFileContent();
			for(E entity : data) {
				this.writeObject(entity);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public void clearFileContent() throws IOException {
		m_dbFile.delete();
		closeStreams();
		init();
	}
	
	private void init()  {
		try {
			this.m_dbFile = new File(m_full_path, m_file_name);
			this.m_fileOut = new FileOutputStream(m_dbFile);
			this.m_outputStream = new ObjectOutputStream(m_fileOut);
		} catch(IOException e) {}

		
	}
	
	public void closeStreams() {
		try {
			this.m_fileOut.close();
			this.m_outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
