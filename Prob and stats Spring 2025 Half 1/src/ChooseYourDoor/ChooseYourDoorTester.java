package ChooseYourDoor;

public class ChooseYourDoorTester {
	public static void main(String[] args) {
		int runs = 10000;
		int doors = 3;
		int wins = ChooseYourDoor.startSimulation(true, runs, doors);
		System.out.printf("You won %d times with a percentage chance of %.2f%%.", wins, wins/(float)100);
	}
}