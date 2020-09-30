package fil.coo.Character;


import fil.coo.Map.*;
import fil.coo.Other.CustomMessages;


public abstract class Character extends CustomMessages{
	
	private int hp;
	private int strength;
	private int gold;
	private Room currentRoom;
	private String name;
	
	/**
	 * @param name character's name
	 * @param hp character's hp
	 * @param strength character's strength
	 * @param gold character's gold
	 */
	public Character(String name, int hp, int strength, int gold) {
		this.name = name;
		this.hp = hp;
		this.strength = strength;
		this.gold = gold;
	}
	

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	/**
	 * check if character's hp under or equals 0
	 * @return boolean
	 */
	public boolean isDead() {
		if(this.hp <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param c attack c if character is not dead
	 */
	public void attack(Character c){
		if(!c.isDead()) {
			c.setHp(c.getHp() - this.getStrength());
		}
	}

	/**
	 * display current stats of character
	 * @return String
	 */
	public String displayStats() {
		return this.getName() + " --> HP: " + this.getHp() + " || Strength: " + this.getStrength() + "|| Gold: " + this.getGold();
	}
	
}
