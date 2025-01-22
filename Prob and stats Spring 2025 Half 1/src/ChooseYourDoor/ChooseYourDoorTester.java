package ChooseYourDoor;

public class ChooseYourDoorTester {
	public static void main(String[] args) {
		int wins = ChooseYourDoor.startSimulation(true);
		System.out.printf("You won %d times with a percentage chance of %.2f%%.", wins, wins/(float)100);
	}
}
