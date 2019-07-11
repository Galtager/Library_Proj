package LettersMaker;


import java.io.File;

import Entities.Borrower;
import word.api.interfaces.IDocument;
import word.w2004.Document2004;
import word.w2004.elements.BreakLine;
import word.w2004.elements.Heading1;
import word.w2004.elements.Paragraph;

public class ExpireMaker implements DocMakerInterface
{
	@Override
	public void generate(Borrower b, File f)
	{
    	IDocument doc = new Document2004();
    	
    	addLogo(doc);
    	
    	/** title **/
    	doc.addEle(Heading1.with("Letter of expiration").create());
    	doc.addEle(BreakLine.times(2).create());
    	
    	/** paragraph **/
        doc.addEle(Paragraph
                .with("Hello " + b.getName() + "," + System.lineSeparator())
                .create());
        
        doc.addEle(Paragraph
                .with("Your subscription will end on: " + b.getSubscriptionEndingDate().toString())
                .create());
        
        
        write(doc, f);
	}
}
