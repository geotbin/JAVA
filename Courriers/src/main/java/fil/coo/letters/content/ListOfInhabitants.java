package fil.coo.letters.content;

import java.util.ArrayList;
import fil.coo.city.Inhabitant;

public class ListOfInhabitants implements Content {
	
	private ArrayList<Inhabitant> inhabitants;
	
	public ListOfInhabitants(ArrayList<Inhabitant> listofIn) {
		inhabitants = new ArrayList<Inhabitant>();
		for(Inhabitant i : listofIn) {
			inhabitants.add(i);
		}
	}
	
	public ArrayList<Inhabitant> getInhabitants(){
		return inhabitants;
	}

	
}
