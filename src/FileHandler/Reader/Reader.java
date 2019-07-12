package FileHandler.Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Reader<E>  {
	protected final String m_path;
	protected FileInputStream fileIn = null;
	protected ObjectInputStream in = null;
	protected File dbFile = null;
	protected boolean canRead = true;
	
	
	
	public Reader(String path, String fileName) throws IOException {
		// example "Files/Reports/"
		this.m_path = System.getProperty("user.dir") + path;
		
		this.dbFile = new File(m_path, fileName);
		if(!dbFile.exists() || dbFile.length() == 0) {
			dbFile.createNewFile();
			canRead = false;
		}
		else {
			this.fileIn = new FileInputStream(dbFile);		
			this.in = new ObjectInputStream(fileIn);
		}

	}

	
	public E readObject() throws ClassNotFoundException, IOException {
		return (E) this.in.readObject();
	}
	
	public ArrayList<E> readToList() throws IOException, ClassNotFoundException{
		openStreams();
		ArrayList<E> data = new ArrayList<E>();
		while (this.fileIn.available() > 0) {
			data.add(this.readObject());
		}
		
		closeStreams();
		return data;
	}
	
	public Set<E> readToSet() throws IOException, ClassNotFoundException{
		openStreams();
		Set<E> data = new LinkedHashSet<E>();
		while (this.fileIn.available() > 0) {
			data.add(this.readObject());
		}
		
		closeStreams();
		return data;
	}
	
	public void closeStreams() {
		try {
			this.fileIn.close();
			this.in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public void openStreams() {
		try {
			this.fileIn = new FileInputStream(dbFile);		
			this.in = new ObjectInputStream(fileIn);
			this.canRead = true;
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public boolean getReaderState() {
		return canRead;
	}
	
	
	

}
