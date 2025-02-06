package ChooseYourDoor;

import java.util.Random;

public class ChooseYourDoor {
	
	static Random rand = new Random();
	
	public static int startSimulation(boolean changeDoorPick, int trials) {
		int wins = 0;
		for (int i = 0; i<trials; i++) {
			wins += runInstance(changeDoorPick);	//add 1 if the door is found, 0 if not
		}
		return wins;
	}
	
	public static int runInstance(boolean changeDoorPick) {
		//setup the doors and initial pick
		Door[] doors = {new Door("Bad"), new Door("Bad"), new Door("Bad")};
		int winLocation = rand.nextInt(3);
		int doorToPick = rand.nextInt(3);
		int doorToReveal = rand.nextInt(3);
		doors[winLocation] = new Door("Good");
	
		while (doorToReveal == winLocation || doorToReveal == doorToPick) {	//set the door to reveal to the last door
			doorToReveal = rand.nextInt(3);
		}
		
		if (changeDoorPick) {
			doorToPick = 3-(doorToPick+doorToReveal);
		}
		
		return doors[doorToPick].getPrimitiveType();
	}
}
/**
 * Questions A and B
 * A: Every door has a 33.33% chance so there is a 33.33% chance he will pick the right door given 1 random pick.
 * B: 
 * 	i. 33%
 * 	ii. 66%
 * 	iii. 66%
 * 	iv. 66%
 * 	v. switch which curtain
 */