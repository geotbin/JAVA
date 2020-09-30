package exercice_2;

import java.io.File;
import java.io.FilenameFilter;

public class FiltersStartWithC implements FilenameFilter{
	
	@Override
	public boolean accept(File dir, String name) {
		if(name.startsWith("C")) {
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		String[] paths;
		FiltersStartWithC filter = new FiltersStartWithC();
		File file = new File("../repository/plugins/");
		paths = file.list(filter);
		
		for(String path: paths) {
			System.out.println(path);
		}
	}

}
