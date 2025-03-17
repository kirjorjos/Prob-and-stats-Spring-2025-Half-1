package Pokemon.Cards.PokemonTypes;

import java.util.ArrayList;

import Pokemon.Cards.Pokemon;

public class Charmander extends Pokemon {

    public Charmander() {
        //  hp, attack, defense, resistance types, resistance, weakness types, type
        super(39, 52, 43, getInitialResistanceTypes(), 20, getInitialWeaknessTypes(), PokemonTypes.FIRE, 0);
    }

    /**
     * A helper method to return an ArrayList of the initial resistance types
     * @return The ArrayList of resistance types
     */
    private static ArrayList<PokemonTypes> getInitialResistanceTypes() {
        ArrayList<PokemonTypes> temp = new ArrayList<PokemonTypes>();
        temp.add(PokemonTypes.GRASS);
        return temp;
    }

    /**
     * A helper method to return an ArrayList of the initial weakness types
     * @return The ArrayList of weakness types
     */
    private static ArrayList<PokemonTypes> getInitialWeaknessTypes() {
        ArrayList<PokemonTypes> temp = new ArrayList<PokemonTypes>();
        temp.add(PokemonTypes.WATER);
        return temp;
    }
}