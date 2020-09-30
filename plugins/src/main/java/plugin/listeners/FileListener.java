package plugin.listeners;

import java.util.EventListener;

import plugin.files.FileEvent;


public interface FileListener extends EventListener{
	
	public void fileAdded(FileEvent fe, String path);
	public void fileRemoved(FileEvent fe, String path);
	
}
