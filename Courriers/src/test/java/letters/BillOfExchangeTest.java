package letters;

import content.MockMoney;
import fil.coo.city.Inhabitant;
import fil.coo.letters.BillOfExchange;
import fil.coo.letters.Letter;

public class BillOfExchangeTest extends LetterTest{

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new BillOfExchange(receiver, sender, new MockMoney());
	}

	@Override
	public void doActionSpecificTest(Letter<?> letter) throws Exception {
		letter.getSender().getBankAccount().debit(letter.getCost() + 50);
		letter.getReceiver().getBankAccount().credit(50);
		
	}





	

}
