package fil.coo.CharacterTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Character.Character;
import fil.coo.CharacterTest.MockCharacter;

public abstract class CharacterTest{
	
	Character c;
	
	@Before
	public void initiliaze() {
		this.c = createCharacter("Tester", 100, 10, 500);
	}
	
	
	public Character createCharacter(String name, int hp, int st, int gold) {
		return new MockCharacter(name, hp, st, gold);
	}

	
	@Test
	public void testCharacterIsDead() {
		this.c.setHp(0);
		assertTrue(this.c.isDead());
	}
	
	

	@Test(expected = AssertionError.class)
	public void testAttackWhenCharacterIsDeadThrowException(){
		Character opponent = createCharacter("Opponent", 100,1,1);
		
		this.c.setHp(0);
		this.c.attack(opponent);
		assertEquals(opponent.getHp(), 100);
		
	}

	@Test
	public void testAttackWhenCharacterIsNotDead(){
		
		Character opponent = createCharacter("Opponent", 100, 1, 1);
		this.c.attack(opponent);
		assertEquals(opponent.getHp(), 90);
		
	}
	
	
	
	
	 
}