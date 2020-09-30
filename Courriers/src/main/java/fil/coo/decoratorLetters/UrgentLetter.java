package fil.coo.decoratorLetters;

import fil.coo.letters.Letter;

public class UrgentLetter<T extends Letter<?>> extends AbstractDecoratorLetter<T> {

	public UrgentLetter(T letter) {
		super(letter);
	}

	@Override
	public double getCost() {
		return (this.getContent().getCost() * 2);
	}

	
	@Override
	public void action() throws Exception{
		super.action();
	}
	
	public String toString() {
		return "Urgent letter (" + this.getContent().toString() + ")";
	}

}
