package fil.coo.Action;

import fil.coo.Map.*;
import fil.coo.Other.*;
import java.util.*;
import fil.coo.AdventureGame.Way;
import fil.coo.Character.*;

public class MoveAction implements Action{

	private static final String label = "Move";
	@Override
	public boolean isPossible(Room r) {
		if(!r.getMonsters().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void execute(Player p) {
		
		Room r = p.getCurrentRoom();
		System.out.println("Where do you want to go?");
		
		// listchoser with all destinations available
		ListChoser lc = new ListChoser();
		List<Way> s = Collections.list(Collections.enumeration(r.getDestination().keySet()));
		Way chosenWay = lc.chose("Which way?", s);
		// display infos
    	System.out.println("You chose: " + chosenWay.toString());
    	System.out.println("You quit: " + r.getNameRoom());
    	
    	// move player to selected way
    	p.setCurrentRoom(r.getDestination().get(chosenWay));
    	System.out.println("You enter: " + p.getCurrentRoom().getNameRoom());
    
		
	}

	@Override
	public String toString() {
		return label;
	}

}
