package Pokemon.Cards.PokemonTypes;

import java.util.ArrayList;

import Pokemon.Cards.Pokemon;

public class Pikachu extends Pokemon {

	public Pikachu() {
		//	hp, attack, defense, resistance types, resistance, weakness types, type
		super(35, 55, 30, getInitialResistanceTypes(), 20, getInitialWeaknessTypes(), "Electric");
	}
	
	private static ArrayList<String> getInitialResistanceTypes() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Metal");
		return temp;
	}
	
	private static ArrayList<String> getInitialWeaknessTypes() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Fighting");
		return temp;
	}
}