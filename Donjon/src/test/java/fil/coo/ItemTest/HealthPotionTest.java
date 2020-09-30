package fil.coo.ItemTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import fil.coo.Character.Player;


import fil.coo.Item.*;


public class HealthPotionTest {
	
	Player c;
	Item i;
	@Before
	
	public void initiliaze() {
		c = new Player("Test", 100, 100,100);
		i = new HealPotion();
	}

	@Test
	public void testPotionWhenLessHPThanMax() throws Exception{
		c.setHp(50);
		i.effect(c);
		assertEquals(65, c.getHp());
	}
	
	@Test
	public void testPotionWhenMaxHP() throws Exception {
		c.setHp(100);
		i.effect(c);
		assertEquals(100, c.getHp());
	}
}
