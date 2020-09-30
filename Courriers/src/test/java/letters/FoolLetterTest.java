package letters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fil.coo.city.City;
import fil.coo.city.Inhabitant;
import fil.coo.letters.FoolLetter;
import fil.coo.letters.Letter;
import fil.coo.letters.content.ListOfInhabitants;

public class FoolLetterTest{
	
	City city = new City("X");
	Letter<?> letter;
	ArrayList<Inhabitant> listOfInh = new ArrayList<Inhabitant>();
	ListOfInhabitants listOfInhabitants;
	Inhabitant master;
	Inhabitant poor_master;
	Inhabitant receiver;
	
	
	@Before
	public void init() {
		Inhabitant random1 = new Inhabitant("random1", city, 99);
		Inhabitant random2 = new Inhabitant("random2", city, 99);
		Inhabitant random3 = new Inhabitant("random3", city, 99);
		Inhabitant random4 = new Inhabitant("random4", city, 99);
		
		this.city.addInhabitant(random1);
		this.city.addInhabitant(random2);
		this.city.addInhabitant(random3);
		this.city.addInhabitant(random4);
		
		this.master = new Inhabitant("Inhabitant_sender", city, 9999);
		this.poor_master = new Inhabitant("Inhabitant_sender", city, 0);
		this.receiver = new Inhabitant("Inhabitant_sender", city, 999);
		
		this.city.addInhabitant(master);
		this.city.addInhabitant(receiver);
		this.city.addInhabitant(poor_master);
		
		
		
		this.listOfInh.add(master.getCity().getRandomInhabitant());
		this.listOfInh.add(master.getCity().getRandomInhabitant());
		this.listOfInh.add(master.getCity().getRandomInhabitant());
		this.listOfInh.add(master.getCity().getRandomInhabitant());
		
		this.listOfInhabitants = new ListOfInhabitants(listOfInh);
		
	}
	
	@Test
	public void sendLetterWhenSenderAndReceiverHaveEnoughMoney() throws Exception{
		letter = new FoolLetter(receiver, master, listOfInhabitants);
		letter.action();
	}
	
	@Test(expected = Exception.class)
	public void sendLetterWhenSenderAndReceiverHaventEnoughMoneyThrowException() throws Exception {
		letter = new FoolLetter(poor_master, master, listOfInhabitants);
		letter.action();
	}
	
}
