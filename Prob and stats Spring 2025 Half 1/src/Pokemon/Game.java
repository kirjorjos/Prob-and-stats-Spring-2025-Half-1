package Pokemon;

import Pokemon.Cards.Player;

public class Game {
	
	private boolean isRunning;
	private Player player1;
	private Player player2;
	private boolean evenTurn;
	private boolean isFirstTurn;
	
	/**
	 * A new game
	 * @param players The players in the game
	 */
	public Game(Player[] players) {
		isRunning = true;
		player1 = players[0];
		player2 = players[1];
		evenTurn = true;
		isFirstTurn = true;
		setupGame();
	}
	
	/**
	 * Set up the game
	 */
	private void setupGame() {
		int player2BonusCards = player1.drawHand();
		int player1BonusCards = player2.drawHand();
		player1.draw(player1BonusCards);
		player2.draw(player2BonusCards);
		player1.drawPrizePool();
		player2.drawPrizePool();
		player1.setOpponent(player2);
		player2.setOpponent(player1);
	}

	/**
	 * Get the winner of the game
	 * @return The winner
	 */
	public Player getWinner() {
		Player temp1 = checkLifeWinner();
		Player temp2 = checkPrizeWinner();
		Player temp3 = checkPokemonCount();
		if (temp1 != null) return temp1;
		if (temp2 != null) return temp2;
		if (temp3 != null) return temp3;
		return null;
	}

	/**
	 * If the game is running
	 * @return If the game is running
	 */
	public boolean isRunning() {
		return isRunning;
	}
	
	/**
	 * Check if there's a winner based on life
	 * @return The winner if there is one, null if not
	 */
	private Player checkLifeWinner() {
		if (player1.isAlive()) {
			if (player2.isAlive()) {
				return null;
			} else {
				return player1;
			}
		}
		return player2;
	}
	
	/**
	 * Check if there's a winner based on prize pool
	 * @return The winner if there is one, null if not
	 */
	private Player checkPrizeWinner() {
		if (player2.getPrizePool().length != 0) {
			if (player2.getPrizePool().length != 0) {
				return null;
			} else {
				return player1;
			}
		}
		return player2;
	}
	
	/**
	 * Check if there's a winner based on Pokemon count
	 * @return The winner if there is one, null if not
	 */
	private Player checkPokemonCount() {
		if (player2.getActivePokemon() == null && !player2.handContainsPokemon()) {
			if (player2.getActivePokemon() != null && player2.handContainsPokemon()) {
				return null;
			} else {
				return player1;
			}
		}
		return player2;
	}

	/**
	 * The main update method
	 */
	public void update() {
		if (evenTurn) {
			player1.takeTurn(isFirstTurn);
		} else {
			player2.takeTurn(isFirstTurn);
		}
		isFirstTurn = false;
		evenTurn  = !evenTurn;
		if (getWinner() != null) {
			isRunning = false;
		}
	}

}
