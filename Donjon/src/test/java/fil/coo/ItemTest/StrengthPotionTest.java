package fil.coo.ItemTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Character.Player;
import fil.coo.Item.*;

public class StrengthPotionTest {
	
	Player c;
	Item i;
	@Before
	public void initiliaze() {
		c = new Player("Test", 100, 100,100);
		i = new StrengthPotion();
	}

	@Test
	public void testStrengthPotionUpgrade() throws Exception{
		i.effect(c);
		assertEquals(125, c.getStrength());
	}
}