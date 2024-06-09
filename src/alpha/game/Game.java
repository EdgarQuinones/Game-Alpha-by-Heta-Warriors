package alpha.game;

import alpha.characters.Icon;

public class Game {

	public static void Start() {
		
		System.out.println("Game Started!");
		startMenu();
		Level1();
		
	}
	
	private static void Level1() {
		// Gameplay Loop
		
	}

	private static void startMenu() {
		Icon.menu();
		System.out.println("Print Menu");
		
	}
	
}
