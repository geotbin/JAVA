package letters;

import content.MockContent;
import fil.coo.city.Inhabitant;
import fil.coo.letters.Letter;

public class MockLetter extends Letter<MockContent> {

	public static final double COST = 1;
	
	public MockLetter(Inhabitant receiver, Inhabitant sender, MockContent content) {
		super(receiver,sender, content);
	}

	@Override
	public double getCost() {
		return COST;
	}

	@Override
	public void action() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}