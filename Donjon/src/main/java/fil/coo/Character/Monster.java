package fil.coo.Character;

import java.util.*;

import fil.coo.Map.Room;

public class Monster extends Character{

	public Monster(String name, int hp, int strength, int gold) {
		super(name, hp, strength, gold);
	}

	/**
	 * 
	 * @param r generate [nbMonsters] monsters for the room r
	 * @param nbMonsters number of desired monsters
	 * @param boss if the room wants a boss
	 * @return monsters
	 */
	public static List<Monster> generateMonsters(Room r, Integer nbMonsters, boolean boss) {

		// list of monsters 
		List<Monster> monsters = new ArrayList<Monster>();
		
		Monster monster;
		
		if(nbMonsters <= 0) {
			return monsters;
		} else {
			for(int i = 0; i < nbMonsters; i++) {
				
				// create new monster
				if(boss) {
					monster = new Monster("Boss",50, 15, 2000);
				} else {
					monster = new Monster("Cyclop",40, 5, 200);
				}
				
				// put monster in room
				monster.setCurrentRoom(r);
				monsters.add(monster);
			}
			return monsters;
		}

	}
	
	
	
	@Override
	public String toString() {
		
		return this.getName() + " (" + this.getHp() + "hp)";
	}
	
}
