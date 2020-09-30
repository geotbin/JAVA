package fil.coo.Other;

import java.util.*;

public class ListChoser {


	
	/**
	 * ask for an input and return chosen input
	 * @param name name of the generic object
	 * @param genericitem generic list of objects
	 * @return genericitem
	 */
	public <T> T chose(String name, List<T> genericitem) {
		int i = 0;
		for(T v : genericitem) {
			i++;
			System.out.println("["+ i +"] " + v.toString());
		}
		System.out.println("---------------------------------------");
		if(genericitem.size() == 0) {
			System.out.println("None");
		}
		
		System.out.print("Enter the value : ");
		int j = ScannerInt.readInt(genericitem.size()+1);
		
		if(j == 0)
			return genericitem.get(j);
		return genericitem.get(j-1);
	}
	

}
