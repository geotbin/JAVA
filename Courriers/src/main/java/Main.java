import java.util.ArrayList;
import java.util.Random;


import fil.coo.city.City;
import fil.coo.city.Inhabitant;
import fil.coo.decoratorLetters.RegisteredLetter;
import fil.coo.decoratorLetters.UrgentLetter;
import fil.coo.letters.BillOfExchange;
import fil.coo.letters.FoolLetter;
import fil.coo.letters.Letter;
import fil.coo.letters.SimpleLetter;
import fil.coo.letters.content.ListOfInhabitants;
import fil.coo.letters.content.Money;
import fil.coo.letters.content.Text;

public class Main {

	public static void main(String[] args) throws Exception {
	
		// firstSimulation();
		secondSimulation();
		
	}
	
	
	
	// FIRST SIMULATION W/ RANDOMS LETTERS
	
	
	public static void firstSimulation() throws Exception {
		int nbHabitants = 100;
		int nbJours = 7;
		int day;
		
		City c = new City("V");
		
		for(int i = 1; i <= nbHabitants; i++){
			Inhabitant h = new Inhabitant("#"+i, c, 1000);
			c.addInhabitant(h);
		}
		
		
		for(day = 1; day < nbJours+1; day++){
			System.out.println("----------------- \n Day"+ day + "\n-----------------");
			
			
			// Distributing letters ...
			if(!c.mailbox.isEmpty()){
				c.distributeLetters();
			}
			
			
			
			// Sending letters ...
			for (int i = 0; i < 1; i++) {
				Inhabitant sender = c.getRandomInhabitant();
				sender.sendLetter(createRandomLetters(sender));
			}
			
			
			// Distributing letters ...
			if(!c.mailbox.isEmpty()){
				c.distributeLetters();
			}
			
			
		}
	
		
	}
	

	
	public static Letter<?> createRandomLetters(Inhabitant sender){
		
		Random r = new Random();
		Inhabitant receiver = sender.getCity().getRandomInhabitant();
		Letter<?> l1;
		Letter<?> l2;
		
		
		 switch (r.nextInt(2)) {
			case 0:
				l1 = new SimpleLetter(receiver, sender, new Text("This is a test message"));
				break;
			case 1:
				l1 = new BillOfExchange(receiver, sender, new Money(50));
				break;
			default:
				
				return null;
		}
		 
		 
		switch (r.nextInt(3)) {
			case 0:
				l2 = l1;
				return l2;
				
			case 1:
				l2 = new RegisteredLetter<>(l1);
				if (r.nextInt(2) == 0) {
					l2 = new UrgentLetter<>(l2);
				}
				
				break;
				
				
			case 2:
				l2 = new UrgentLetter<>(l1);
				
				if (r.nextInt(2) == 0) {
					l2 = new RegisteredLetter<>(l2);
				}
				break;
				
			default:
				return null;
		}
		
		return l2;
	}
	
	
	// END OF FIRST SIMULATION
	
	
	
	
	
	// SECOND SIMULATION W/ FOOL LETTERS
	
	
	
	public static void secondSimulation() throws Exception {
		int nbHabitants = 100;
		int nbJours = 7;
		int day;
		
		City c = new City("V");
		
		for(int i = 1; i <= nbHabitants; i++){
			Inhabitant h = new Inhabitant("#"+i, c, 1000);
			c.addInhabitant(h);
		}
		
		Inhabitant master = new Inhabitant("Master", c, 10000);
		c.addInhabitant(master);
		randomFoolLetters(c, master);
		
		for(day = 1; day < nbJours+1; day++){
			System.out.println("#### MASTER'S MONEY: " + master.getBankAccount().getAmount());
			System.out.println("----------------- \n Day"+ day + "\n-----------------");

			if(!c.mailbox.isEmpty()){
				c.distributeLetters();
			}
		
		}
	}
	
	
	
	
	
	public static void randomFoolLetters(City c, Inhabitant master) throws Exception{
		
		ArrayList<Inhabitant> listOfInhab = new ArrayList<Inhabitant>();
		
		listOfInhab.add(master.getCity().getRandomInhabitant());
		listOfInhab.add(master);
		listOfInhab.add(master.getCity().getRandomInhabitant());
		listOfInhab.add(master.getCity().getRandomInhabitant());
		
		Inhabitant receiver = master.getCity().getRandomInhabitant();
		master.sendLetter(new FoolLetter(receiver, master, new ListOfInhabitants(listOfInhab)));
	}
	
	// END OF SECOND SIMULATION
	
	
	
	
	
}
