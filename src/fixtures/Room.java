package fixtures;

public class Room extends Fixture{

	
	Room[] exits = null;
	
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4]; // size is your choice
	}
		
	public Room[] getExits() {
		return this.exits;
	}
		
	public Room getExit(String direction) {
		
		switch (direction) {
		
			case "north":
				return this.exits[0];
			case "east":
				return this.exits[1];
			case "south":
				return this.exits[2];
			case "west":
				return this.exits[3];
		}
		
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
