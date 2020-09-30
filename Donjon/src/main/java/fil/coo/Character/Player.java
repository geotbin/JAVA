package fil.coo.Character;

import java.util.*;

import fil.coo.Action.*;
public class Player extends Character{
	
	public final int MAX_HP = 100;
	
	private List<Action> actions = new ArrayList<Action>();

	/**
	 * @param name Player's name
	 * @param hp Player's hp
	 * @param strength Player's strength
	 * @param gold Player's gold
	 */
	public Player(String name, int hp, int strength, int gold) {
		super(name, hp, strength, gold);
	}

	
	/**
	 * @return actions
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions give Actions for the player
	 */
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	
	/**
	 * remove gold when player use bandit effect
	 * @param price cost of asked method
	 */
	public void removeGold(int price) {
		if ((this.getGold() - price) <= 0) {
			this.setGold(0);
		}
		else {
			this.setGold(this.getGold() - price);
		}
	}
	
	public void die(){
		gameOverText();
	}

	

}
