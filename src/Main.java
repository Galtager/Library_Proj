import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entities.Librarian;
import FileHandler.Writer;

/* This is a simple Java program. 
   FileName : "HelloWorld.java". */
class Main 
{ 
    // Your program begins with a call to main(). 
    // Prints "Hello, World" to the terminal window. 
    public static void main(String args[]) 
    { 
    	Test t = new Test();
    	
    	
    	try {
			Writer<Test> w = new Writer<Test>();
			w.writeToFile(t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Hello, World"); 
    } 
}