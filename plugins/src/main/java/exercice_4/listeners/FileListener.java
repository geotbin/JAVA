package exercice_4.listeners;

import java.util.EventListener;

import exercice_4.files.FileEvent;


public interface FileListener extends EventListener{
	
	public void fileAdded(FileEvent fe, String path);
	public void fileRemoved(FileEvent fe, String path);
	
}
