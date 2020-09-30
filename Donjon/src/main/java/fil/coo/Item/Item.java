package fil.coo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fil.coo.Character.*;
import fil.coo.Map.Room;

/**
 * @author cavannac
 *
 */
public abstract class Item{
	
	/**
	 * 
	 * @return String label of item
	 */
	public abstract String getLabel();
	
	/**
	 * the effect of the item on the player
	 * @param p
	 * @throws Exception 
	 * 
	 * @param p the effect of the item on the player
	 */

	public abstract void effect(Player p) throws Exception;
	
	/**
	 * generate [nbItems] items for the room r.
	 * If bandit is true, generate items except oneArmedBandit and gold
	 * You can't get gold or bandit when u use oneArmedBandit
	 * @param r generate item for specific room
	 * @param nbItems number of desire items
	 * @param bandit if items are generated for whether a bandit or not
	 * @return generatedItems
	 */
	public static List<Item> generateItem(Room r, Integer nbItems, boolean bandit) {
		
		// create list with all items
		List<? super Item> items = new ArrayList<Object>();	
		HealPotion hp = new HealPotion();
		StrengthPotion strengthPotion = new StrengthPotion();
		items.add(hp);
		items.add(strengthPotion);
		
		
		// if bandit is false, add item "OneArmedBandit" to items list
		if(!bandit) {
			OneArmedBandit oneArmedBandit = new OneArmedBandit();
			Gold gold = new Gold();
			items.add(oneArmedBandit);
			items.add(gold);
		}
		
		// create list of generatedItems
		List<Item> generatedItems = new ArrayList<>();
		
		
		for(int i=0; i< nbItems; i++) {
			
			// get random item of items list
			int r1 = new Random().nextInt(items.size());
			
			// add item in generatedItems
			generatedItems.add((Item) items.get(r1));
		}
		
		return generatedItems;
	}
	
	
	
	
}