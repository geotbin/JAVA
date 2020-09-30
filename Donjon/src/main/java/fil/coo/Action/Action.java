package fil.coo.Action;

import fil.coo.Character.Player;
import fil.coo.Map.Room;

public interface Action {
		/**
		 * 
		 * @param r check if the action is possible in the room r
		 * @return boolean
		 */
		public boolean isPossible(Room r);
		
		
		/**
		 * execute the action based on player's choice
		 * @param p
		 * @throws Exception 
		 * 
		 * @param p execute the action based on player's choice
		 */
		public void execute(Player p) throws Exception;
		
		
		/**
		 * giving libelle of the action
		 * @return String
		 */
		public String toString();

}
