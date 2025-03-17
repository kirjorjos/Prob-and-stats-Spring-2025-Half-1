package Pokemon.PokemonParts;

import Pokemon.Cards.Energy;

public interface Move {

	/**
	 * Get the name of this move
	 * @return The name
	 */
	public String getName();

	/**
	 * Get the function associated with this move
	 * @return The function
	 */
	public Action getAction();
	
	/**
	 * Get the cost of this move
	 * @return The cost
	 */
	public Energy[] getCost();
}
