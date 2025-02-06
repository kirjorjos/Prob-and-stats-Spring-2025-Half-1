package ChooseYourDoor;

public class Door {
	
	private String type;
	
	public Door(String type) {
		this.type = type;
	}

	public int getPrimitiveType() {
		if (type.equals("Good")) return 1;
		return 0;
	}
}
