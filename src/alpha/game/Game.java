package alpha.game;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import alpha.characters.Entity;
import alpha.characters.Player;
import alpha.characters.enemies.Enemy;
import alpha.characters.enemies.EnemyWaves;
import alpha.other.Ability;
import alpha.other.Lore;
import alpha.other.UI;

/**
 * The Game class handles most of the actual game logic. It is where the basic
 * game loop is handled, while accessing the other classes for other uses, like
 * lore and character battle. It is also where the band of characters are
 * currently made. May move somewhere else.
 */
public class Game {

	// TODO: Give player the ability to choose how many characters, and what
	// character.
	// Playable Characters:

	/**
	 * EJ, or Samuari mid health, mid dmg (Brawler)
	 */
	private static Player EJ = new Player("Samurai", 150, 30, 25);

	/**
	 * Jada, or the Flame Spirit low health, high dmg (Glass cannon)
	 */
	private static Player Jada = new Player("Flame Spirit", 125, 50, 10);

	/**
	 * Marielle, or the Assasin mid health, high dmg (Assasin)
	 */
	private static Player Marielle = new Player("Executioner", 125, 40, 20);

	/**
	 * Papi, or Wolverine high health, low-mid dmg (Tank)
	 */
	private static Player Papi = new Player("Wolverine", 200, 20, 30);

	/**
	 * Vinny, or the Mender low health, low dmg (healer)
	 */
	private static Player Vinny = new Player("Mender", 100, 10, 10);

	/**
	 * The combined power of the Heta Warriors, in Aether Champions
	 */
	private static Player[] band = { EJ, Papi, Jada, Vinny, Marielle };
	
	/**
	 * battlePhase() is used side-by-side with fight(). This method is where the
	 * players and enemies fight each other.
	 *
	 * @param band The group of playing characters
	 * @param mobs The group of enemies the band is fighting against
	 */
	private static void battlePhase(Player[] band, Enemy[] mobs) {

		// Local variables
		int playerDamage = 0;
		int enemyChoice = -1;
		int abilityChoice = -1;
		int enemyDamage = 0;
		Scanner scnr = new Scanner(System.in);

		// TODO: Get rid of this after setting up playerGetAbilityFromArray() is done
		Ability[] playerAbilities;

		// Loops through all players in the group
		for (Player member : band) {
			UI.playersTurn();

			displayPlayers(band);
			displayEnemies(mobs);

			// TODO Move this repeated to another method and/or class. UI?
			System.out.println(member.getName() + "'s turn. Select an ability:\n");
			Ability.displayAbilities(member.getAbilities());
			playerAbilities = member.getAbilities();

			// TODO: Move exception check into another method?
			boolean flag = true;
			while (flag) {
				try {
					boolean valid = false;
					do {
						System.out.print("Ability: ");
						abilityChoice = scnr.nextInt();
						if (abilityChoice < 1 || abilityChoice > 3) {
							System.out.println("\nInput must be a number 1-3\n");
							scnr.nextLine();
							continue;
						}
						valid = true;
					} while (!valid);
					flag = false;
				} catch (NoSuchElementException e) {
					System.out.println("\nInput must be a number\n");
					// FIXME: #1 Game flips out when going to level 2
					scnr.nextLine();
				}
			}

			// TODO: Make method that lets player choose ability from array
			switch (abilityChoice) {

			case 1:
				playerDamage = playerAbilities[0].getEffect();
			case 2:
				playerDamage = playerAbilities[1].getEffect();
			case 3:
				playerDamage = playerAbilities[2].getEffect();
			}

			// TODO: Make method that displays both like displayEntities()
			displayPlayers(band);
			displayEnemies(mobs);

			// TODO: Move another exception check into another method?
			flag = true;
			while (flag) {
				try {
					boolean valid = false;
					do {
						System.out.println("Select an Enemy: \n");
						System.out.print("Enemy: ");
						enemyChoice = scnr.nextInt();
						if (enemyChoice < 1 || enemyChoice > mobs.length) {
							System.out.println("\nInput must be a number 1-" + mobs.length + "\n");
							scnr.nextLine();
							continue;
						}
						scnr.nextLine();
						valid = true;
						flag = false;
					} while (!valid);
				} catch (NoSuchElementException e) {
					System.out.println("\nInput must be a number\n");
					scnr.nextLine();
				}
			}

			/**
			 * TODO: Abstraction of battlePhase()...
			 *
			 * 1. This logic handles the actual damage from player to enemy. This needs to
			 * be in another method for usability
			 *
			 * 2. Also Checks if ability is AOE, make this better and into another method
			 */
			if (!playerAbilities[abilityChoice - 1].isAOE()) {
				for (int i = 0; i < mobs.length; i++) {
					if (enemyChoice - 1 == i) {
						mobs[i].hurt(playerDamage);
						System.out.println(member.getName() + " did " + playerDamage + " to " + mobs[i].getName());
					}
				}
			} else {
				for (Enemy mob : mobs) {
					mob.hurt(playerDamage);
					System.out.println(member.getName() + " did " + playerDamage + " to " + mob.getName());
				}
			}
		} // End of band/enemies attacks

		if (!checkStatus(mobs)) {
			scnr.close();
			return;
		}

		UI.enemysTurn();

		// TODO: Make enemy attack method more effeicent and fix defence stat prio
		/*
		 * 3. Move the enemy attack player into another method. ALSO SETUP SOME PRIORITY
		 * BASED ON DEFENCE OR SOMETHING? We might rather need a taunt ability or
		 * something most likely..
		 */

		Random rand = new Random();
		int attackedPlayer = rand.nextInt(band.length);
		for (Enemy mob : mobs) {
			enemyDamage = mob.attack();
			band[attackedPlayer].hurt(enemyDamage);
			System.out.println(mob.getName() + " did " + mob.attack() + " to " + band[attackedPlayer].getName());
			attackedPlayer = rand.nextInt(band.length);
		}

		if (!checkStatus(band)) {
			UI.playersDefeated();

			resetGroups(band, mobs);
		}

		System.out.println();
		scnr.close();
	}

	// TODO: Turn checkenemies/checkband into 1 method, it does
	// same exact thing...

	/**
	 * Used to check if all players/enemies are alive, if they are all elimited,
	 * returns false
	 *
	 * @param group Group of Players/Enemies
	 * @return true if at least 1 alive, else false
	 */
	private static boolean checkStatus(Entity[] group) {

		int downedEntities = 0;
		for (Entity entity : group) {
			if (!entity.isAlive()) {
				downedEntities++;
			}
		}
		if (downedEntities == group.length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * TODO: #1 Both fight() and battlePhase() need to be cleaned up and use helper
	 * methods. Very good progress so far, I just feel something is missing and we
	 * can maybe add 2 or 3 more methods
	 */

	/**
	 * A specific method used to loop through an array of enemies, giving their
	 * particular stats. Important method as its how players will choose who to
	 * attack.
	 *
	 * @param mobs Group of enemies
	 */
	private static void displayEnemies(Enemy[] mobs) {
		System.out.println("Arena:");
		int counter = 1;
		for (Enemy mob : mobs) {
			System.out.println(counter + ". " + mob);
			counter++;
		}
		System.out.println();
	}

	/**
	 * Gives the band of players a proper visual of everyone and their stats. Very
	 * similar to displayEnemies(), displays HP, DEF, Name, and level.
	 *
	 * @param band Group of players
	 */
	private static void displayPlayers(Player[] band) {
		System.out.println("Band:");
		int counter = 1;
		for (Player player : band) {
			System.out.println(counter + ". " + player);
			counter++;
		}
		System.out.println();
	}

	/**
	 * The fight() method handles the main fighting logic. A band of players get
	 * looped through and attack a group of enemies. Following that, the enemies
	 * attack back using a random number generator.
	 *
	 * @param location Current location of the band. Most likely will move to Lore
	 * @param mobs     Group of enemies. Most likely change to 2D array
	 */
	private static void fight(String location, Enemy[] mobs) {
		/*
		 * TODO: Remove both parameters. Location will be handled in UI/Lore class, and
		 * mobs will be handled in waves class
		 */

		resetGroups(band);

		/*
		 * TODO: Move this to UI class, move location as well. Something like UI.track
		 * or Game.track, maybe track(level1Lore[currentWave]);
		 */

		System.out.println("You have entered " + location + ".\n");

		boolean levelCompleted = false;
		while (!levelCompleted) {

			int livingMobs = 0;
			for (Enemy mob : mobs) {
				if (mob.isAlive()) {
					livingMobs++;
				}
			}
			System.out.println("There are " + livingMobs + " enemies remaining: ");

			Enemy.enemyCount(mobs);

			battlePhase(band, mobs);

			levelCompleted = !(checkStatus(mobs));
		}

	}

	/**
	 * This method contains the current "First level" of the game. As of now each
	 * level contains "waves" and the band must defeat all waves to proceed to the
	 * next level. Progress is reset until next level.
	 */
	private static void level1() {

		/**
		 * Used to determine what index of enemyWaves to call. All enemy waves are in a
		 * 2D array. Might find a better solution but this works fine for now.
		 */
		int currentWave;

		Lore.level1Start();

		currentWave = 0;
		fight(Lore.level1Locations[currentWave].getLocation(), EnemyWaves.level1[currentWave]);

		// FIXME: #2 Error #1 comes starts after level 2 starts
		currentWave = 1;
		fight(Lore.level1Locations[currentWave].getLocation(), EnemyWaves.level1[currentWave]);

		/*
		 * TODO: 4 sections per level, 4th is boss
		 *
		 * int currentWave = 2; fight(Lore.level1Locations[currentWave].getLocation(),
		 * enemyWaves[currentWave]);
		 *
		 * currentWave = 3; fight(Lore.level1Locations[currentWave].getLocation(),
		 * enemyWaves[currentWave]);
		 *
		 */

	}

	/**
	 * Regens the health and life for a group of enemies or players. Mainly used for
	 * when players complete a level or heal at some other situation
	 *
	 * @param group Group of enemies/player
	 */
	private static void resetGroups(Entity[] group) {
		for (Entity entity : group) {
			entity.reset();
		}

	}

	/**
	 * Regens the health and life for 2 groups of enemies or players. This one was
	 * made for when level resets occur and need both group's stats to be reset
	 *
	 * @param group1 1st group of enemies/player
	 * @param group2 2nd group of enemies/player
	 */
	private static void resetGroups(Entity[] group1, Entity[] group2) {
		for (Entity entity : group1) {
			entity.reset();
		}

		for (Entity entity : group2) {
			entity.reset();
		}
	}

	/**
	 * Start() is essentially the main method, but is abstracted away for cleaner
	 * visuals.
	 */
	public static void Start() {

		UI.startMenu();
		level1();

		// level2()
		// level3()
		// etc...
	}

}
