package Pokemon.Cards;

public class Trainer extends Card {
	private String name;
	
	public Trainer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
