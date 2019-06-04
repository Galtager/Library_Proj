package Book;

import java.io.IOException;
import java.util.List;

import FileHandler.Reader.IEntityParser;
import FileHandler.Reader.Reader;

public class BookFileReader extends Reader implements IEntityParser {

	public BookFileReader(String path, String fileName) throws IOException {
		super(path, fileName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book parse(String entity) {
		// TODO Auto-generated method stub
		String args[] = entity.split(m_default_seperator);
		
		return null;
	}
	
	protected List<Book> readFile (){
		return null;
	}
	

}
