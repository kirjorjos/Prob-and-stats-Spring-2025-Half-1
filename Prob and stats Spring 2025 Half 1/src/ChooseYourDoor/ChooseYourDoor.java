package ChooseYourDoor;

import java.util.Random;

public class ChooseYourDoor {
	
	static Random rand = new Random();
	
	/**
	 * Start the simulation and run however many instances and see how many win
	 * @param changeDoorPick If the door pick should be changed or not; true means it does change.
	 * @param trials The number of instances to run
	 * @param totalDoors The number of doors each instance should have
	 * @return The number of instances that won
	 */
	public static int startSimulation(boolean changeDoorPick, int trials, int totalDoors) {
		int wins = 0;
		for (int i = 0; i<trials; i++) {
			wins += runInstance(changeDoorPick, totalDoors);	//add 1 if the door is found, 0 if not
		}
		return wins;
	}
	
	/**
	 * An instance of picking a door and potentially swapping it
	 * @param changeDoorPick If the door pick should be swapped or not; true means it is swapped
	 * @param totalDoors The number of doors to run the simulation with
	 * @return 1 if the correct door was picked, 0 if not
	 */
	public static int runInstance(boolean changeDoorPick, int totalDoors) {
		//setup the doors and initial pick
		Door[] doors = new Door[totalDoors];
		int initialPick;
		for (int i = 0; i < totalDoors; i++) {
			doors[i] = new Door("Bad");
		}
		int winLocation = rand.nextInt(totalDoors);
		int doorToPick = rand.nextInt(totalDoors);
		int doorToReveal = rand.nextInt(totalDoors);
		doors[winLocation] = new Door("Good");
	
		while (doorToReveal == winLocation || doorToReveal == doorToPick) {	//set the door to reveal to the last door
			doorToReveal = rand.nextInt(totalDoors);
		}
		
		initialPick = doorToPick;
		
		if (changeDoorPick) {
			while (doorToPick == doorToReveal || doorToPick == initialPick) {
				doorToPick = rand.nextInt(totalDoors);
			}
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
 * 
 * Extra Credit: Modeled deal or no deal by allowing for a variable number of "doors"
 */