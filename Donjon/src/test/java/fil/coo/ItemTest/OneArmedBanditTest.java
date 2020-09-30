package fil.coo.ItemTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Character.Player;
import fil.coo.Map.Room;
import fil.coo.Item.*;


public class OneArmedBanditTest{

	Room r;
	Player p;
	OneArmedBandit i;
	
	@Before
	public void initiliaze() {
		r = new Room("kitchen", 0, 1, false);
		p = new Player("Test", 100, 100,100);
		i = new OneArmedBandit();
		p.setCurrentRoom(r);
		
	}

	@Test
	public void testOneArmedBanditEnoughMoney() throws Exception{
		p.setGold(100);
		i.effect(p);
		// final price of bandit is 100
		assertTrue(p.getGold() == 0);
	}
	
	@Test(expected = AssertionError.class)
	public void testOneArmedBanditNotEnoughMoney() throws Exception{
		p.setGold(99);
		i.effect(p);
		// final price of bandit is 100
		assertTrue(p.getGold() == 0);
	}
}
