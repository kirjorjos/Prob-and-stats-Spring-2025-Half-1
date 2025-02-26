package Pokemon.MonteCarlo;

import java.util.Stack;

import Pokemon.Cards.Card;
import Pokemon.Cards.Energy;
import Pokemon.Cards.Player;
import Pokemon.Cards.RareCandy;
import Pokemon.Cards.PokemonTypes.Charmander;

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
		Stack<Card> deck = new Stack<Card>();
		Player player;
		for (int i = 0; i < 4; i++) {
			deck.add(new Charmander());
		}
		for (int i = 0; i < rareCandy; i++) {
			deck.add(new RareCandy());
		}
		for (int i = 0; i < (56-rareCandy); i++) {
			deck.add(new Energy("Fire"));
		}
		player = new Player("Player 1", deck);
		player.drawHand();
		player.drawPrizePool();
		for (Card card : deck) {
			if (card instanceof RareCandy) {
				return 0;
			}
		}
		return 1;
	}
}
