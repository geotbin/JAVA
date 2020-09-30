package fil.coo.CharacterTest;

import fil.coo.Character.Player;

public class PlayerTest extends CharacterTest{
	
	@Override
	public fil.coo.Character.Character createCharacter(String name, int hp, int st, int gold) {
		return new Player(name, hp, st, gold);
	}
	
}
