package Pokemon.PokemonParts;

import Pokemon.Cards.Pokemon;

public interface Action {
	void run(Pokemon currentPokemon, Pokemon targetPokemon);
}
