package Pokemon.Cards;

import java.util.ArrayList;
import Pokemon.Cards.PokemonTypes.PokemonTypes;

public class Pokemon extends Card {
	private int hp;
	private int attack;
	private int defense;
	private ArrayList<PokemonTypes> resistanceTypes;
	private int resistance;
	private ArrayList<PokemonTypes> weaknessTypes;
	private PokemonTypes type;
	private ArrayList<Energy> energy;
	private int stage;
	private int maxHp;
	private int turnsOnBench;

	/**
	 * A new base Pokemon
	 * @param maxHp The maximum HP this Pokemon has
	 * @param attack The base attack damage of this Pokemon
	 * @param defense The base defense of this Pokemon
	 * @param resistanceTypes The resistance types of this Pokemon
	 * @param resistance The resistance this Pokemon has against its resistance types
	 * @param weaknessTypes The weakness types of this Pokemon
	 * @param type The type of this Pokemon
	 * @param stage Either 0, 1, or 2: what stage of evolution this Pokemon is
	 */
	public Pokemon(int maxHp, int attack, int defense, ArrayList<PokemonTypes> resistanceTypes, int resistance, ArrayList<PokemonTypes> weaknessTypes, PokemonTypes type, int stage) {
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.resistanceTypes = resistanceTypes;
		this.resistance = resistance;
		this.weaknessTypes = weaknessTypes;
		this.type = type;
		this.energy = new ArrayList<Energy>();
		this.stage = stage;
		turnsOnBench = 0;
	}

	/**
	 * Evolve a Pokemon
	 * @param evolution The Pokemon to evolve it into
	 * @return The evolved Pokemon or null if it hasn't been on the bench long enough
	 */
	public Pokemon evolve(Pokemon evolution) {
		if (turnsOnBench <= 0) return null;
		for (Energy e : energy) {
			evolution.attachEnergy(e);
		}
		evolution.setHp(evolution.getMaxHp() - (maxHp - hp));
		return evolution;
	}

	/**
	 * Get the maximum hp of the Pokemon
	 * @return The maximum HP of the Pokemon
	 */
	private int getMaxHp() {
		return maxHp;
	}

	/**
	 * Get the hp of the Pokemon
	 * @return The current HP of the Pokemon
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Set the hp of the Pokemon
	 * @param hp The HP value
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Get the attack value of the Pokemon
	 * @return The attack value
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Set the attack value of the Pokemon
	 * @param attack The attack value
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * Get the defense value of the Pokemon
	 * @return The defense value
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Set the defense value of the Pokemon
	 * @param defense The defense value
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * Get the resistance types of the Pokemon
	 * @return A list of resistance types
	 */
	public ArrayList<PokemonTypes> getResistanceTypes() {
		return resistanceTypes;
	}

	/**
	 * Set the resistance types of the Pokemon
	 * @param resistanceTypes The resistance types
	 */
	public void setResistanceTypes(ArrayList<PokemonTypes> resistanceTypes) {
		this.resistanceTypes = resistanceTypes;
	}

	/**
	 * Get the resistance types of the Pokemon
	 * @return The resistance value
	 */
	public int getResistance() {
		return resistance;
	}

	/**
	 * Set the resistance types of the Pokemon
	 * @param resistance The resistance types
	 */
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	/**
	 * Get the weakness types of the Pokemon
	 * @return A list of weakness types
	 */
	public ArrayList<PokemonTypes> getWeaknessTypes() {
		return weaknessTypes;
	}

	/**
	 * Set the weakness types of the Pokemon
	 * @param weaknessTypes The new weakness types
	 */
	public void setWeaknessTypes(ArrayList<PokemonTypes> weaknessTypes) {
		this.weaknessTypes = weaknessTypes;		
	}

	/**
	 * Get the type of the Pokemon
	 * @return The type of the Pokemon
	 */
	public PokemonTypes getType() {
		return type;
	}

	/**
	 * Set the type of the Pokemon
	 * @param type The new type
	 */
	public void setType(PokemonTypes type) {
		this.type = type;
	}

	/**
	 * Attack the given Pokemon
	 * @param toAttack The Pokemon to attack
	 */
	public void attack(Pokemon toAttack) {
		int damage = attack;
		if (toAttack.getWeaknessTypes().contains(type)) {
			damage *= 2;
		}
		if (toAttack.getResistanceTypes().contains(type)) {
			damage -= toAttack.getResistance();
		}
		toAttack.setHp(toAttack.getHp() - damage);
	}

	/**
	 * Attach an energy card to this Pokemon
	 * @param card The energy card to attach
	 */
	public void attachEnergy(Energy card) {
		energy.add(card);
	}

	/**
	 * Get the evolution stage of the Pokemon
	 * @return The stage (0, 1, or 2)
	 */
	public int getStage() {
		return stage;
	}

	/**
	 * Increase the number of turns this Pokemon has been on the bench
	 */
	public void increaseBenchTurns() {
		turnsOnBench++;
	}

	/**
	 * Get the number of turns this Pokemon has been on the bench
	 * @return The number of turns
	 */
	public int getBenchTurns() {
		return turnsOnBench;
	}
}