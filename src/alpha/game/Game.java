package alpha.game;

import alpha.characters.Icon;
import alpha.characters.enemies.Enemy;

public class Game {

	public static void Start() {
		
		System.out.println("Game Started!");
		startMenu();
		Level1();
		
	}
	
	private static void Level1() {
		// Gameplay Loop
		
		//while(!levelComplete)
		
		//areaInfo()
		//battlephase()
		
		//if(!player.isalive) 
			// gameOver()
			// Restart Level 1
		//if(numOfenemies <= 0)
			//levelComplete == true
	}

	private static void startMenu() {
		Icon.menu();
		System.out.println("Print Menu");
		
	}
	
	private static void fight(String location, int numOfEnemies, Enemy[] mobs) {
		System.out.println("You have entered "+location+".");
		System.out.println("There are "+numOfEnemies+" enemies: ");

		for(Enemy mob : mobs) {
			System.out.println(mob);
		}
		
	}
	
}
