package plugin.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import plugin.gui.Window;

public class OpenActionListener implements ActionListener{

	
	
	public OpenActionListener() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String currentPath = getCurrentPath();
		JFileChooser fs = new JFileChooser(new File(currentPath));
		fs.setDialogTitle("Open a file");
		int result = fs.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			try {
				File fi = fs.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
				String line = "";
				String s = "";
				while((line = br.readLine()) != null) {
					s += line + "\n";
				}
				Window.getEditArea().setText(s);
				if(br != null) {
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static String getCurrentPath() {
		String current = "";
		try {
			current = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	     System.out.println("Current dir: "+ current);
		return current;
	}
	
	
	

}
