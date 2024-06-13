package alpha.characters.enemies;

import alpha.characters.Entity;

public class Enemy extends Entity{

	
	
	public Enemy(String name) {
		super(name);
	}

	public Enemy(String name, int health, int damage, int defence, int size) {
		super(name, health, damage, defence, size);
	}

	@Override
	public String toString() {
		if(this.isAlive) {
			return this.name 							+
				"\n  - "+this.health+"/"+this.maxHealth+" HP" +
				"\n  - "+this.defence + " DEF"  				+
				"\n  - "+"Level "+this.level;
		}else {
			return "Enemy Elimited.";
		}
		
	}

	/**
	 * @param mobs
	 */
	public static void enemyCount(Enemy[] mobs) {
		int minionCount = 0;
		int bossCount = 0;
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
	}

}
