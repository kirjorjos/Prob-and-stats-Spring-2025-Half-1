package Pokemon.MonteCarlo;

import java.util.Arrays;

import Pokemon.Cards.Card;
import Pokemon.Cards.Deck;
import Pokemon.Cards.Player;
import Pokemon.Cards.TrainerCards.RareCandy;

public class RareCandyTester {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			int timesMulliganed = 0;
			for (int j = 0; j < 10000; j++) {
				timesMulliganed += runSimulation(i+1);
			}
			System.out.printf("%d rare candy caused %d bricks across 10,000 runs for a chance of about %.2f%%\n", i+1, timesMulliganed, timesMulliganed/100f);
//			System.out.printf("%d, %.2f\n", i+1, timesMulliganed/100f);
		}
	}

	private static int runSimulation(int rareCandy) {
		int rareCandyCount = 0;
		Player player = new Player("Player 1", Deck.generateDeck("Pikachu", 4, "RareCandy", rareCandy, "FireEnergy", 56-rareCandy), true);
		player.drawHand();
		player.drawPrizePool();
		for (Card card : player.getPrizePool()) {
			if (card instanceof RareCandy) {
				rareCandyCount++;
				if (rareCandyCount >= 4) System.out.println(card);
			}
		}
		if (rareCandyCount == rareCandy) return 1;
		return 0;
	}
}
