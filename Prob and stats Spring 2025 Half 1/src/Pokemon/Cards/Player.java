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

	public Player(String name, Deck deck, boolean automatic) {
		this.name = name;
		this.deck = deck;
		this.automatic = automatic;
		bench = new ArrayList<Pokemon>();
		hand = new ArrayList<Card>();
		prizes = new Card[6];
	}

	public boolean isAlive() {
		return (hp <= 0);
	}

	public int drawHand() {
		int opponentCards = -1;
		while (!handContainsPokemon()) {
			opponentCards++;
			deck.shuffleIntoDeck(hand);
			hand = deck.draw(7);
		}
		return opponentCards;
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
		prizes = (Card[]) deck.draw(6).toArray(new Card[6]);
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

	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public void draw(int cards) {
		hand.addAll(deck.draw(cards));
	}
}