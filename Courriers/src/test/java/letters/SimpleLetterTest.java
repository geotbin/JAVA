package letters;


import content.MockText;
import fil.coo.city.Inhabitant;
import fil.coo.letters.Letter;
import fil.coo.letters.SimpleLetter;

public class SimpleLetterTest extends LetterTest{

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new SimpleLetter(receiver, sender, new MockText());
	}

	@Override
	public void doActionSpecificTest(Letter<?> letter) throws Exception {
		letter.getSender().getBankAccount().debit(letter.getCost());
		letter.getReceiver().getBankAccount().credit(letter.getCost());
	}

	
	
}
