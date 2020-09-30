package fil.coo.decoratorLetters;

import fil.coo.letters.Letter;

public class RegisteredLetter<T extends Letter<?>> extends AbstractDecoratorLetter<T>{

	public static final double TAX = 15; 
	
	public RegisteredLetter(T letter) {
		super(letter);
	}

	@Override
	public double getCost() {
		return this.getContent().getCost() + TAX;
	}


	
	@Override
	public void action() throws Exception {
		super.action();
	}
	
	public String toString() {
		return "Registered letter(" + this.getContent().toString() + ")";
	}
	
}
