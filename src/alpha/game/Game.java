package alpha.game;

import java.util.ArrayList;
import java.util.Random;
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
		while(!levelCompleted && bandIsAlive) {
			
			int livingMobs = 0;
			for(Enemy mob : mobs ) {
				if(mob.isAlive()) livingMobs++;
			}
			System.out.println("There are "+livingMobs+" enemies remaining: ");
			
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
			
			levelCompleted = checkEnemies(mobs);
		}
		if(levelCompleted && bandIsAlive) {
			return true;//goes to level 2
		}else {
			return false;//restarts level
		}
	}
	

	private static boolean battlePhase(Player[] band, Enemy[] mobs) {
		
		boolean bandIsAlive = true;
		Scanner scnr = new Scanner(System.in);
		int choice;
		int playerDamage = 0;
		int enemyDamage = 0;
		Ability[] playerAbilities;
		String playerName = "";
		for(Player member : band) {
			
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
		System.out.println();
		
		if(checkStatus(band)) {
			return true;
		}else {
			return false;
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
