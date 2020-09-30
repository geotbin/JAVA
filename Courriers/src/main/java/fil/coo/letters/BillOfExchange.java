package fil.coo.letters;

import fil.coo.city.Inhabitant;
import fil.coo.letters.content.*;

public class BillOfExchange extends Letter<Money>{
	
	public final double tax = 0.01;
	public static final double COST = 1;
	public double amount;
	
	public BillOfExchange(Inhabitant r, Inhabitant s, Money m) {
		super(r, s, m);
		this.amount = m.getMoney();
	}
	
	@Override
	public double getCost() {
		return (COST + (this.getContent().getMoney() * tax));
	}

	@Override
	public void action() throws Exception{
		this.getSender().getBankAccount().debit(this.getContent().getMoney());
		this.getReceiver().getBankAccount().credit(this.getContent().getMoney());
		
		try {
			this.getReceiver().sendLetter(new ThanksLetter(this.getSender(), this.getReceiver(), new Text("Thanks for the money")));
		}catch (Exception e) {
			throw new Exception("can't send thanks letter");
		}
	}

	@Override
	public String toString() {
		return "Bill Of Exchange(" + amount + "€)";
	}
	
	
}
