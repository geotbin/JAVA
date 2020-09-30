package exercice_2;

import java.io.File;
import java.io.FilenameFilter;

public class FilterEndByClass implements FilenameFilter{

	
	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[] paths;
		FilterEndByClass filter = new FilterEndByClass();
		File file = new File("../repository/plugins/");
		paths = file.list(filter);
		
		for(String path: paths) {
			System.out.println(path);
		}
	}
	
	
}
