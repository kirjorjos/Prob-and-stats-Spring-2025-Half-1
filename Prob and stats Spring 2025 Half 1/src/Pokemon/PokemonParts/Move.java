package Pokemon.PokemonParts;

import Pokemon.Cards.Energy;

public interface Move {

	public String getName();

	public Action getAction();
	
	public Energy[] getCost();
}
