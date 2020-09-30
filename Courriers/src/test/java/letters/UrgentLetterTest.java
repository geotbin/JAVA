package letters;


import content.MockContent;
import fil.coo.city.Inhabitant;
import fil.coo.decoratorLetters.UrgentLetter;
import fil.coo.letters.Letter;

public class UrgentLetterTest extends LetterTest{

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new UrgentLetter<Letter<?>>(new MockLetter(sender, receiver, new MockContent()));
	}

	@Override
	public void doActionSpecificTest(Letter<?> letter) throws Exception {
		letter.getSender().getBankAccount().debit(letter.getCost());
		letter.getReceiver().getBankAccount().credit(letter.getCost());
	}



}
