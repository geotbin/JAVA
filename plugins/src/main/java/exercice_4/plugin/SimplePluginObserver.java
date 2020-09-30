package exercice_4.plugin;

import exercice_4.files.FileEvent;
import exercice_4.listeners.FileListener;

public class SimplePluginObserver implements FileListener{

	
	@Override
	public void fileAdded(FileEvent fe, String path) {
		System.out.println("Plugin  `" + path + "` added");
	}

	@Override
	public void fileRemoved(FileEvent fe, String path) {
		System.out.println("Plugin  `" + path + "` removed");
		
	}

	
}
