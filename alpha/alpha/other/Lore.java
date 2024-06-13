package alpha.other;

/**
 * The Lore class will store all lore in this game. Currently it works by
 * storing static method that can be called, usually printing a large text of
 * valuable information for the band of players. For now it is 2 pieces of lore
 * per level. Plus the start and finish of the game.
 */
public class Lore {

	/**
	 * Contains all the locations and info on locations for level. Subject to
	 * change...
	 */
	public static Lore[] level1Locations = {
			new Lore("Whispering Grove",
					"A serene yet eerie forest " + "where the trees seem to whisper secrets to those "
							+ "who dare to venture within. Enemies here could be "
							+ "mystical creatures attuned to nature's whispers."),
			new Lore("Shadowfen Thicket",
					"A dense, dark forest where the " + "light struggles to penetrate, and shadows lurk with "
							+ "sinister intent. Players might face off against "
							+ "creatures adapted to the darkness, like shadowy beasts" + " or corrupted wildlife.") };

	/**
	 * End to level 1 and the bands next steps.
	 */
	public static void level1End() {
		// TODO: Create lore that players get when they complete level 1
	}

	/**
	 * Intro to level 1 and the bands mission
	 */
	public static void level1Start() {
		System.out.println("The five Aether Champions travel to the infamous Ghastly Woods to find"
				+ " the Dark Lord... Will they survive?");
	}

	/**
	 * The first piece of lore given to the player. Will give the band of player a
	 * visual of the world.
	 */
	public static void startOfGame() {
		// TODO: Great lore that starts Aether Champions
	}

	/**
	 * The lore on that particular location
	 */
	private String info;

	/**
	 * The location of the level, usually a sub-location
	 */
	private String location;

	/**
	 * Constructor used to setup Lore for all levels.
	 * 
	 * @param location Location of a sub-section of a level
	 * @param info     Information on said sub-section
	 */
	public Lore(String location, String info) {
		this.location = location;
		this.info = info;
	}

	/**
	 * @return Prints current info of that location
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @return Location of level
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets new info for a location
	 * 
	 * @param info New info for a location
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * Sets new location
	 * 
	 * @param Location Location of level
	 */
	public void setLocation(String Location) {
		this.location = Location;
	}
}
