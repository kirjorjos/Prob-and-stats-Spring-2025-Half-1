package Pokemon;

import Pokemon.Cards.Player;

public class Runner {

	public Player run(Player player1, Player player2) {
		Player[] players = {player1, player2};
		Game game = new Game(players);
		while (game.isRunning()) {
			game.update();
		}
		return game.getWinner();
	}
}
