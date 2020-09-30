package fil.coo.city;

public class BankAccount {

	Inhabitant owner;
	double amount;
	
	public BankAccount(Inhabitant owner) {
		this(owner, 0);
	}
	
	public BankAccount(Inhabitant owner, double amount) {
		this.owner = owner;
		this.amount = amount;
	}
	
	/**
	 * 
	 * @param amount
	 * @throws Exception
	 * Subtract amount to bankAccount's inhabitant
	 * 
	 */
	
	public void debit(double amount) throws Exception{
		if(checkDebit(amount)) {
			this.amount -= amount;	
		} else {
			throw new Exception("No such money");
		}
	}

	/**
	 * 
	 * @param amount
	 * @return boolean
	 * check if the current balance of the inhabitant is high enough to pay a param
	 */
	public boolean checkDebit(double amount){
		if(this.amount - amount < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 
	 * @param amount
	 * add (amount) money to the current balance of the inhabitant (negative amount not allowed)
	 * 
	 */
	
	public void credit(double amount){
		if(amount >= 0) {
			this.amount += amount;
		}
	}

	public Inhabitant getOwner() {
		return owner;
	}

	public double getAmount() {
		return amount;
	}

	
	
	
	
}
