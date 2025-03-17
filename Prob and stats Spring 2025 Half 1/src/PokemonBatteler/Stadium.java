package PokemonBatteler;

import java.util.Random;

public class Stadium {

	Random rand = new Random();
	
	/**
	 * Make Pokemon 1 battle Pokemon 2
	 * @param p1 Pokemon 1
	 * @param p2 Pokemon 2
	 * @return The winner of the battle
	 */
	public Pokemon battle(Pokemon p1, Pokemon p2) {
		Pokemon first = getFirstPokemon(p1, p2);
		Pokemon second;
		if (p1.equals(first)) {
			second = p2;
		} else {
			second = p1;
		}
		while (p1.getHp() > 0 && p2.getHp() > 0) {
			first.attack(second);
			if (first.getHp() <= 0) {
				return second;
			}
			second.attack(first);
		}
		return first;
	}

	/**
	 * A helper method to get the first Pokemon based on their speeds
	 * @param p1 Pokemon 1
	 * @param p2 Pokemon 2
	 * @return The quicker Pokemon
	 */
	private Pokemon getFirstPokemon(Pokemon p1, Pokemon p2) {
		if (p1.getSpeed() > p2.getSpeed()) {
			return p1;
		} else if (p2.getSpeed() > p1.getSpeed()) {
			return p2;
		} else {
			if (rand.nextInt(1) == 0) {
				return p1;
			} else {
				return p2;
			}
		}
	}
}
