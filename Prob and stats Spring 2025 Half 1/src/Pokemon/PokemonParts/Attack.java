package Pokemon.PokemonParts;

import Pokemon.Cards.Energy;

public class Attack implements Move {

	private String name;
	private Action action;
	private Energy[] cost;

	public Attack(String name, Action action, Energy[] cost) {
		this.name = name;
		this.action = action;
		this.cost = cost;
	}
	
	public Action getAction() {
		return action;
	}

	public String getName() {
		return name;
	}
	
	public Energy[] getCost() {
		return cost;
	}
}
