package Pokemon.Cards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck {

	private Stack<Card> deck;
	private Random rand;

	private Deck(Stack<Card> deck) {
		this.deck = deck;
		rand = new Random();
	}
	
	@SuppressWarnings("unchecked")	//some things are checked but IDE won't see it
	public static Deck generateDeck(Object ...userInput) {
		Stack<Card> deck = new Stack<Card>();
		Class<?>  temp;
		String[] packagePaths = {"Pokemon.Cards.EnergyTypes", "Pokemon.Cards.PokemonTypes", "Pokemon.Cards.TrainerCards"};
		for (int i = 1; i < userInput.length; i+=2) {
			int failCount = 0;
			Class<Card> toAdd = null;
			String simpleClassName = (String) userInput[i-1];
			if (!(userInput[i] instanceof Integer)) throw new Error(userInput[i] + "is not a number.");
			// find the class given the simple name
			for (String path : packagePaths) {
				try {
					temp = Class.forName(path+"."+simpleClassName);
					if (!Card.class.isAssignableFrom(temp)) {
					    throw new Error("Make sure you're only adding cards to the deck");
					}
					toAdd = (Class<Card>) temp;
				} catch (ClassNotFoundException e) {
					failCount++;
					//if none of the tries find the class
					if (failCount == packagePaths.length) throw new Error("Make sure " + simpleClassName + " is implemented.");
				}
			}
			
			for (int j = 0; j < (Integer)userInput[i]; j++) {
				Card card = null;
				try {
					card = (Card) toAdd.getConstructors()[0].newInstance();
				} catch (Exception e) {
					throw new Error("Card " + toAdd.getName() + " is missing default constructor");
				}
				deck.add(card);
			}
		}
		if (deck.size() != 60) throw new Error("Deck must have 60 cards");
		return new Deck(deck);
	}
	
	public void shuffle() {
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
		shuffle();
	}
	
	public ArrayList<Card> draw(int cards) {
		ArrayList<Card> temp = new ArrayList<Card>();
		for (int i = 0; i < cards; i++) {
			if (!deck.empty()) temp.add(deck.pop());
		}
		return temp;
	}
}
