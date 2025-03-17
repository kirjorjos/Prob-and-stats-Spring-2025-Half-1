package Pokemon.Cards;

public class Energy extends Card {
	private String element;
	
	/**
	 * A basic energy
	 * @param element The type of energy this is
	 */
	public Energy(String element) {
		this.element = element;
	}
	
	/**
	 * Get the type of energy this is
	 * @return The type of energy
	 */
	public String getElement() {
		return element;
	}
}
