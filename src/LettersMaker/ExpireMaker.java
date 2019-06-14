package LettersMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import Entities.Borrower;
import Misc.Globals;
import word.api.interfaces.IDocument;
import word.utils.Utils;
import word.w2004.Document2004;
import word.w2004.elements.BreakLine;
import word.w2004.elements.Heading1;
import word.w2004.elements.Image;
import word.w2004.elements.Paragraph;

public class ExpireMaker 
{

	public ExpireMaker() 
	{
	}
	

	public void generate(Borrower b)
	{
    	IDocument myDoc = new Document2004();
    	
    	/** logo **/
    	if(Globals.s_global_logo_path != null)
    	{
	        myDoc.addEle(Paragraph
	                .with(Image.from_FULL_LOCAL_PATHL(
	                                Utils.getAppRoot()
	                                        + Globals.s_global_logo_path).setHeight("40").setWidth("80").create()
	                                .getContent()));
    	}
    	
    	/** title **/
    	myDoc.addEle(Heading1.with("Letter of dealy").create());
    	myDoc.addEle(BreakLine.times(2).create());
    	
    	/** paragraph **/
        myDoc.addEle(Paragraph
                .with("Hello " + b.getName() + "," + System.lineSeparator())
                .create());
        
        myDoc.addEle(Paragraph
                .with("Your subscription will end on" + "temp")
                .create());
        
        
        /** write the word file **/
		File fileObj = new File(Globals.s_global_logo_path);
		
		PrintWriter writer = null;
		try {
		    writer = new PrintWriter(fileObj);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		String myWord = myDoc.getContent();
		
		writer.println(myWord);
		writer.close();  
	}

}
