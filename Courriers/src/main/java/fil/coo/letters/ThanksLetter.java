package fil.coo.letters;

import fil.coo.city.Inhabitant;
import fil.coo.letters.content.Text;

public class ThanksLetter extends SimpleLetter{

	public ThanksLetter(Inhabitant receiver, Inhabitant sender, Text t) {
		super(receiver, sender, t);
	}
	
	
	@Override
	public String toString() {
		return "Thanks Letter (" + this.getContent().toString() + ")";
	}
	
}
