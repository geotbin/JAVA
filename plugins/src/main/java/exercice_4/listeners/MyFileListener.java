package exercice_4.listeners;

import exercice_4.files.FileEvent;

public class MyFileListener implements FileListener{

	@Override
	public void fileAdded(FileEvent fe, String path) {
		System.out.println("nouveau .class: " + path);
		
	}

	@Override
	public void fileRemoved(FileEvent fe, String path) {
		System.out.println(".class supprimé: " + path);
		
	}



}
