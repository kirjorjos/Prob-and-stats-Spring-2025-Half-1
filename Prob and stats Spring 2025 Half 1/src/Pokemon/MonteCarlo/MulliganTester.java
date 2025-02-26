package Pokemon.MonteCarlo;

import java.util.Stack;

import Pokemon.Cards.Card;
import Pokemon.Cards.Energy;
import Pokemon.Cards.Player;
import Pokemon.Cards.PokemonTypes.Pikachu;

public class MulliganTester {
	public static void main(String[] args) {
		for (int i = 0; i < 60; i++) {
			int timesMulliganed = 0;
			for (int j = 0; j < 10000; j++) {
				timesMulliganed += runSimulation(i+1);
			}
//			System.out.printf("%d cards mulliganed %d times across 10,000 runs for a chance of about %.2f%%\n", i, timesMulliganed, timesMulliganed/100f);
			System.out.printf("%d, %.2f\n", i+1, timesMulliganed/100f);
		}
	}

	private static int runSimulation(int pokemonNumber) {
		Stack<Card> deck = new Stack<Card>();
		Player player;
		for (int k = 0; k < pokemonNumber; k++) {
			deck.add(new Pikachu());
		}
		for (int k = 0; k < (60-pokemonNumber); k++) {
			deck.add(new Energy("Fire"));
		}
		player = new Player("Player 1", deck);
		if (player.drawHand() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
