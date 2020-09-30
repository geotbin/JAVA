package city;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import content.MockContent;
import fil.coo.city.City;
import fil.coo.city.Inhabitant;
import fil.coo.letters.Letter;
import letters.MockLetter;

public class InhabitantTest {
	City c;
	Inhabitant habitant;
	Letter<?> letter;
	
	@Before
	public void init() {
		c = new City("Lille");
		habitant = new Inhabitant("Gautier", c, 5000);
		letter = new MockLetter(habitant, habitant, new MockContent());
	}
	
	@Test
	public void testCreateInhabitant() {
		assertTrue(habitant.getName() == "Gautier");
		assertTrue(habitant.getCity() == c);
		assertTrue(habitant.getBankAccount().getAmount() == 5000);
	}
	
	@Test
	public void testSendLetterWhenHabitantHasEnoughMoney() throws Exception {
		this.habitant.sendLetter(this.letter);
	}
	
	
	@Test(expected = Exception.class)
	public void testSendLetterWhenHabitantHasntEnoughMoneyThrowException() throws Exception {
		this.habitant.getBankAccount().debit(5000);
		this.habitant.sendLetter(this.letter);
	}

	@Test
	public void testIsPossibleToSendOk() throws Exception {
		assertTrue(this.habitant.isPossibleToSend(this.letter));
		
	}
	
	@Test(expected = AssertionError.class)
	public void testIsPossibleToSendThrowException() throws Exception {
		this.habitant.getBankAccount().debit(5000);
		assertTrue(this.habitant.isPossibleToSend(this.letter));
	}
}
