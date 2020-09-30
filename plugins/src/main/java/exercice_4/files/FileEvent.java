package exercice_4.files;

import java.util.EventObject;

public class FileEvent extends EventObject{

	private static final long serialVersionUID = 1L;

	public FileEvent(FileChecker fileChecker) {
		super(fileChecker);
	}
	
	
	
}