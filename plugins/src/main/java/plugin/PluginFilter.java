package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter{
	
	private Class<?> classe;
	
	
	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class")) {
			
			try {
				int len = name.length();
				name = name.substring(0, len-6);
				classe = Class.forName("plugins."+name);
				classe.getConstructor();
				return true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			catch (Error e) {
				// e.printStackTrace();
				return false;
			} catch (NoSuchMethodException e) {
				// e.printStackTrace();
			} catch (SecurityException e) {
				// e.printStackTrace();
			}
		
		}
		return false;
	}
	
}
