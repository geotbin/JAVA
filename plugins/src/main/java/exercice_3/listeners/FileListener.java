package exercice_3.listeners;

import java.util.EventListener;

import exercice_3.files.FileEvent;


public interface FileListener extends EventListener{
	
	public void fileAdded(FileEvent fe, String path);
	public void fileRemoved(FileEvent fe, String path);
	
}
