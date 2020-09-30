package plugin.files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.naming.directory.InitialDirContext;
import javax.swing.Timer;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import exercice_3.files.FilterEndByClass;
import plugin.listeners.FileListener;
import plugin.PluginFilter;

public class FileChecker {

	private ArrayList<FileListener> fileListeners;
	private String initialDir;
	
	
	public FileChecker(String initialDir) {
		super();
		this.initialDir = initialDir;
		this.fileListeners = new ArrayList<FileListener>();
	}
	/**
	 * add listener
	 * @param fe
	 */
	public synchronized void addFileListener(FileListener fe) {
		if(!fileListeners.contains(fe)) {
			fileListeners.add(fe);
		}
	}
	/**
	 * remove listener
	 * @param fe
	 */
	public synchronized void removeFileListener(FileListener fe) {
		fileListeners.remove(fe);
	}
	
	/**
	 * notify listener file added
	 * @param path
	 */
	public void fireFileAdded(String path) {
		ArrayList<FileListener> fl1 = (ArrayList<FileListener>) fileListeners.clone();
		if(fl1.size() == 0) {
			return;
		}
		FileEvent feEvent = new FileEvent(this, path);
		for(FileListener listener : fl1) {
			listener.fileAdded(feEvent, path);
		}
		
		
	}
	/**
	 * notify listener file removed
	 * @param path
	 */
	public void fireFileRemoved(String path) {
		ArrayList<FileListener> fl1 = (ArrayList<FileListener>) fileListeners.clone();
		if(fl1.size() == 0) {
			return;
		}
		FileEvent feEvent = new FileEvent(this, path);
		for(FileListener listener : fl1) {
			listener.fileRemoved(feEvent, path);
		}
		
		
	}
	
	/**
	 * scan folder every x milliseconds
	 * @param milliseconds
	 */
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
			
			PluginFilter filter = new PluginFilter();
			File file = new File(initialDir);
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

	
