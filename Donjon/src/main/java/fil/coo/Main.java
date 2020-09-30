package fil.coo;

import java.util.*;
import java.util.Scanner;

import fil.coo.Other.ListChoser;
import fil.coo.Other.CustomMessages;
import fil.coo.Character.*;
import fil.coo.Action.*;

public class Main extends CustomMessages{
	
	
	private static Scanner sc;

	/**
	 * create player with custom name
	 * @return new Player with basic stats
	 */
	
	public static Player createPlayer() {
		
		// read player name
		sc = new Scanner(System.in); 
		System.out.print("Welcome, please enter your character name: ");
		String name = sc.nextLine(); 
		
		// create player
		return new Player(name, 100, 200, 200);
	}

	/**
	 * create list with all actions
	 * @return actionList
	 */
	public static List<Action> createAction(){
		List<Action> actionList = new ArrayList<Action>();
        Action a = new AttackAction();
        Action l = new LookAction();
        Action m = new MoveAction();
        Action u = new UseAction();
        actionList.add(a);
        actionList.add(l);
        actionList.add(m);
        actionList.add(u);
       
        
        return actionList;
	}
	
	
	
	public static void main(String args[]) throws Exception {
		
		
		// generate rooms [fil.coo.Generate@createDungeon()]
        AdventureGame d = Generate.createDungeon();
        
        // custom message
        welcomeText();
        
        Player p = createPlayer();
        
        // put player in first room of dungeon
        p.setCurrentRoom(d.firstRoom);

        List<Action> actionList = createAction();
        
        // display infos
        System.out.println("You enter in the dungeon.\n" + p.displayStats());
        System.out.println("------------------------");
        
        
        // main loop
        while (!p.isDead() & !p.getCurrentRoom().isExit()) {
        	// create list<action> for possible actions
	        List<Action> actionPossible = new ArrayList<Action>();
	        
	        for(Action list: actionList) {
	        	if(list.isPossible(p.getCurrentRoom())) {
	        		actionPossible.add(list);
	        	}
	        }
	        
	        // put possibles action in list
	        p.setActions(actionPossible);
	        
	        // create listchoser for generic actions
	    	ListChoser lc = new ListChoser();
	    	System.out.println("[POSSIBLE ACTIONS]");
	    	Action chosenAction = lc.chose("Which action?", p.getActions());
	    	System.out.println("---------------------------------------");
	    	System.out.println("You chose: " + chosenAction.toString());
	    	System.out.println("---------------------------------------");
	    	
	  
	    	// execute selected action [fil.coo.Action.??Action@execute(p)]
	    	chosenAction.execute(p);
        }

        // stop if player defeat monsters in exit room
        if(p.getCurrentRoom().isExit()) {
        	winText();
        }
        
        // stop if player is dead
        if(p.isDead()) {
        	gameOverText();
        }


        
        
        
        
        
     
	}
	

}
