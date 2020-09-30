package city;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import content.MockContent;
import letters.MockLetter;
import fil.coo.city.City;
import fil.coo.city.Inhabitant;

public class CityTest {

	private City city;
	private Inhabitant h1;
	private Inhabitant h2;
	
	@Before
	public void init() {
		this.city = new City("Lille");
		h1 = new Inhabitant("h1", this.city, 0);
		h2 = new Inhabitant("h2", this.city, 0);
		this.city.addInhabitant(h1);
		this.city.addInhabitant(h2);
	}
	
	@Test
	public void testSendLetter() {
		
		assertTrue(this.city.mailbox.size() == 0);
		this.city.addLetter(new MockLetter(h1, h2, new MockContent()));
		
		assertTrue(this.city.mailbox.size() == 1);
		
		this.city.addLetter(new MockLetter(h2, h1, new MockContent()));
		assertTrue(this.city.mailbox.size() == 2);
	}
	
	@Test
	public void testDistributeLetter() throws Exception {
		
		this.city.addLetter(new MockLetter(h1, h2, new MockContent()));
		this.city.addLetter(new MockLetter(h2, h1, new MockContent()));
		assertTrue(this.city.mailbox.size() == 2);
		this.city.distributeLetters();
		assertTrue(this.city.mailbox.size() == 0);
	}
	
	
}
