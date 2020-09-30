package fil.coo;

import java.util.ArrayList;
import java.util.List;

import fil.coo.AdventureGame.Way;
import fil.coo.Map.Room;

public class Generate {

	
	public static AdventureGame createDungeon() {
		

		Room r1 = new Room("Enter", 2,1, false);
		Room r2 = new Room("Kitchen", 3,2, false);
		Room r3 = new Room("Exit", 1,3, true);

		
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		
		
		r1.setDestination(Way.EAST, r2);
		r2.setDestination(Way.WEST, r1);
		r2.setDestination(Way.EAST, r3);
		r3.setDestination(Way.WEST, r2);
		
		
		AdventureGame d = new AdventureGame(rooms);
		d.setFirstRoom(r1);
		return d;
		
		
		
		}
	
	
	public static AdventureGame createDungeonSimple() {
		Room r1 = new Room("Enter", 2,2, false);
		Room r2 = new Room("Kitchen", 3,2, false);
		Room r3 = new Room("Exit", 1,2, true);


		
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		
		
		r1.setDestination(Way.EAST, r2);
		r2.setDestination(Way.WEST, r1);
		r2.setDestination(Way.EAST, r3);
		r3.setDestination(Way.WEST, r2);
		
		
		AdventureGame d = new AdventureGame(rooms);
		d.setFirstRoom(r1);
		return d;
		}
	
	
	
	

}
