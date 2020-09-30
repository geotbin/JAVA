package plugin.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileFilter;

import javax.swing.*;

import plugin.Plugin;
import plugin.actions.*;
import plugin.files.*;
import plugin.listeners.*;

public class Window implements FileListener{

	private static JFrame frame;
	private static JTextArea editArea;
	private static JMenu file;
	public static JMenu tools;
	

	
	public Window() {
		initFileMenu();
		initToolsMenu();
		initJFrame();
		start();
		
	}



	public static JTextArea getEditArea() {
		return editArea;
	}



	public static void initJFrame() {
		
		  // create main jframe
		  frame = new JFrame("Autoload plugins");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  editArea = new JTextArea(5,40);
		  
		  // create menubar
		  JMenuBar menubar = new JMenuBar();
		  
		  
		  menubar.add(file);
		  menubar.add(tools);
		  frame.setJMenuBar(menubar);
		  frame.getContentPane().setBackground(Color.CYAN);
		  frame.getContentPane().add(new JScrollPane(editArea));
	
	}
	
	
	public static void initFileMenu() {
		  // create file menu
		  file = new JMenu("File");
		  JMenuItem newItem = new JMenuItem("New");
		  newItem.addActionListener(new NewActionListener());
		  JMenuItem openItem = new JMenuItem("Open");
		  openItem.addActionListener(new OpenActionListener());
		  JMenuItem saveItem = new JMenuItem("Save");
		  saveItem.addActionListener(new SaveActionListener());
		  JMenuItem closeItem = new JMenuItem("Close");
		  closeItem.addActionListener(new ExitActionListener());
		  closeItem.add(new JSeparator());
		  
		  file.add(newItem);
		  file.add(openItem);
		  file.add(saveItem);
		  file.add(closeItem);
	}
	
	
	public static void initToolsMenu() {
		  // create tool menu
		  tools = new JMenu("Tools");
	}
	
	
	
	public static void start() {
		  frame.setSize(600,400);
		  frame.setVisible(true);
	}



	@Override
	public void fileAdded(FileEvent fe, String path) {
		// get plugin from file event
		Plugin plugin = getPluginFromFileEvent(fe);
		// create new tool for plugin
		JMenuItem tool = new JMenuItem(plugin.getLabel());
		tool.addActionListener(new PluginItemAction(plugin));
		// add button to the menubar
		tools.add(tool);
		  
	}


	@Override
	public void fileRemoved(FileEvent fe, String path) {
		Plugin plugin = getPluginFromFileEvent(fe);
		
		for(int i=0; i < tools.getItemCount(); i++) {
			if(tools.getItem(i).getText().equals(plugin.getLabel())) {
				// remove button from toolbar
				tools.remove(i);
			}
		}
		
	}

	
	public Plugin getPluginFromFileEvent(FileEvent fe){
		String str = fe.getFileName();
		str = str.substring(0, str.length() - ".class".length());
		Class<?> localClass = null;
		Plugin plugin = null;
		
		try {
			localClass = Class.forName("plugins." + str);
			plugin = (Plugin)localClass.newInstance();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	
		return plugin;
	}
	
	

    public class PluginItemAction implements ActionListener {
    	private Plugin plugin;
      private PluginItemAction(Plugin plugin) {
    		this.plugin = plugin;
    	}
      
      public void actionPerformed(ActionEvent paramActionEvent)
      {
        Window.this.editArea.setText(this.plugin.transform(Window.this.editArea.getText()));
      }
    }
  }
	







