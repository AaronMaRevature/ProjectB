package game;
import fixtures.*;
import java.util.*;






public class Main {

	public static void main(String[] args) {
		
		
		// Initialize the rooms
		RoomManager rm = new RoomManager();
		rm.init();

		// Set up player and his current room
		Player p = new Player();
		p.currentRoom = rm.startingRoom;
		
		
		
		//  Main game loop
		while(true) {
			
			
			// Print the room
			printRoom(p);
			
			// Get the user's input
			String[] input = collectInput();
			
			// Carry out the user's command
			parse(input, p);
			
			
			
			
		}
		
		
		
		
		
		
		
	}

	
	
	
	
	
	// Print prompt to the player, the current room
	private static void printRoom(Player player) {
		
		// Get the current room
		Room r = player.currentRoom;
		
		// Print info
		System.out.println(r.getName() + "\n");
		System.out.println(r.getLongDescription() + "\n");
		
		// Print the exits (and their shortDescription)
		for(int i = 0; i < 4; i++) {
			if (r.getExits()[i] != null) {
				String direction = "";
				switch(i) {
					case 0:
						direction = "north";
						break;
					case 1:
						direction = "east";
						break;
					case 2:
						direction = "south";
						break;
					case 3:
						direction = "west";
						break;
				}
				System.out.print(direction + ": ");
				System.out.println(r.getExits()[i].getShortDescription());
			}
		}
		System.out.println();
		
		
	}

	
	
	
	private static String[] collectInput() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a command: ");
		String in = sc.nextLine();	
		
		String first = in.substring(0, in.indexOf(" "));
		String second = in.substring(in.indexOf(" ") + 1, in.length());
		
		String[] out = {first, second};
				
		return out;
	}
		
	
	
	
	private static void parse(String[] command, Player player) {

		
		// Second word contanis room to go to
		player.currentRoom = player.currentRoom.getExit(command[1]);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
