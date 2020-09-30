package letters;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import fil.coo.city.City;
import fil.coo.city.Inhabitant;
import fil.coo.letters.Letter;

public abstract class LetterTest {

	Inhabitant sender_money_ok;
	Inhabitant receiver_money_ok;
	Inhabitant sender_money_no;
	Inhabitant receiver_money_no;
	protected Letter<?> letter1;
	protected Letter<?> letter2;
	
	@Before
	public void init() {
		City city = new City("Lille");
		Inhabitant sender_money_ok = new Inhabitant("Inhabitant_sender", city, 9999);
		Inhabitant receiver_money_ok = new Inhabitant("Inhabitant_receiver", city, 9999);
		Inhabitant sender_money_no = new Inhabitant("Inhabitant_sender", city, 0);
		Inhabitant receiver_money_no = new Inhabitant("Inhabitant_receiver", city, 0);
		
		this.letter1 = this.createLetter(sender_money_ok, receiver_money_ok);
		this.letter2 = this.createLetter(sender_money_no, receiver_money_no);
	}
	
	protected abstract Letter<?> createLetter(Inhabitant sender, Inhabitant receiver);
	
	
	public abstract void doActionSpecificTest(Letter<?> letter) throws Exception;
	
	
	
	@Test
	public void doActionSpecificTestWork() throws Exception {
		doActionSpecificTest(letter1);
	}
	
	@Test(expected = Exception.class)
	public void doActionSpecificTestDontWorkThrowException() throws Exception {
		doActionSpecificTest(letter2);
	}
	
	@Test
	public void sendLetterWhenSenderAndReceiverHaveEnoughMoney() throws Exception {
		double initial_amount = this.letter1.getSender().getBankAccount().getAmount();
		
		System.out.println(this.letter1.getSender().getBankAccount().getAmount());
		this.letter1.getSender().sendLetter(letter1);
		System.out.println(this.letter1.getSender().getBankAccount().getAmount());
		
		assertTrue(initial_amount-this.letter1.getCost() == this.letter1.getSender().getBankAccount().getAmount());
	}
	
	@Test(expected = Exception.class)
	public void sendLetterWhenSenderAndReceiverHaventEnoughMoneyThrowException() throws Exception {
		double initial_amount = this.letter2.getSender().getBankAccount().getAmount();
		
		System.out.println(this.letter2.getSender().getBankAccount().getAmount());
		this.letter2.getSender().sendLetter(letter2);
		System.out.println(this.letter2.getSender().getBankAccount().getAmount());
		
		assertTrue(initial_amount-this.letter2.getCost() == this.letter2.getSender().getBankAccount().getAmount());
		
	}
	
	

}