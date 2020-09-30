package fil.coo.letters.content;

public class Money implements Content{
	
	private double cost;
	
	public Money(double d) {
		this.cost = d;
	}
	
	public double getMoney() {
		return this.cost;
	}
	
	public String toString() {
		return "Money";
		
	}
}
