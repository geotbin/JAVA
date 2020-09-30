package fil.coo.Item;

import fil.coo.Character.Player;

public class StrengthPotion extends Item{
	
	private String label = "Strength Potion";
	
	/**
	 * fixed quantity for the item "Strength Potion"
	 */
	private final int quantity = 25;
	
	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void effect(Player p) {
		if(this.quantity <= 0) {
			p.setStrength(p.getStrength());
		} else {
			p.setStrength(p.getStrength() + quantity);
		}
	}

	
	@Override
	public String toString() {
		return "Strength Potion (" + this.quantity + ")";
	}
	
}

