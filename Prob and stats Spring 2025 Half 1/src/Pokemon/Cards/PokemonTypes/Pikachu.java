package Pokemon.Cards.PokemonTypes;

import java.util.ArrayList;

import Pokemon.Cards.Pokemon;

public class Pikachu extends Pokemon {

	public Pikachu() {
		//	hp, attack, defense, resistance types, resistance, weakness types, type
		super(35, 55, 30, getInitialResistanceTypes(), 20, getInitialWeaknessTypes(), PokemonTypes.ELECTRIC, 0);
	}
	
	/**
	 * A helper method to return an ArrayList of the initial resistance types
	 * @return The ArrayList of resistance types
	 */
	private static ArrayList<PokemonTypes> getInitialResistanceTypes() {
		ArrayList<PokemonTypes> temp = new ArrayList<PokemonTypes>();
		temp.add(PokemonTypes.METAL);
		return temp;
	}
	
	/**
	 * A helper method to return an ArrayList of the initial weakness types
	 * @return The ArrayList of weakness types
	 */
	private static ArrayList<PokemonTypes> getInitialWeaknessTypes() {
		ArrayList<PokemonTypes> temp = new ArrayList<PokemonTypes>();
		temp.add(PokemonTypes.FIGHTING);
		return temp;
	}
}