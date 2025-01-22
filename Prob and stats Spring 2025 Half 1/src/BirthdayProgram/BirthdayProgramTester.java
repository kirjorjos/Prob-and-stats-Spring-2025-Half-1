package BirthdayProgram;

public class BirthdayProgramTester {
	public static void main(String[] args) {
		int classSize = BirthdayProgram.getUserNumber("Please enter a class size: ");
		int runCount = BirthdayProgram.getUserNumber("Please enter a number of runs: ");
		int timesShared = BirthdayProgram.run(runCount, classSize);
		System.out.printf("There were %d times across %d runs with a class size of %d where 2 or more people shared a birthday.  This means there is a probability of about %.2f%%.", timesShared, runCount, classSize, 100*(double)timesShared/(runCount));
	}
}
