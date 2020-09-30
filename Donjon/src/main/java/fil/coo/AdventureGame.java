package fil.coo;

import java.util.*;

import fil.coo.Map.*;

public class AdventureGame {
	
	
	private List<Room> r;
	protected Room firstRoom;

	
	/**
	 * different ways for each rooms
	 */
	public enum Way {
		NORTH,
		SOUTH,
		WEST,
		EAST
	}
	

	private Room currentRoom;
	
	
	public AdventureGame(List<Room> r) {
		this.setRooms(r);
	}
	

	/**
	 * check if current room is exit
	 * @return boolean
	 */
	
	public boolean isExit() {
		return currentRoom.isExit();
	}
	
	public void setCurrentRoom(Room room){
		this.currentRoom = room;
	}

	
	public Room getFirstRoom() {
		return firstRoom;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}


	public List<Room> getRooms() {
		return r;
	}


	public void setRooms(List<Room> r) {
		this.r = r;
	}
	
	public void setFirstRoom(Room r) {
		this.firstRoom = r;
	}


}