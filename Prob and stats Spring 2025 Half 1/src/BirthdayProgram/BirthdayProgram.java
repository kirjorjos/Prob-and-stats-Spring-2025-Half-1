package BirthdayProgram;

import java.util.ArrayList;
import java.util.Scanner;


public class BirthdayProgram {

	static Scanner scanner = new Scanner(System.in);

	/**
	 * Get the class size from the user
	 * @param scanner The scanner used to grab user input
	 * @return The size of the class
	 */
	public static int getUserNumber(String prompt) {
		int classSize = -1;
		while (classSize == -1) {
			System.out.print(prompt);
			String userInput = scanner.nextLine();
			try {
				classSize = Integer.parseInt(userInput);
			} catch(Exception e) {
				System.out.println("Please enter a number.");
			}
		}
		return classSize;
	}

	/**
	 * Generate a class of people
	 * @param classSize The size of the class
	 * @return An ArrayList representing the class
	 */
	public static ArrayList<Person> generateClass(int classSize) {
		ArrayList<Person> classList = new ArrayList<Person>();
		for (int i = 0; i < classSize; i++) {
			classList.add(new Person());
		}
		return classList;
	}
	
	/**
	 * Run as many instances as you say to
	 * @param runCount The number of instances to run
	 * @param classSize	The size of the class for each instance
	 * @return The number of times that at least 2 students in a given class shared a birthday
	 */
	public static int run(int runCount, int classSize) {
		int timesShared = 0;
		for (int i = 0; i < runCount; i++) {
			if (runInstance(classSize)) timesShared++;
		}
		return timesShared;
	}

	/**
	 * Simulate an instance of a class and check if 2 people share the same birthday
	 * @param classSize The number of people in the class
	 * @return	If 2 people share a birthday or not
	 */
	private static boolean runInstance(int classSize) {
		int[] birthdays = new int[365];
		ArrayList<Person> classList = BirthdayProgram.generateClass(classSize);
		for (Person person : classList) {
			int birthday = person.getBirthday();
			if (birthdays[birthday] == 1) {	//shared birthday found
				return true;
			} else {
				birthdays[birthday] = 1;
			}
		}
		return false;
	}
	
}
