package ChooseYourDoor;

public class Door {
	
	private String type;
	
	/**
	 * A door object
	 * @param type If this door should be good or bad
	 */
	public Door(String type) {
		this.type = type;
	}

	/**
	 * Checks if the door is good or bad
	 * @return 1 if the door is good, 0 if it's bad
	 */
	public int getPrimitiveType() {
		if (type.equals("Good")) return 1;
		return 0;
	}
}
