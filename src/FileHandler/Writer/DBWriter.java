package FileHandler.Writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DBWriter <E> {
	private String m_path = System.getProperty("user.dir");
	private FileOutputStream m_fileOut = null;
	private ObjectOutputStream m_outputStream = null;
	private File m_dbFile = null;
	
	public DBWriter(String path, String fileName) throws IOException {
		this.m_dbFile = new File(m_path + path, fileName);
		this.m_fileOut = new FileOutputStream(m_dbFile);
		this.m_outputStream = new ObjectOutputStream(m_fileOut);
	}
	
	private void writeObject(E entity) {
		try {
			this.m_outputStream.writeObject(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeList (ArrayList<E> data) {
		for(E entity : data) {
			this.writeObject(entity);
		}
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
