package game;
import fixtures.*;
import java.util.*;






public class Main {

	static boolean disablePrintRoom = false;
	
	static Map<String, String> directionPair = new HashMap<String, String>(); 
	
	
	
	public static void main(String[] args) {
		
		
		// Initialize the rooms
		RoomManager rm = new RoomManager();
		rm.init();

		// Set up player and his current room
		Player p = new Player();
		p.currentRoom = rm.startingRoom;
		
		
		// Initialize thee directionPairs
		directionPair.put("north", "south");
		directionPair.put("east", "west");
		directionPair.put("south", "north");
		directionPair.put("west", "east");
		
		
		
		//  Main game loop
		while(true) {
			
			
			// Print the room
			if (!disablePrintRoom) printRoom(p);
			
			// Get the user's input
			String[] input = collectInput();
			
			// Carry out the user's command
			parse(input, p,  rm);
			
			
			
			
		}
		
		
		
		
		
		
		
	}

	
	
	
	
	
	// Print prompt to the player, the current room
	private static void printRoom(Player player) {
		
		// Get the current room
		Room r = player.currentRoom;
		
		// Print info
		System.out.println(r.getName() + "\n");
		System.out.println(r.getLongDescription() + "\n");
		
		// Print out items of interest (it not null)
		if (r.getItem() != null) {
			System.out.println("Item of interest: "+ r.getItem());
		}
		
		
		
		// Print the exits (and their names and whether the door is closed)
		System.out.println();
		System.out.println("These are the exits: ");
		for(Map.Entry<String, Room> entry: r.getExits().entrySet()       ) {

				String direction = entry.getKey();
				Room exit = entry.getValue();
				
				// Check out if the door is open
				boolean doorIsOpen = r.getDoors().get(direction);
				
			
				System.out.print(direction + ": ");
				System.out.print(exit.getName());
				
				// Print out whether the door is open
				if (!doorIsOpen) System.out.print(" (door is closed)");
				System.out.println();
				
		}
		
		
		
		System.out.println("\n");
	}

	
	
	
	private static String[] collectInput() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a command (\"go \" +  direction), (\"open \" +  direction), (\"take \" + item), (\"show inventory\"), \"print room\": ");
		String in = sc.nextLine();	
		
		String first = in.substring(0, in.indexOf(" "));
		String second = in.substring(in.indexOf(" ") + 1, in.length());
		
		String[] out = {first, second};
				
		return out;
	}
		
	
	
	// TODO: Add functoinality.                  
	private static void parse(String[] command, Player player, RoomManager rm) {

		
		// "Go" command
		if(command[0].equals("go")) {
			
			// Check if that door is open. If so, allow the movement
			if(player.currentRoom.getDoors().get(command[1])) {
				player.currentRoom = player.currentRoom.getExit(command[1]);
				disablePrintRoom = false;
				
			}
			// Else, tell the player to open the door fist
			else {
				System.out.println("Open the door first.");
				disablePrintRoom = true; 
			}
			
			
		}
		
		
		
		
		
		// "Open" command
		else if (command[0].equals("open")) {
			
			// Set the door's boolean value to true
			player.currentRoom.getDoors().replace(command[1], true);
			disablePrintRoom = false;
			
			
			
			
			// Find the other room this door connects to and set that door to open
			Room otherRoom = player.currentRoom.getExit(command[1]);

			
			// Open the door
			otherRoom.getDoors().replace(directionPair.get(command[1]), true);
			
			
		}
		
		
		
		
		
		
		// "Take" command              
		else if ( command[0].equals("take") ) {
			
			// If room has nothing to take
			if (player.currentRoom.getItem() == null) {
				System.out.println("Nothing to take.");
				disablePrintRoom = true; 
			}
			
			
			
			// If item user wants to take doesn'tm atch up with room's item
			if (!command[1].equals(player.currentRoom.getItem())) {
				System.out.println("There is no " + command[1] + " in the room." );
				disablePrintRoom = true; 
			}
			
			
			// Otherwise, take the item
			if (command[1].equals(player.currentRoom.getItem())) {
				System.out.println("Took the " + command[1]);
				disablePrintRoom = true; 
				player.inventory.add(command[1]);
				
				
				// Remove the item from the room
				player.currentRoom.setItem(null);
				
				
			}
			
			
		}
		
		
		
		
		// "Show inventory command"
		else if (command [0].equals("show") && command[1].equals("inventory")) {
			
			// If inventory is empty
			if (player.inventory.size() == 0) {
				System.out.println("There is nothing in the inventory.");
				disablePrintRoom = true; 
			}
			
			
			else {
				for(String item: player.inventory) {
					System.out.println(item);
					}
				disablePrintRoom = true; 
			}
			
		}
		
		
		
		
		// Command to print room
		else if ( command [0].equals("print") && command[1].equals("room") ) {
			printRoom(player);
			disablePrintRoom = true; 
		}
		
		
		
		
		// Else invalid command
		else {
			System.out.println("Invalid command");
			disablePrintRoom = true; 
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
