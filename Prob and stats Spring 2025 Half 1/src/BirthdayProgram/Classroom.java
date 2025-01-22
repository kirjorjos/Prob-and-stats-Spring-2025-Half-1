package BirthdayProgram;

import java.util.ArrayList;

public class Classroom {
	private ArrayList<Person> students;
	
	/**
	 * A class that has students in it
	 * @param students
	 */
	public Classroom(ArrayList<Person> students) {
		this.setStudents(students);
	}

	/**
	 * Get the list of students
	 * @return The list of students
	 */
	public ArrayList<Person> getStudents() {
		return students;
	}
	
	/**
	 * Set the list of students
	 * @param students The list of students
	 */
	public void setStudents(ArrayList<Person> students) {
		this.students = students;
	}
}
