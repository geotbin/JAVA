package plugin;

import java.io.IOException;

import plugin.files.FileChecker;
import plugin.gui.Window;


public class Main{
	public static void main(String[] args) throws IOException {
		
		Window w = new Window();
		FileChecker fc = new FileChecker("../repository/plugins/");
		fc.addFileListener(w);
		fc.timerFiles(100);
		while(true);
	}
}
