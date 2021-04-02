package C19307776;
//This is a list of properties that can be animated
public enum Properties {
	WIDTH(0), HEIGHT(1), XPOS(2), YPOS(3), ROTATION(4), SCALE(5);

	private final int value;
	private Properties(int value) {
		this.value = value;
	}
	//Returns the value of a property
	//Used to determine which animation property to animate
	public int getValue() {
		return value;
	}
}
