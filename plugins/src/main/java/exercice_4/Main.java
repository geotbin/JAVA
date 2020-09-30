package exercice_4;

import exercice_4.files.FileChecker;
import exercice_4.plugin.SimplePluginObserver;

public class Main {

	public static void main(String[] args) {

		FileChecker fc = new FileChecker();
		SimplePluginObserver client = new SimplePluginObserver();
		fc.addFileListener(client);
		fc.timerFiles(1000);
		while(true);
	}
	
	
	
}

