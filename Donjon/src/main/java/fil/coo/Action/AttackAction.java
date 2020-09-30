package fil.coo.Action;

import fil.coo.Character.Monster;
import fil.coo.Character.Player;
import fil.coo.Map.Room;
import fil.coo.Other.ListChoser;

public class AttackAction implements Action {

	private static final String label = "Attack";
	

	@Override
	public boolean isPossible(Room r) {
		if(!r.getMonsters().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Player p) throws Exception {
		ListChoser lc = new ListChoser();
		Monster chosenMonster;
		
		// listchoser displaying all monsters in the room
		chosenMonster = lc.chose("Which monster?", p.getCurrentRoom().getMonsters());
		System.out.println("you chose " + chosenMonster.toString());
		
		// player attack monster [fil.coo.Character@attack(c)]
		p.attack(chosenMonster);
		System.out.println("You inflicted " + p.getStrength() + " damages");
		if(chosenMonster.isDead()) {
			System.out.println("The mob is dead");
			
			// mob drop gold if dead
			p.setGold(p.getGold() + chosenMonster.getGold());
			System.out.println("Monster dropped " + chosenMonster.getGold() + " gold");
			
			// remove monster from current room when dead
			p.getCurrentRoom().removeMonster(chosenMonster);
			
		// If mob is not dead 
		} else {
			
			// mob attacks player
			chosenMonster.attack(p);
			System.out.println("The monster attacked you! -" + chosenMonster.getStrength() + " hp");
		}
	}

	@Override
	public String toString() {
		return label;
	}
	
}
