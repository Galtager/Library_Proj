import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Book.Book;
import Entities.Librarian;
import FileHandler.FileNameDeclrations;
import FileHandler.Reader.Reader;
import FileHandler.Writer.DBWriter;
import FileHandler.Writer.ReportWriter;

import Misc.Globals;
import word.api.interfaces.IDocument;
import word.utils.Utils;
import word.w2004.Document2004;
import word.w2004.elements.BreakLine;
import word.w2004.elements.Heading1;
import word.w2004.elements.Image;
import word.w2004.elements.Paragraph;

/* This is a simple Java program. 
   FileName : "HelloWorld.java". */
class Main 
{ 
    // Your program begins with a call to main(). 
    // Prints "Hello, World" to the terminal window. 
    public static void main(String args[]) throws ClassNotFoundException 
    { 
    	Test t = new Test();
    	Book b1 = new Book("title", "horror", "author", "publisher", new Date());
    	Book b2 = new Book("title1", "romance", "author", "publisher", new Date());
    	
    	ArrayList<Book> data = new ArrayList<Book>();
    	data.add(b1);
    	data.add(b2);
    	
    	try {
    		
			DBWriter<Book> w = new DBWriter<Book>(FileNameDeclrations.DB_PATH, "test.ser");
			w.writeList(data);
			ReportWriter<Book> w_report = new ReportWriter<Book>(FileNameDeclrations.REPORT_FILE_EXTENSION, FileNameDeclrations.REPORT_FILE_PREFIX, FileNameDeclrations.REPORT_PATH);
			w_report.writeToFile(b1);
			
			//BookFileReader r = new BookFileReader(FileNameDeclrations.DB_PATH, "\\db_7.bin");
			Reader <Book> r = new Reader<Book>(FileNameDeclrations.DB_PATH,  "test.ser");
			ArrayList<Book> read = r.readToList();
			int i = 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("done"); 
    } 
}