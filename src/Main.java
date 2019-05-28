import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Book.Book;
import Entities.Librarian;
import FileHandler.Reader;
import FileHandler.Writer;

/* This is a simple Java program. 
   FileName : "HelloWorld.java". */
/*class Main 
{ 
    // Your program begins with a call to main(). 
    // Prints "Hello, World" to the terminal window. 
    public static void main(String args[]) 
    { 
    	Test t = new Test();
    	Book b = new Book("title", "horror!!", "author", "publisher", new Date());
    	
    	
    	
    	try {
			Writer<Book> w = new Writer<Book>();
			w.writeToFile(b);
			Reader r = new Reader("report_28");
			System.out.println(r.ReadString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("done"); 
    } 
}*/