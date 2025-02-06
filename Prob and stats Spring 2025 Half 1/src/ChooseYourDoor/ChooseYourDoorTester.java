package ChooseYourDoor;

public class ChooseYourDoorTester {
	public static void main(String[] args) {
		int wins = ChooseYourDoor.startSimulation(true, 10000);
		System.out.printf("You won %d times with a percentage chance of %.2f%%.", wins, wins/(float)100);
	}
}