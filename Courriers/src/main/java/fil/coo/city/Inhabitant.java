package fil.coo.city;

import fil.coo.letters.Letter;

public class Inhabitant {
	
	private String name;
	private City city;
	private BankAccount ba;
	
	public Inhabitant(String name, City city, double amount) {
		this.name = name;
		this.city = city;
		this.ba = new BankAccount(this, amount);
	}
	
	/**
	 * @param l
	 * @throws Exception
	 * throw action when letter is received
	 */
	public void receiveLetter(Letter<?> l) throws Exception {
		l.action();
	}

	
	/**
	 * @param letter
	 * @throws Exception
	 * send a letter (pay, add letter to mailbox)
	 */
	public void sendLetter(Letter<?> letter) throws Exception {
		if (isPossibleToSend(letter)) { 
			
			System.out.println(letter.getInfos());
			this.getBankAccount().debit(letter.getCost());
			this.city.addLetter(letter);
			
		} else {
			throw new Exception("no such money");
		}
	}
	
	/**
	 * @param l
	 * @return
	 * check if the letter is possible to send (enough money)
	 */
	public boolean isPossibleToSend(Letter<?> l) {
		return (this.getBankAccount().getAmount() >= l.getCost());
	}
	
	
	public BankAccount getBankAccount() {
		return ba;
	}

	public City getCity() {
		return city;
	}


	public String getName() {
		return name;
	}

	
	
	

}
