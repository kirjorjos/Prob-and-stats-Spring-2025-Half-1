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

	public static ArrayList<Person> generateClass(int classSize) {
		ArrayList<Person> classList = new ArrayList<Person>();
		for (int i = 0; i < classSize; i++) {
			classList.add(new Person());
		}
		return classList;
	}
	
	public static int run(int runCount, int classSize) {
		int timesShared = 0;
		for (int i = 0; i < runCount; i++) {
			if (runInstance(classSize)) timesShared++;
		}
		return timesShared;
	}

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
