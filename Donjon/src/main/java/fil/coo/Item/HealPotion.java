package fil.coo.Item;

import fil.coo.Character.Player;

public class HealPotion extends Item{
	
	private String label = "Heal Potion";
	
	/**
	 * fixed quantity for the item "HealPotion"
	 */
	private final int quantity = 15;

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void effect(Player p) {
		if(p.getHp() + quantity > p.MAX_HP) {
			p.setHp(p.MAX_HP);
		}
		else {
			p.setHp(p.getHp() + quantity);
		}
	}
	
	@Override
	public String toString() {
		return "Heal Potion (" + this.quantity + "hp)";
	}
	
	

}
