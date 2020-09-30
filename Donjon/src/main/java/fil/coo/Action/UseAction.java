package fil.coo.Action;

import fil.coo.Item.*;
import fil.coo.Character.Player;
import fil.coo.Map.*;
import fil.coo.Other.ListChoser;

public class UseAction implements Action{

	private static final String label = "Use";
	@Override
	public boolean isPossible(Room r) {
		if (r.getItems().size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void execute(Player p) throws Exception {
		// listchoser with items available
		ListChoser lc = new ListChoser();
		Item itemChosen;
		itemChosen = lc.chose("Which item?", p.getCurrentRoom().getItems());
		System.out.println("You chose " + itemChosen.toString());
		// put item effect on player
		(itemChosen).effect(p);
		// remove item from current room
		p.getCurrentRoom().removeItem(itemChosen);
	}

	@Override
	public String toString() {
		return label;
	}

}
