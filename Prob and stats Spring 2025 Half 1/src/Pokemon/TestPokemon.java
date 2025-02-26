package Pokemon;

import Pokemon.Cards.Player;

public class TestPokemon {
	
	public static void main(String[] args) {
		Player player1 = new Player("Player 1", Player.generateDeck(4, 56));
		Player player2 = new Player("Player 2", Player.generateDeck(4, 56));
		Runner runner = new Runner();
		Player winner = runner.run(player1, player2);
		System.out.println("The winner is: " + winner);
	}
}
