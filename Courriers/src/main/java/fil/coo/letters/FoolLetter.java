package fil.coo.letters;

import java.util.ArrayList;
import java.util.Random;


import fil.coo.city.Inhabitant;
import fil.coo.letters.content.*;

public class FoolLetter extends Letter<ListOfInhabitants>{
	public static final double COST = 1;
	public static final double FOOLTAX = 5;
	
	ListOfInhabitants listOfInhabitants;
	
	public FoolLetter(Inhabitant r, Inhabitant s, ListOfInhabitants l) {
		super(r,s,l);
		listOfInhabitants = l;
	}
	
	@Override
	public double getCost() {
		return COST;
	}

	@Override
	public void action() throws Exception {
		Random r = new Random();
		
		ArrayList<Inhabitant> listOfIn = listOfInhabitants.getInhabitants();
		
		// if receiver has enough money AND random > 7 (40%)
		
		if(this.getReceiver().getBankAccount().checkDebit((COST+FOOLTAX)*listOfIn.size())) {
			if(r.nextInt(10) > 6) {
				for(Inhabitant hab : listOfIn) {
					this.getReceiver().sendLetter(new BillOfExchange(hab, this.getReceiver(), new Money(FOOLTAX)));
				}
				listOfIn.remove(0);
				listOfIn.add(this.getReceiver());
				
				for(int i = 0; i < 10; i++) {
					Inhabitant inhabitant = this.getReceiver().getCity().getRandomInhabitant();
					this.getReceiver().sendLetter(new FoolLetter(inhabitant, this.getReceiver(), new ListOfInhabitants(listOfIn)));	
					}	
			} 
			} else {
				throw new Exception("error money");
			}
			
		}
		

	@Override
	public String toString() {
		String returnText = "";
		for(Inhabitant inhabitant : listOfInhabitants.getInhabitants()) {
			returnText += " " + inhabitant.getName() + " ";
		}
		
		return "Fool Letter (" + returnText + ")";
	}
	
}
