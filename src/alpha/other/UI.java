package alpha.other;

import alpha.characters.Icon;

/**
 * Handles all the UI elements. This includes: - Whos turn it is - When the band
 * of players all lose - The start menu - Side by side with Lore class - etc...
 */
public class UI {

	/**
	 * Prints when its the enemies turn in battle phase.
	 */
	public static void enemysTurn() {
		System.out.println("\n*******************");
		System.out.println(" The Enemies Turn!  ");
		System.out.println("*******************\n");
	}

	/**
	 * Prints when all players die, level resets
	 */
	public static void playersDefeated() {
		System.out.println("*******************");
		System.out.println(" All Band members Defeated!  ");
		System.out.println(" Going back to the start!  ");
		System.out.println("*******************\n");
	}

	/**
	 * Prints when its the players turn in battle phase.
	 */
	public static void playersTurn() {
		System.out.println("*******************");
		System.out.println(" The Band's Turn!  ");
		System.out.println("*******************\n");
	}

	/**
	 * Intro to the game Aether Champions
	 */
	public static void startMenu() {
		System.out.println("Welcome to...");
		Icon.titleScreen();

	}

}
