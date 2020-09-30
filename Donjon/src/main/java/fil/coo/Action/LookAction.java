package fil.coo.Action;

import fil.coo.Character.Monster;
import fil.coo.Character.Player;
import fil.coo.Item.Item;
import fil.coo.Map.*;

public class LookAction implements Action{

	private static final String label = "Look";
	
	
	
	@Override
	public boolean isPossible(Room r) {
		return true;
	}

	@Override
	public void execute(Player p) {
		// display player infos
		System.out.println(p.displayStats());
		
		// display all monsters with their stats
		System.out.println("You look around and you notice " + p.getCurrentRoom().getMonsters().size() + " monster(s)");
		for(Monster m : p.getCurrentRoom().getMonsters()) {
			System.out.println(" * " + m.displayStats());
		}
		// display all items with their stats
		System.out.println("You can see " + p.getCurrentRoom().getItems().size() + " item(s)");
		for(Object i : p.getCurrentRoom().getItems()) {
			System.out.println(" -" + ((Item) i).toString());
		}
		// display number of possible doors
		System.out.println(p.getCurrentRoom().getDestination().size() + " door(s) available when all the monsters are dead");
		
		
	}

	@Override
	public String toString() {
		return label;
	}

}
