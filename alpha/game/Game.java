package alpha.game;

import alpha.characters.Icon;

public class Game {

	public static void Start() {
		
		System.out.println("Game Started!");
		startMenu();
		
	}
	
	private static void startMenu() {
		Icon.menu();
		System.out.println("Print Menu");
		
	}
	
}
