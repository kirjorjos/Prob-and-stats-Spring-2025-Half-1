package Pokemon;

import Pokemon.Cards.Player;

public class Runner {

	/**
	 * The main run method
	 * @param player1 Player 1
	 * @param player2 Player 2
	 * @return The winner of the game
	 */
	public Player run(Player player1, Player player2) {
		Player[] players = {player1, player2};
		Game game = new Game(players);
		while (game.isRunning()) {
			game.update();
		}
		return game.getWinner();
	}
}
