package game;
import fixtures.*;



public class RoomManager {

	
	Room startingRoom = null;
	Room[] rooms = new Room[100];      // list of all the rooms
	
	
	
	
	// Initialize all the rooms
	public void init() {
	    Room foyer = new Room(
			"The Foyer",
			"a small foyer",
			"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
			+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
			+ "To the north is a small room, where you can see a piano.", "money");
			this.rooms[0] = foyer;
	        this.startingRoom = foyer;
	        
	        
	    Room anotherRoom = new Room(
					"Another Room",
					"it's another room",
					"It's another room that's connected to the foyer", "jewelry");
					this.rooms[1] = anotherRoom;

					// Connect this to the foyer
					foyer.getExits().put("north", anotherRoom);
					anotherRoom.getExits().put("south", foyer);
					
					
	        
	    Room southRoom = new Room(
					"South Room",
					"it's the South room",
					"It's another room that's connected to the foyer", "Rembrant");
					this.rooms[2] = southRoom;
		
					
					
					foyer.getExits().put("south", southRoom);
					southRoom.getExits().put("north", foyer);
					
					
					
					
	}
	
	
	
	
	
	
	
	
	
	
	
}
