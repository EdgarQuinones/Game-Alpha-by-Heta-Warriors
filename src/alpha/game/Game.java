package alpha.game;

import java.util.ArrayList;
import java.util.Scanner;

import alpha.characters.Icon;
import alpha.characters.Player;
import alpha.characters.enemies.Boss;
import alpha.characters.enemies.Enemy;
import alpha.characters.enemies.Minion;
import alpha.other.Ability;
import alpha.other.Lore;

public class Game {
	
	private static String location;
	private static int minionCount;
	private static int bossCount;


	public static void Start(Player[] band) {
		
		//startMenu();
		Level1(band);
		
	}
	
	private static void Level1(Player[] band) {
		
		boolean battleOutcome;
		
		//Lore.level1Start();//lore for level 1
		
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

	private static void level1Intro() {
		// TODO Auto-generated method stub
		System.out.println("Lore of level 1"); 
	}

	private static void startMenu() {
		System.out.println("Welcome to...");
		Icon.menu();
		
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
	

	private static void battlePhase(Player[] band, Enemy[] mobs) {
		/*
		 * What ability would you like to use? ???
		 * 	loop player.display abilities
		 * 		1. single target, high dmg
		 * 		2. aoe, low dmg
		 *		3. speaical attack (WIP)
		 * */
		Scanner scnr = new Scanner(System.in);
		int choice;
		int playerDamage = 0;
		Ability[] playerAbilities;
		String playerName;
		for(Player member : band) {
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
			case 1 -> playerDamage = playerAbilities[0].getDamage();
			case 2 -> playerDamage = playerAbilities[1].getDamage();
			case 3 -> playerDamage = playerAbilities[2].getDamage();
			}
			
			}while(choice <= 0 || choice > member.getNumberOfAbilities());
			
			playerName = band[choice-1].getName();
			
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
							System.out.println(playerName+" did "+playerDamage+" to "+mobs[i].getName());
						}
					}
				}else {
					for(int i = 0; i < mobs.length; i++) {
							mobs[i].hurt(playerDamage);
							System.out.println(playerName+" did "+playerDamage+" to "+mobs[i].getName());
						}
					}
					
			
		}
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
	
	private static void displayEnemies(Enemy[] mobs) {
		System.out.println("Arena:");
		int counter = 1;
		for(Enemy mob : mobs) {
			System.out.println(counter+". "+mob);
			counter++;
		}
		System.out.println();
	}
	
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
