package BirthdayProgram;

import java.util.Random;

// Gian is a person

public class Person {
	private Random rand = new Random();
	private int birthday;
	
	/**
	 * A person with a random Birthday
	 * @param rand A random number generator
	 */
	public Person() {
		birthday = rand.nextInt(365);
	}
	
	/**
	 * A person with a set birthday
	 * @param birthday What 0-based numeric day of the year the birthday is
	 */
	public Person(int birthday) {
		this.birthday = birthday;
	}

	/**
	 * Get the person's birthday
	 * @return The birthday as a 0-based numbered day of the year
	 */
	public int getBirthday() {
		return birthday;
	}
	
	/**
	 * Set the birthday for a person
	 * @param birthday The birthday as a 0-based numbered day of the year
	 */
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
}
