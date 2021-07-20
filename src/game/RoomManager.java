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
			+ "To the north is a small room, where you can see a piano.");
			this.rooms[0] = foyer;
	        this.startingRoom = foyer;
	        
	        
	    Room anotherRoom = new Room(
					"Another Room",
					"it's another room",
					"It's another room that's connected to the foyer");
					this.rooms[1] = anotherRoom;

					// Connect this to the foyer
					foyer.getExits()[0] = anotherRoom;    // another room is north of foyer
					anotherRoom.getExits()[2] = foyer;      //  foyer is south of another room
	        
	    Room southRoom = new Room(
							"Aouth Room",
							"it's the South room",
							"It's another room that's connected to the foyer");
							this.rooms[2] = southRoom;

							// Connect this to the foyer
							foyer.getExits()[2] = southRoom;    // another room is north of foyer
							southRoom.getExits()[0] = foyer;      //  foyer is south of another room				
					
					
					
					
					
	}
	
	
	
	
	
	
	
	
	
	
	
}
