package fil.coo.Item;

import fil.coo.Character.Player;

public class Gold extends Item{

	private String label = "Gold";
	
	/**
	 * fixed quantity for the item "Gold"
	 */
	private final int quantity = 50;
	
	
	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void effect(Player p) {
		p.setGold(p.getGold() + quantity);
	}
	
	@Override
	public String toString() {
		return this.quantity + " gold";
	}

}
