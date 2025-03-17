package Pokemon.Cards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import Pokemon.Cards.PokemonTypes.Pikachu;

public class Player {

	private String name;
	private Deck deck;
	private static Random rand = new Random();
	private ArrayList<Card> hand;
	private int hp;
	private Pokemon activePokemon;
	private ArrayList<Pokemon> bench;
	private Card[] prizes;
	private Player opponent;
	private boolean automatic;

	/**
	 * A new player
	 * @param name The name of the player
	 * @param deck The deck the player should use
	 * @param automatic If the player should be played automatically or if the user should be prompted for input via Scanner
	 */
	public Player(String name, Deck deck, boolean automatic) {
		this.name = name;
		this.deck = deck;
		this.automatic = automatic;
		bench = new ArrayList<Pokemon>();
		hand = new ArrayList<Card>();
		prizes = new Card[6];
	}

	/**
	 * If the player is alive
	 * @return If the player is alive
	 */
	public boolean isAlive() {
		return (hp <= 0);
	}

	/**
	 * Draw the initial hand
	 * @return The number of times it took to get a Pokemon
	 */
	public int drawHand() {
		int opponentCards = -1;
		while (!handContainsPokemon()) {
			opponentCards++;
			deck.shuffleIntoDeck(hand);
			hand = deck.draw(7);
		}
		return opponentCards;
	}
	
	/**
	 * If the hand contains a Pokemon or not
	 * @return If the hand contains a Pokemon or not
	 */
	public boolean handContainsPokemon() {
	    for (Card card : hand) {
	        if (card instanceof Pokemon) {
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 * Flip a coin
	 * @return The result of the flip
	 */
	public int flipCoin() {
		return rand.nextInt(1);
	}

	/**
	 * Draw the prize pool
	 */
	public void drawPrizePool() {
		prizes = (Card[]) deck.draw(6).toArray(new Card[6]);
	}
	
	/**
	 * Get the prize pool
	 * @return The prize pool
	 */
	public Card[] getPrizePool() {
		return prizes.clone();
	}

	/**
	 * Get the active Pokemon
	 * @return The active Pokemon
	 */
	public Pokemon getActivePokemon() {
		return activePokemon;
	}
	
	/**
	 * Set the active Pokemon
	 * @param pokemon The Pokemon to make active
	 */
	public void setActivePokemon(Pokemon pokemon) {
		activePokemon = pokemon;
	}

	/**
	 * Take a turn
	 * @param isFirstTurn If this is the first turn this player had or not
	 */
	public void takeTurn(boolean isFirstTurn) {
		deck.draw(1);
		Pokemon pokemon = null;
		for (Pokemon p : bench) {
			p.increaseBenchTurns();
		}
		for (Card card : hand) {
			if (card instanceof Pokemon) {
				pokemon = (Pokemon) card;
				if (bench.size() <= 5 && pokemon.getStage() == 0) bench.add(pokemon);
			}
		}
		playPokemon(pokemon);
		for (Card card : hand) {
			if (card instanceof Energy) {
				activePokemon.attachEnergy((Energy) card);
			}
		}
		
		if (!isFirstTurn) {
			attack();
		}
	}
	
	/**
	 * Attack the opponent
	 */
	private void attack() {
		activePokemon.attack(opponent.getActivePokemon());
	}

	/**
	 * Set the opponent
	 * @param opponent The opponent
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/**
	 * Play a Pokemon
	 * @param pokemon The Pokemon to play
	 * @return If it was allowed to be played or not
	 */
	private boolean playPokemon(Pokemon pokemon) {
		if (activePokemon != null) return false;
		setActivePokemon(pokemon);
		return true;
	}
	
	/**
	 * Override the toString method to return the player name
	 */
	public String toString() {
		return name;
	}

	/**
	 * Get the hand the player has
	 * @return The hand
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	/**
	 * Draw x cards off the top of the deck
	 * @param cards How many cards to draw
	 */
	public void draw(int cards) {
		hand.addAll(deck.draw(cards));
	}
}