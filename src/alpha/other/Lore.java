package alpha.other;

/**
 * The Lore class will store all lore in this game.
 * Currently it works by storing static method that can be called, 
 * usually printing a large text of valuable information for the 
 * band of players. For now it is 2 pieces of lore per level. Plus 
 * the start and finish of the game.
 */
public class Lore {

	/**
	 * The first piece of lore given to the player. 
	 * Will give the band of player a visual of the world.
	 */
	public static void startOfGame() {
		// TODO
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
		// TODO Auto-generated method stub
	}
}
