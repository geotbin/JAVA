package fil.coo.city;

import java.util.*;
import fil.coo.letters.Letter;

public class City {
	public String name;
	public List<Inhabitant> inhabitants;
	public List<Letter<?>> mailbox;
	Random random = new Random();
	
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<>();
		this.mailbox = new ArrayList<>();
	}
	
	
	/**
	 * @param letter
	 * add letter to city's mailbox
	 */
	public void addLetter(Letter<?> letter) {
		this.mailbox.add(letter);
	}
	
	/**
	 * @throws Exception
	 * distribute all the mailbox's letters
	 */
	public void distributeLetters() throws Exception{
		
		
		List<Letter<?>> clonedBox = new ArrayList<>();
		for(Letter<?> letter : mailbox) {
			clonedBox.add(letter);
		}
		
		this.mailbox.clear();
		
		for(Letter<?> l: clonedBox) {
			Inhabitant receiver = l.getReceiver();
			if(this.inhabitants.contains(receiver)) {
				receiver.receiveLetter(l);
			} else {
				throw new Exception("inhabitant not found in this city");
			}
		}
	}
	
	/**
	 * @param inhabitant
	 * add inhabitant to current city
	 */
	
	public void addInhabitant(Inhabitant inhabitant) {
		inhabitants.add(inhabitant);
	}
	
	/**
	 * @return Inhabitant
	 * get random inhabitant from current city
	 */
	public Inhabitant getRandomInhabitant() {
		return this.inhabitants.get(random.nextInt(this.inhabitants.size()));	
	}
	
	
}
