package FileHandler.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader<E>  {
	protected final String m_path;
	protected FileInputStream fileIn = null;
	protected ObjectInputStream in = null;
	
	
	
	public Reader(String path, String fileName) throws IOException {
		// example "Files/Reports/"
		this.m_path = System.getProperty("user.dir") + path;
		//initScanner(fileName);
		
		this.fileIn = new FileInputStream(this.m_path + "\\test.ser");
		this.in = new ObjectInputStream(fileIn);
	}

	
	public E readObject() throws ClassNotFoundException, IOException {
		return (E) this.in.readObject();
	}
	
	public ArrayList<E> readToList() throws IOException, ClassNotFoundException{
		ArrayList<E> data = new ArrayList<E>();
		while (this.fileIn.available() > 0) {
			data.add(this.readObject());
		}
		
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
	

}
