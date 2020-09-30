package fil.coo.letters;

import fil.coo.city.Inhabitant;
import fil.coo.letters.content.*;

public class SimpleLetter extends Letter<Text>{
	
	public static final double COST = 1;

	public SimpleLetter(Inhabitant r, Inhabitant s, Text t) {
		super(r, s, t);
	}

	@Override
	public double getCost() {
		return COST;
	}

	@Override
	public void action() throws Exception {}

	@Override
	public String toString() {
		return "Simple Letter (" + this.getContent().toString() + ")";
	}
	

}
