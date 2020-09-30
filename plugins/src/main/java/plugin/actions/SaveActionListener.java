package plugin.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import plugin.gui.Window;

public class SaveActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String currentPath = OpenActionListener.getCurrentPath();
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File(currentPath));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write(Window.getEditArea().getText());
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

		
	}

}
