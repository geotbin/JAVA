package fil.coo.Map;



import java.util.*;


import fil.coo.AdventureGame.Way;
import fil.coo.Character.*;
import fil.coo.Item.Item;

public class Room
{

	
	/**
	 * List of all monsters in the room
	 */
	private List<Monster> monsters;
	/**
	 * List of various items that extends Item in the Room 
	 */
	private List<Item> items;
	/**
	 * direction of the room
	 */
	private Map<Way, Room> destination;
	/**
	 * if the room is whether an exit or not
	 */
	private boolean isExit;
	/**
	 * the name of the room
	 */
	private String nameRoom;

	
	/**
	 * constructor which automatically generate monsters and items
	 * @param nameRoom name of the room
	 * @param nbMonsters number of monsters
	 * @param isExit if the room is the exit
	 */
	
	public Room(String nameRoom, int nbMonsters, boolean isExit) {
		this.destination = new HashMap<Way, Room>();
	}
	public Room(String nameRoom, int nbMonsters, int nbItems,boolean isExit) {
		this.destination = new HashMap<Way, Room>();
		this.isExit = isExit;
		
		// if room 'isExit' is true, generate one strong monster (boss)
		if(this.isExit) {
			this.monsters = Monster.generateMonsters(this,nbMonsters, true);
		} else {
			this.monsters = Monster.generateMonsters(this, nbMonsters, false);
		}
		
		this.nameRoom = nameRoom;
		// generate items in the room (false = oneArmedBandit authorized)
		this.items = Item.generateItem(this, nbItems, false);
	}
	
	
	/**
	 * all monsters of the room
	 * @return monsters
	 */
	public List<Monster> getMonsters() {
		return monsters;
	}

	/**
	 * @param monsters set monsters of the room
	 */
	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}

	/**
	 * all items of the room
	 * @return items all items of the room
	 */
	public List<Item> getItems() {
		return this.items;
	}

	/**
	 * define items of the room
	 * @param items room's items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * map of the room
	 * @return destination
	 */
	public Map<Way, Room> getDestination() {
		return destination;
	}

	/**
	 * define a way (NORTH/SOUTH/EAST/WEST) to a specific Room
	 * @param w1 way of the linked room
	 * @param r1 linked room
	 */
	public void setDestination(Way w1, Room r1) {
		this.destination.put(w1, r1);
	}

	/**
	 * if room is empty check if it's exit or not
	 * @return isExit
	 */
	public boolean isExit() {
		if(this.getMonsters().size() == 0)
			return isExit;
		return false;
	}

	/**
	 * the name of the room
	 * @return nameRoom
	 */
	public String getNameRoom() {
		return nameRoom;
	}

	/**
	 * change the name of the room
	 * @param nameRoom name of the room
	 */
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	
	/**
	 * remove a monster from the room
	 * @param monster
	 * @throws Exception 
	 * @param monster remove a monster
	 */
	public void removeMonster(Monster monster) throws Exception {
		if(this.getMonsters().size() > 0) {
		monsters.remove(monster);
		} else {
			throw new Exception("no monsters in current room");
		}
	}

	/**
	 * remove an item from the room
	 * @param itemChosen
	 * @throws Exception 
	 * @param itemChosen remove an item
	 */

	public void removeItem(Object itemChosen) throws Exception {
		if(this.getItems().size() > 0) {
			items.remove(itemChosen);
		} else {
			throw new Exception("no items in current room");
		}
		
	}

	


	

}
