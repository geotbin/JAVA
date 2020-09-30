package fil.coo.decoratorLetters;

import fil.coo.letters.Letter;

public abstract class AbstractDecoratorLetter<T extends Letter<?>> extends Letter<T> {


	protected Letter<T> letter;
	

	public AbstractDecoratorLetter(T letter) {
		super(letter.getSender(), letter.getReceiver(), letter);
	}


	public void action() throws Exception {
		this.getContent().action();
	}
	
	
}