package Pokemon.Cards;

import java.util.ArrayList;

public class Pokemon extends Card {
	private int hp;
	private int attack;
	private int defense;
	private ArrayList<String> resistanceTypes;
	private int resistance;
	private ArrayList<String> weaknessTypes;
	private String type;
	private ArrayList<Energy> energy;
	
	public Pokemon(int hp, int attack, int defense, ArrayList<String> resistanceTypes, int resistance, ArrayList<String> weaknessTypes, String type) {
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.resistanceTypes = resistanceTypes;
		this.resistance = resistance;
		this.weaknessTypes = weaknessTypes;
		this.type = type;
		this.energy = new ArrayList<Energy>();
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
	
	public ArrayList<String> getResistanceTypes() {
		return resistanceTypes;
	}
	
	public void setResistanceTypes(ArrayList<String> resistanceTypes) {
		this.resistanceTypes = resistanceTypes;
	}
	
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	
	public ArrayList<String> getWeaknessTypes() {
		return weaknessTypes;
	}
	
	public void setWeaknessTypes(ArrayList<String> weaknessTypes) {
		this.weaknessTypes = weaknessTypes;		
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
		
	}
	
	public void attack(Pokemon toAttack) {
		int damage = attack;
		if (toAttack.getWeaknessTypes().contains(type)) {
			damage*=2;
		}
		if (toAttack.getResistanceTypes().contains(type)) {
			damage-=toAttack.getResistance();
		}
		toAttack.setHp(toAttack.getHp()-damage);
	}

	public void attachEnergy(Energy card) {
		energy.add(card);
	}
}
