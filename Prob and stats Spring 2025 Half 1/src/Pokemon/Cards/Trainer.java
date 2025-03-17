package Pokemon.Cards;

public class Trainer extends Card {
	private String name;
	
	/**
	 * A new trainer
	 * @param name The name of the trainer
	 */
	public Trainer(String name) {
		this.name = name;
	}
	
	/**
	 * Get the name of the trainer
	 * @return The name of the trainer
	 */
	public String getName() {
		return name;
	}
}
