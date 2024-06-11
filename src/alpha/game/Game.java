package alpha.game;

import java.util.ArrayList;

import alpha.characters.Icon;
import alpha.characters.Player;
import alpha.characters.enemies.Boss;
import alpha.characters.enemies.Enemy;
import alpha.characters.enemies.Minion;

public class Game {
	
	private static String location;
	private static int minionCount;
	private static int bossCount;


	public static void Start(Player[] band) {
		
		System.out.println("Game Started!");
		startMenu();
		Level1(band);
		
	}
	
	private static void Level1(Player[] band) {
		boolean battleOutcome;
		
		// Gameplay Loop
		
		//while(!levelComplete)
		
		//areaInfo()
		//battlephase()
		
		//if(!player.isalive) 
			// gameOver()
			// Restart Level 1
		//if(numOfenemies <= 0)
			//levelComplete == true
		
		//Loop this if player dies

		level1Intro();//lore for level 1
		
		location = "Ghastly Woods";
		Enemy[] wave1 = {
				new Minion("Mysterious Minion"),
				new Minion("Wild Minion"),
				new Minion("Primeval Minion"),
				};
		
		do {
			battleOutcome = fight(band, location, wave1);
		}while(!battleOutcome);
		
		
		//end of section 1
		
		//Section 2 loop
		location = "Icy Cliffs";
		Enemy[] wave2 = {
				new Minion("Cold-blooded Minion"),
				new Minion("Frosty Minion"),
				new Minion("Frigid Minion"),
				};
		fight(band, location, wave2);
		//end of section 2
	}

	private static void level1Intro() {
		// TODO Auto-generated method stub
		System.out.println("Lore of level 1"); 
	}

	private static void startMenu() {
		Icon.menu();
		System.out.println("Print Menu");
		
	}
	
	private static boolean fight(Player[] band, String location, Enemy[] mobs) {
		System.out.println("You have entered "+location+".\n");
		
		boolean bandIsAlive = true;
		boolean levelCompleted = false;
		while(bandIsAlive && !levelCompleted) {
			System.out.println("There are "+mobs.length+" enemies: ");
			
			//1st list containing how many of each enemy there are
			minionCount = 0;
			bossCount = 0;
			for(Enemy mob : mobs) {
				if(mob instanceof Minion) {
					minionCount++;
				}
				else if(mob instanceof Boss) {
					bossCount++;
				}
			}
			System.out.println("* "+minionCount+" Minions");
			System.out.println("* "+bossCount+" Bosses\n");
	
			
			//2nd list containing most stats
			System.out.println("Arena:");
			int counter = 1;
			for(Enemy mob : mobs) {
				System.out.println(counter+". "+mob);
				counter++;
			}
			
			//TODO
			battlePhase(band,mobs);
			
			bandIsAlive = checkStatus(band);
			levelCompleted = checkEnemies(mobs);
		}
		if(levelCompleted) {
			return true;//goes to level 2
		}else {
			return false;//restarts level
		}
	}
	/*
	 * There are mobs.length enemies:
	 * 	loop array
	 * 		count per enemy
	 * 	- count minions 
	 *  - count bosses 
	 *  	if(count > 1) string + "s"
	 * 
	 * loop array
	 * 	toString mobs 
	 * 		1. minion stats ???
	 * 		2. minion stats 
	 * 		3. boss stats	???
	 * 
	 * What ability would you like to use? ???
	 * 	loop player.display abilities
	 * 		1. single target, high dmg
	 * 		2. aoe, low dmg
	 *		3. speaical attack (WIP)
	 * */

	private static void battlePhase(Player[] band, Enemy[] mobs) {
		// TODO Auto-generated method stub
		
		
	}

	private static boolean checkEnemies(Enemy[] mobs) {
		// TODO Auto-generated method stub
		int counter = 0;
		for(Enemy mob : mobs) {
			if(!mob.isAlive()) {
				counter++;
			}
		}
		if(counter == mobs.length) {
			return true;
		}else {
			return false;
		}
		
	}

	private static boolean checkStatus(Player[] band) {
		// TODO Auto-generated method stub
		for(Player player : band) {
			if(!player.isAlive()) {
				return false;
			}
		}
		return true;
	}
	
}
