package Pokemon.MonteCarlo;

import Pokemon.Cards.Deck;
import Pokemon.Cards.Player;

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
		Player player = new Player("Player 1", Deck.generateDeck("Pikachu", pokemonNumber, "Fire Energy", 60-pokemonNumber), true);
		if (player.drawHand() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
