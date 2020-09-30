package fil.coo.letters.content;

public class Text implements Content{

	private String text;
	
	public Text(String text) {
		this.text = text;
	}
	
	public String toString() {
		return "Message: " + this.text;
		
	}
}
