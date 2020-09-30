package fil.coo.ItemTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Character.*;
import fil.coo.Item.*;

public class GoldTest{

	Player c;
	Item i;
	@Before
	public void initiliaze() {
		c = new Player("Test", 100, 100,100);
		i = new Gold();
	}

	@Test
	public void testGoldUpgrade() throws Exception{
		i.effect(c);
		assertEquals(150, c.getGold());
	}

}
