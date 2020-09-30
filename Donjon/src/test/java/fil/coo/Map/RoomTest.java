package fil.coo.Map;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Character.Monster;
import fil.coo.Item.HealPotion;
import fil.coo.Item.Item;

public class RoomTest {

	Room r1;
	Room r2;
	Room r3;
	
	@Before
	public void init() {
		this.r1 = new Room("random room",0, 0,false);
		this.r2 = new Room("exit room", 0, 0,true);
		this.r3 = new Room("exit room", 1, 1,true);
	}
	
	
	@Test
	public void testRoomIsExitRoom() {
		assertTrue(r2.isExit());
	}
	
	@Test(expected = AssertionError.class)
	public void testRoomIsNotExitRoom() {
		assertTrue(r1.isExit());
	}
	
	
	@Test
	public void testRemoveItemWhenThereAreItemsInRoom() throws Exception {
		
		List<? super Item> items = new ArrayList<Object>();	
		HealPotion hp = new HealPotion();
		items.add(hp);
		r3.setItems(items);
		
		r3.removeItem(hp);
		assertTrue(r3.getItems().size() == 0);
	}
	
	
	
	@Test(expected = Exception.class)
	public void testRemoveItemWhenThereIsNoItems() throws Exception {
		HealPotion hp = new HealPotion();
		r2.removeItem(hp);
	}
	
	
	
	@Test
	public void testRemoveMonstersWhenThereAreMonstersInRoom() throws Exception {
		List<Monster> monsters = new ArrayList<Monster>();
		Monster monster;
		monster = new Monster("Cyclop",40, 5, 200);
		monsters.add(monster);
		r2.setMonsters(monsters);
		
		r2.removeMonster(monster);
		
	}
	
	@Test(expected = Exception.class)
	public void testRemoveMonstersWhenThereIsNoMonstersInRoom() throws Exception {
		Monster monster = new Monster("Cyclop",40, 5, 200);
		r2.removeMonster(monster);
		
	}
	
	
}
