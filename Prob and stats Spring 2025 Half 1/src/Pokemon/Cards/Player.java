package Pokemon.Cards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import Pokemon.Cards.PokemonTypes.Pikachu;

public class Player {

	private String name;
	private Stack<Card> deck;
	private static Random rand = new Random();
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int hp;
	private Pokemon activePokemon;
	private Card[] prizes = new Card[6];
	private Player opponent;

	public Player(String name, Stack<Card> deck) {
		this.name = name;
		this.deck = deck;
	}
	
	public static void shuffleDeck(Stack<Card> deck) {
		ArrayList<Card> tempDeck = new ArrayList<Card>(deck);
		while (!deck.isEmpty()) {
			deck.pop();
		}
		while (!tempDeck.isEmpty()) {
			Card card = tempDeck.get(rand.nextInt(tempDeck.size()));
			deck.push(card);
			tempDeck.remove(card);
		}
	}
	
	public void shuffleIntoDeck(ArrayList<Card> cards) {
		for (Card card : cards) {
			deck.add(card);
		}
		cards.clear();
		shuffleDeck(deck);
	}

	public boolean isAlive() {
		return (hp <= 0);
	}

	public int drawHand() {
		int opponentCards = -1;
		while (!handContainsPokemon()) {
			opponentCards++;
			shuffleIntoDeck(hand);
			draw(7);
		}
		return opponentCards;
	}

	public void draw(int cards) {
		for (int i = 0; i < cards; i++) {
			if (!deck.empty()) hand.add(deck.pop());
		}
	}
	
	public boolean handContainsPokemon() {
	    for (Card card : hand) {
	        if (card instanceof Pokemon) {
	            return true;
	        }
	    }
	    return false;
	}

	public int flipCoin() {
		return rand.nextInt(1);
	}

	public void drawPrizePool() {
		for (int i = 0; i < 6; i++) {
			prizes[i] = deck.pop();
		}
	}
	
	public Card[] getPrizePool() {
		return prizes.clone();
	}

	public Pokemon getActivePokemon() {
		return activePokemon;
	}
	
	public void setActivePokemon(Pokemon pokemon) {
		activePokemon = pokemon;
	}

	public void takeTurn(boolean isFirstTurn) {
		draw(1);
		Pokemon pokemon = null;
		findPokemon: for (Card card : hand) {
			if (card instanceof Pokemon) {
				pokemon = (Pokemon) card;
				break findPokemon;
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
	
	private void attack() {
		activePokemon.attack(opponent.getActivePokemon());
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	private boolean playPokemon(Pokemon pokemon) {
		if (activePokemon != null) return false;
		setActivePokemon(pokemon);
		return true;
	}
	
	public String toString() {
		return name;
	}

	public static Stack<Card> generateDeck(int pokemon, int energy) {
		Stack<Card> deck = new Stack<Card>();
		for (int i = 0; i < pokemon; i++) {
			deck.add(new Pikachu());
		}
		for (int i = 0; i < (60-pokemon); i++) {
			deck.add(new Energy("Fire"));
		}
		shuffleDeck(deck);
		return deck;
	}
}
