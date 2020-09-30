package exercice_3.files;

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
	
	
	
}
