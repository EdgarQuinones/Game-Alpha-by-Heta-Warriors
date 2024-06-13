package alpha.other;

import alpha.characters.Icon;

public class UI {

	public static void enemysTurn() {
		System.out.println("\n*******************");
		System.out.println(" The Enemies Turn!  ");
		System.out.println("*******************\n");
	}
	
	public static void playersTurn() {
		System.out.println("*******************");
		System.out.println(" The Band's Turn!  ");
		System.out.println("*******************\n");
	}
	
	public static void playersDefeated() {
		System.out.println("*******************");
		System.out.println(" All Band members Defeated!  ");
		System.out.println(" Going back to the start!  ");
		System.out.println("*******************\n");
	}
	
	public static void startMenu() {
		System.out.println("Welcome to...");
		Icon.menu();
		
	}
	
}
