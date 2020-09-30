package exercice_3.files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Timer;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.sun.org.apache.xpath.internal.FoundIndex;

import exercice_3.files.FilterEndByClass;
import exercice_3.listeners.FileListener;

public class FileChecker {

	private ArrayList<FileListener> fileListeners = new ArrayList<FileListener>();
	
	public synchronized void addFileListener(FileListener fe) {
		if(!fileListeners.contains(fe)) {
			fileListeners.add(fe);
		}
	}
	
	public synchronized void removeFileListener(FileListener fe) {
		fileListeners.remove(fe);
	}
	
	public void fireFileAdded(String path) {
		ArrayList<FileListener> fl1 = (ArrayList<FileListener>) fileListeners.clone();
		if(fl1.size() == 0) {
			return;
		}
		FileEvent feEvent = new FileEvent(this);
		for(FileListener listener : fl1) {
			listener.fileAdded(feEvent, path);
		}
		
		
	}

	public void fireFileRemoved(String path) {
		ArrayList<FileListener> fl1 = (ArrayList<FileListener>) fileListeners.clone();
		if(fl1.size() == 0) {
			return;
		}
		FileEvent feEvent = new FileEvent(this);
		for(FileListener listener : fl1) {
			listener.fileRemoved(feEvent, path);
		}
		
		
	}
	
	
	public void timerFiles(int milliseconds) {
		if(milliseconds < 0) {
			milliseconds = 1;
		}
		
		checkFilesActionListener listener = new checkFilesActionListener();
		Timer timer = new Timer(milliseconds, listener);
		timer.start();
	}
	

	
	
	public class checkFilesActionListener implements ActionListener{
		
		private ArrayList<String> knownFiles = new ArrayList<String>();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			FilterEndByClass filter = new FilterEndByClass();
			File file = new File("../repository/plugins/");
			String[] paths = file.list(filter);
			
			ArrayList<String> currentPaths = new ArrayList<String>();
			Collections.addAll(currentPaths, paths);
			
			for(String knownFile: knownFiles) {
				if(!currentPaths.contains(knownFile)) {
					fireFileRemoved(knownFile);
					knownFiles.remove(knownFile);
					break;
				}
			}
			
			for(String path: currentPaths) {
				if(!knownFiles.contains(path)) {
					fireFileAdded(path);
					knownFiles.add(path);
				}
			}

		
		}
	}
}

	
