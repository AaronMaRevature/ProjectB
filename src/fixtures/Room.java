package fixtures;
import java.util.*;


public class Room extends Fixture{

	

	
	Map<String, Room> exits = null;
	private Map<String, Boolean> doors = null;
	
	
	
	private String item = null;      // Item of interest
	
	
	
	
	public Room(String name, String shortDescription, String longDescription, String item) {
		super(name, shortDescription, longDescription);
		this.exits = new HashMap<String, Room>();
		this.setDoors(new HashMap<String, Boolean>());
		
		// Initialize doors to all false
		this.getDoors().put("north", false);
		this.getDoors().put("east", false);
		this.getDoors().put("south", false);
		this.getDoors().put("west", false);
		
		
		this.setItem(item);
	}
		
	
	
	public Map<String, Room> getExits() {
		return this.exits;
	}
		
	public Room getExit(String direction) {
		
		
		return this.exits.get(direction);
		

		
		
	}



	public Map<String, Boolean> getDoors() {
		return doors;
	}



	public void setDoors(Map<String, Boolean> doors) {
		this.doors = doors;
	}



	public String getItem() {
		return item;
	}



	public void setItem(String item) {
		this.item = item;
	}
	
	
	
	
	
	
	
	
	
	
	
}
