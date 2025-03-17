package Pokemon;

import Pokemon.Cards.Deck;
import Pokemon.Cards.Player;

public class TestPokemon {
	
	public static void main(String[] args) {
		Player player1 = new Player("Player 1", Deck.generateDeck("Pikachu", 4, "ElectricEnergy", 56), false);
		Player player2 = new Player("Player 2", Deck.generateDeck("Pikachu", 1, "ElectricEnergy", 59), true);
		Runner runner = new Runner();
		Player winner = runner.run(player1, player2);
		System.out.println("The winner is: " + winner);
	}
}
