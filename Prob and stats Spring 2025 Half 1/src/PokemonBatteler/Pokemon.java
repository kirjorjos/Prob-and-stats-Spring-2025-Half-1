package PokemonBatteler;

public class Pokemon {

	private int hp;
	private int attack;
	private int defense;
	private int spAttack;
	private int spDefense;
	private int speed;
	
	/**
	 * A new Pokemon with base stats
	 */
	public Pokemon() {
		setHp(35);
		setAttack(55);
		setDefense(30);
		setSpAttack(50);
		setSpDefense(40);
		setSpeed(90);
	}
	
	/**
	 * A new Pokemon
	 * @param hp The health
	 * @param attack The attack power
	 * @param defense The defense
	 * @param spAttack The special attack power
	 * @param spDefense The special defense power
	 * @param speed The speed
	 */
	public Pokemon(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
		this.setHp(hp);
		this.setAttack(attack);
		this.setDefense(defense);
		this.setSpAttack(spAttack);
		this.setSpDefense(spDefense);
		this.setSpeed(speed);
	}
	
	/**
	 * Get the hp
	 * @return The hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Set the hp
	 * @param hp The hp
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
	 * Get the attack power
	 * @return The attack power
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Set the attack power
	 * @param attack The attack power
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Get the defense
	 * @return The defense
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * Set the defense
	 * @param defense The defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
 
	/**
	 * Get the special attack power
	 * @return The special attack power
	 */
	public int getSpAttack() {
		return spAttack;
	}

	/**
	 * Set the special attack power
	 * @param spAttack The special attack power
	 */
	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}

	/**
	 * Get the special defense
	 * @return The special defense
	 */
	public int getSpDefense() {
		return spDefense;
	}

	/**
	 * Set the special defense
	 * @param spDefense The special defense
	 */
	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}

	/**
	 * Get the speed
	 * @return The speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Set the speed
	 * @param speed The speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
 
	/**
	 * Attack another Pokemon
	 * @param toAttack The Pokemon to attack
	 */
	public void attack(Pokemon toAttack) {
		toAttack.setHp(toAttack.getHp()-(toAttack.getDefense()));
	}
}
