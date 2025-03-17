package Pokemon.PokemonParts;

import Pokemon.Cards.Energy;

public class Attack implements Move {

	private String name;
	private Action action;
	private Energy[] cost;

	/**
	 * A new attack
	 * @param name The name of the attack
	 * @param action A function for what it does
	 * @param cost The energy cost of the attack
	 */
	public Attack(String name, Action action, Energy[] cost) {
		this.name = name;
		this.action = action;
		this.cost = cost;
	}
	
	/**
	 * Get the function associated with this attack
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Get the name of this attack
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the cost of this attack
	 */
	public Energy[] getCost() {
		return cost;
	}
}
