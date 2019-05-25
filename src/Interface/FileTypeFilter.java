package Interface;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;;


public class FileTypeFilter extends FileFilter{
	private final String extension;
	private final String descripsion;
	
	public FileTypeFilter (String extension, String description)
	{
		this.extension=extension;
		this.descripsion= description;
	}
	public boolean accept (File file) {
		if(file.isDirectory())
		{
			return true;
		}
		return file.getName().endsWith(extension);
	}
	public String getDescription() {
		return descripsion + String.format(" (*%s)", extension);
	}
}
