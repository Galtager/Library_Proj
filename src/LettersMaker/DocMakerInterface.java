package LettersMaker;

import java.awt.Component;
import java.io.File;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Entities.Borrower;
import Misc.Globals;
import word.api.interfaces.IDocument;
import word.utils.Utils;
import word.w2004.elements.Image;
import word.w2004.elements.Paragraph;

public interface DocMakerInterface {
	
	/**
	 * Generates a Word document with the 
	 * properties of the given borrower
	 */
	abstract public void generate(Borrower b, File f);
	
	/**************************************************************/
	
	/**
	 * Adds the user's logo to the document
	 */
	default void addLogo(IDocument doc)
	{
    	/** logo - make sure the path exists**/
    	if(Globals.s_global_logo_path != null)
    	{
    		try
    		{
    			doc.addEle(Paragraph
		                .with(Image.from_FULL_LOCAL_PATHL(
		                                Utils.getAppRoot()
		                                        + Globals.s_global_logo_path).setHeight("40").setWidth("80").create()
		                                .getContent()));
    		}
    		catch (Exception e) {
				// Do nothing - the logo is probably doesn't exists
			}
    	}		
	}
	
	
	/**************************************************************/
	
	/**
	 * Write the generated document to a Word file
	 */
	default void write(IDocument doc, File f)
	{
        try
        {
			File file_obj = f;
			
			PrintWriter writer = new PrintWriter(file_obj);

			String word_doc = doc.getContent();
			
			writer.println(word_doc);
			writer.close();  
        }
        catch (Exception e) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
				    "Can't write Word file - path invalid.");
		}
	}

}
