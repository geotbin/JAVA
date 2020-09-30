package fil.coo.letters;


import fil.coo.city.*;
import fil.coo.letters.content.Content;

public abstract class Letter<C extends Content> implements Content {

	private Inhabitant receiver;
	private Inhabitant sender;
	private C content;
	
	public Letter(Inhabitant r, Inhabitant s, C content) {
		this.receiver = r;
		this.sender = s;
		this.content = content;
	}
	
	
	public Inhabitant getReceiver() {
		return this.receiver;
	}
	
	
	
	public Inhabitant getSender() {
		return this.sender;
	}

	public C getContent() {
		return content;
	}


	public abstract double getCost();
	public abstract void action() throws Exception;
	
	
	public String getInfos() {
		String description = "| Sender: " + this.sender.getName() + '\n' + "| Receiver: " + this.receiver.getName() + "\n";
		description += "| Infos: " + this.toString() + "\n---"; 
		return description;
	}
	
	
	
	
	
}
