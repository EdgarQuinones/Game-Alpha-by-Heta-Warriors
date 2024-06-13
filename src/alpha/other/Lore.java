package alpha.other;

/**
 * The Lore class will store all lore in this game.
 * Currently it works by storing static method that can be called, 
 * usually printing a large text of valuable information for the 
 * band of players. For now it is 2 pieces of lore per level. Plus 
 * the start and finish of the game.
 */
public class Lore {
	
	private String location;
	private String info;
	
	public Lore(String location, String info) {
		this.location = location;
		this.info = info; 
	}
	
	public static Lore[] level1Locations = {
			new Lore("Whispering Grove", "A serene yet eerie forest "
					+ "where the trees seem to whisper secrets to those "
					+ "who dare to venture within. Enemies here could be "
					+ "mystical creatures attuned to nature's whispers."),
			new Lore("Shadowfen Thicket", "A dense, dark forest where the "
					+ "light struggles to penetrate, and shadows lurk with "
					+ "sinister intent. Players might face off against "
					+ "creatures adapted to the darkness, like shadowy beasts"
					+ " or corrupted wildlife.")
	};
	
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String Location) {
		this.location = Location;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * The first piece of lore given to the player. 
	 * Will give the band of player a visual of the world.
	 */
	public static void startOfGame() {
		// TODO: Great lore that starts Aether Champions
	}
	
	/**
	 * Intro to level 1 and the bands mission
	 */
	public static void level1Start() {
		System.out.println("The five Aether Champions travel to the infamous Ghastly Woods to find"
				+ " the Dark Lord... Will they survive?");
	}
	
	/**
	 * End to level 1 and the bands next steps.
	 */
	public static void level1End() {
		// TODO: Create lore that players get when they complete level 1
	}
}
