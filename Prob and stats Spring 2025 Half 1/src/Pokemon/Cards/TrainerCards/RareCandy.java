package Pokemon.Cards.TrainerCards;

import Pokemon.Cards.Card;
import Pokemon.Cards.Pokemon;

public class RareCandy extends Card {

	/**
	 * Check if the target card is a valid target for rare candy to be used on
	 * @param base The target card
	 * @param evolution The card in hand you're attempting to evolve with
	 * @return If the card is valid or not
	 */
	public boolean isValidTarget(Card base, Card evolution) {
		if (!(base instanceof Pokemon)) return false;
		// if the evolution isn't in the same chain as the base, return false
		Pokemon pokemon = (Pokemon) base;
		if (pokemon.getStage() == 0 && pokemon.getBenchTurns() > 0) return true;
		return false;
	}
	
	/**
	 * Activate the rare candy
	 * @param base The base card
	 * @param evolution
	 * @return
	 */
	public Pokemon activate(Pokemon base, Pokemon evolution) {
		return base.evolve(evolution);
	}
}
