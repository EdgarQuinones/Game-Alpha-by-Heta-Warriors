package alpha.game;

import java.util.Random;
import java.util.Scanner;

import alpha.characters.Icon;
import alpha.characters.Player;
import alpha.characters.enemies.Boss;
import alpha.characters.enemies.Enemy;
import alpha.characters.enemies.Minion;
import alpha.other.Ability;

/**
 * The Game class handles most of the actual game logic.
 * It is where the basic game loop is handled, while 
 * accessing the other classes for other uses, like 
 * lore and character battle.
 */
public class Game {
	
	// TODO: Move location to Class: Lore. And move minion/boss count to another class?
	// Private instance variables
	private static String location;
	private static int minionCount;
	private static int bossCount;
	// TODO: Create 2D array for enemies?
	// TODO: Move players array to Game class?

	/**
	 * Start() is essentially the main method, but is abstracted away
	 * for cleaner visuals.
	 * @param band Group of players in the game.
	 */
	public static void Start(Player[] band) {
		
		// TODO: Move the Band here or somewhere away from main so its cleaner.
		//startMenu();
		Level1(band);
		
	}
	
	/*
	 * This method contains the current "First level" of the game.
	 * As of now each level contains "waves" and the band must 
	 * defeat all waves to proceed to the next level. 
	 * Progress is reset until next level.
	 */
	private static void Level1(Player[] band) {
		
		boolean battleOutcome;
		
		//Lore.level1Start();//lore for level 1
		
		// TODO: Lore Class should handle the location, 
		// TODO: maybe 2D array containing all waves per level?
		location = "Ghastly Woods";
		Enemy[] wave1 = {
				new Minion("Mysterious Minion"),
				new Minion("Wild Minion"),
				new Minion("Primeval Minion"),
				};
		
		// TODO: Figure out better method for handling battles instead of 2 booleans
		battleOutcome = fight(band, location, wave1);
		while(!battleOutcome) {
			
			System.out.println("*******************");
			System.out.println(" All Band members Defeated!  ");
			System.out.println(" Going back to the start!  ");
			System.out.println("*******************\n");
			
			for(Player member : band) {
				member.reset();
			}
			for(Enemy mob : wave1) {
				mob.reset();
			}
			
			battleOutcome = fight(band, location, wave1);
		}
		
		
		//end of section 1
		System.out.println();
		
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

	// TODO: This should be in Lore, not in Game, so not making a comment 
	@SuppressWarnings("unused")
	private static void level1Intro() {
		// TODO Auto-generated method stub
		System.out.println("Lore of level 1"); 
	}

	// TODO: Might move to lore, or make a UI class.
	@SuppressWarnings("unused")
	private static void startMenu() {
		System.out.println("Welcome to...");
		Icon.menu();
		
	}
	
	/**
	 * The fight() method handles the main fighting logic. 
	 * A band of players get looped through and attack a 
	 * group of enemies. Following that, the enemies attack 
	 * back using a random number generator.
	 * @param band Group of playing characters 
	 * @param location Current location of the band. Most likely will move to Lore
	 * @param mobs Group of enemies. Most likely change to 2D array
	 * @return
	 */
	private static boolean fight(Player[] band, String location, Enemy[] mobs) {
		
		// TODO: Too many booleans and lore here. Clean up needed
		System.out.println("You have entered "+location+".\n");
		boolean bandIsAlive = true;
		boolean levelCompleted = false;
		while(!levelCompleted && bandIsAlive) {
			
			int livingMobs = 0;
			for(Enemy mob : mobs ) {
				if(mob.isAlive()) livingMobs++;
			}
			System.out.println("There are "+livingMobs+" enemies remaining: ");
			
			// TODO: Not sure if enemy count is needed, already displaying all enemies
			//1st list containing how many of each enemy there are
			minionCount = 0;
			bossCount = 0;
			for(Enemy mob : mobs) {
				if(mob instanceof Minion && mob.isAlive()) {
					minionCount++;
				}
				else if(mob instanceof Boss && mob.isAlive()) {
					bossCount++;
				}
			}
			System.out.println("* "+minionCount+" Minions");
			System.out.println("* "+bossCount+" Bosses\n");
	
			bandIsAlive = battlePhase(band,mobs);
			
			levelCompleted = !(checkEnemies(mobs));
		}
		
		// TODO: Gotta get rid of this somehow
		if(levelCompleted && bandIsAlive) {
			return true;//goes to level 2
		}else {
			return false;//restarts level
		}
	}
	
	/**
	 * TODO: Both fight() and battlePhase() need to be 
	 * cleaned up and use helper methods. Way too much 
	 * going on in both. But might still keep the booleans
	 * idk... Need a way to know how the fight is going.
	 */

	/**
	 * battlePhase() is used side-by-side with fight().
	 * This method is where the players and enemies fight 
	 * each other. 
	 * @param band
	 * @param mobs
	 * @return
	 */
	private static boolean battlePhase(Player[] band, Enemy[] mobs) {
		
		// TODO: A little too many variables here. Will need to clean up
		try (Scanner scnr = new Scanner(System.in)) {
			int choice = 0;
			int playerDamage = 0;
			int enemyDamage = 0;
			Ability[] playerAbilities;
			for(Player member : band) {
				
				// TODO: Move to UI?
				System.out.println("*******************");
				System.out.println(" The Band's Turn!  ");
				System.out.println("*******************\n");
				
				displayPlayers(band);
				displayEnemies(mobs);
				do {
				System.out.println(member.getName()+"'s turn. Select an ability:\n");
				Ability.displayAbilities(member.getAbilities());
				playerAbilities = member.getAbilities();
				System.out.print("Ability: ");
				choice = scnr.nextInt();
				System.out.println();
				
				switch(choice) {
				
				case 1: 
					playerDamage = playerAbilities[0].getDamage();
				case 2: 
					playerDamage = playerAbilities[1].getDamage();
				case 3: 
					playerDamage = playerAbilities[2].getDamage();
				}
				
						
				}while(choice <= 0 || choice > member.getNumberOfAbilities());
				
				do {
					displayPlayers(band);
					System.out.println("Select an Enemy: ");
					displayEnemies(mobs);
					System.out.print("Enemy: ");
					choice = scnr.nextInt();
					System.out.println();
				}while(choice <= 0 || choice > mobs.length);	
					if(!playerAbilities[choice -1].isAOE()) {
						for(int i = 0; i < mobs.length; i++) {
							if(choice - 1 == i) {
								mobs[i].hurt(playerDamage);
								System.out.println(member.getName()+" did "+playerDamage+" to "+mobs[i].getName());
							}
						}
					}else {
						for(int i = 0; i < mobs.length; i++) {
								mobs[i].hurt(playerDamage);
								System.out.println(member.getName()+" did "+playerDamage+" to "+mobs[i].getName());
							}
						}
			}//End of band attacks 
			
			// TODO: Move to UI? #2 
			System.out.println("\n*******************");
			System.out.println(" The Enemies Turn!  ");
			System.out.println("*******************\n");
			
			Random rand = new Random();
			int attackedPlayer = rand.nextInt(band.length);
			for(Enemy mob : mobs) {
				enemyDamage = mob.attack();
				band[attackedPlayer].hurt(enemyDamage);
				System.out.println(mob.getName()+" did "+mob.attack()+" to "+band[attackedPlayer].getName());
				attackedPlayer = rand.nextInt(band.length);
			}
		}
		System.out.println();
		
		if(checkStatus(band)) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Used to check if all enemies are alive, if 
	 * they are all elimited, returns false, 
	 * kinda confusing now may change it
	 * @param mobs Group of enemies
	 * @return true if at least 1 alive, else false
	 */
	private static boolean checkEnemies(Enemy[] mobs) {
		// TODO Auto-generated method stub
		int counter = 0;
		for(Enemy mob : mobs) {
			if(!mob.isAlive()) {
				counter++;
			}
		}
		if(counter == mobs.length) {
			return false;
		}else {
			return true;
		}
		
	}

	/**
	 * Used to check if all players are alive, if 
	 * they are all elimited, returns false, 
	 * kinda confusing now may change it
	 * @param band Group of Players
	 * @return true if at least 1 alive, else false
	 */
	private static boolean checkStatus(Player[] band) {
		// TODO Auto-generated method stub
		int bandSize = band.length;
		int downedMembers = 0;
		for(Player player : band) {
			if(!player.isAlive()) {
				downedMembers++;
			}
		}
		if(downedMembers == bandSize) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * A specific method used to loop through an array of enemies, 
	 * giving their particular stats. Important 
	 * method as its how players will choose who to attack.
	 */
	private static void displayEnemies(Enemy[] mobs) {
		System.out.println("Arena:");
		int counter = 1;
		for(Enemy mob : mobs) {
			System.out.println(counter+". "+mob);
			counter++;
		}
		System.out.println();
	}
	
	/*
	 * Gives the band of players a proper visual of everyone 
	 * and their stats. Very similar to displayEnemies(),
	 * displays HP, DEF, Name, and level. 
	 */
	private static void displayPlayers(Player[] band) {
		System.out.println("Band:");
		int counter = 1;
		for(Player player : band) {
			System.out.println(counter+". "+player);
			counter++;
		}
		System.out.println();
	}
	
	
}
