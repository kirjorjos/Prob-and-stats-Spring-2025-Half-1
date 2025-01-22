package ChooseYourDoor;

import java.util.Random;

public class ChooseYourDoor {
	
	static Random rand = new Random();
	
	public static int startSimulation(boolean changeDoorPick) {
		int wins = 0;
		for (int i = 0; i<10000; i++) {
			wins += runInstance(changeDoorPick);	//add 1 if the door is found, 0 if not
		}
		return wins;
	}
	
	public static int runInstance(boolean changeDoorPick) {
		//setup the doors and initial pick
		int[] doors = {0, 0, 0};
		int winLocation = rand.nextInt(3);
		int doorToPick = rand.nextInt(3);
		int doorToReveal = rand.nextInt(3);
		doors[winLocation] = 1;
	
		while (doorToReveal == winLocation || doorToReveal == doorToPick) {	//set the door to reveal to the last door
			doorToReveal = rand.nextInt(3);
		}
		
		if (changeDoorPick) {
			doorToPick = 3-(doorToPick+doorToReveal);
		}
		
		return doors[doorToPick];
	}
}
/**
 * Questions A and B
 * A: Every door has a 33.33% chance so there is a 33.33% chance he will pick the right door given 1 random pick.
 * B: 
 */