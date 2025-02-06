package Pokemon;

import java.util.Random;

public class Stadium {

	Random rand = new Random();
	
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
