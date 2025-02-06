package Pokemon;

public class Pokemon {
	private int hp;
	private int attack;
	private int defense;
	private int spAttack;
	private int spDefense;
	private int speed;
	
	public Pokemon() {
		setHp(35);
		setAttack(55);
		setDefense(30);
		setSpAttack(50);
		setSpDefense(40);
		setSpeed(90);
	}
	
	public Pokemon(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
		this.setHp(hp);
		this.setAttack(attack);
		this.setDefense(defense);
		this.setSpAttack(spAttack);
		this.setSpDefense(spDefense);
		this.setSpeed(speed);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpAttack() {
		return spAttack;
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}

	public int getSpDefense() {
		return spDefense;
	}

	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void attack(Pokemon toAttack) {
		toAttack.setHp(toAttack.getHp()-(toAttack.getDefense()));
	}
}
