package fil.coo.CharacterTest;

import fil.coo.Character.Monster;

public class MonsterTest extends CharacterTest{

	@Override
	public fil.coo.Character.Character createCharacter(String name, int hp, int st, int gold) {
		return new Monster(name, hp, st, gold);
	}
	
	

}
