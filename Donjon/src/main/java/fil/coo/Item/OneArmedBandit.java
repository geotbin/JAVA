package fil.coo.Item;



import java.util.List;

import fil.coo.Character.Player;

public class OneArmedBandit extends Item{

	private String label = "One Armed Bandit";
	
	/**
	 * fixed value for the item "OneArmedBandit"
	 */
	private final int price = 100;
	
	@Override
	public String getLabel() {
		return this.label;
	}
	

	@Override
	public void effect(Player p) throws Exception {
		
		// if player has enough money
		if(p.getGold() >= price) {
			
			// generate one item randomly
			List<? super Item> item = generateItem(p.getCurrentRoom(), 1, true);
			for(int i=0; i<item.size(); i++) {
				
				//remove money (price) of player
				p.removeGold(this.price);
				System.out.println("You won: "+ item.toString());
				// apply effect to player
				((Item) item.get(i)).effect(p);	
				// delete item
				p.getCurrentRoom().removeItem(item);
			}
		} else
		{
			System.out.println("You don't have enough money, bandit disappears");
		}
	}
	

	@Override
	public String toString() {
		return "One Armed Bandit (" + this.price + " gold needed)";
	}


	public int getPrice() {
		return this.price;
	}
	
	
}
