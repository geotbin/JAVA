package exercice_3;

import exercice_3.files.FileChecker;
import exercice_3.listeners.MyFileListener;

public class Main {

	public static void main(String[] args) {

		FileChecker fc = new FileChecker();
		MyFileListener client = new MyFileListener();
		fc.addFileListener(client);
		fc.timerFiles(100);
		while(true);
	}
	
	
	
}

