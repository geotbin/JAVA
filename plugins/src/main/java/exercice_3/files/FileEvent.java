package exercice_3.files;

import java.io.File;
import java.util.EventObject;

public class FileEvent extends EventObject{

	private static final long serialVersionUID = 1L;

	public FileEvent(FileChecker fileChecker) {
		super(fileChecker);
	}
	
	
	
}