package alpha.characters.enemies;

import alpha.characters.Entity;

/**
 * Is used as the template for all future enemies. This includes minions and
 * bosses. With more coming soon.
 */
public class Enemy extends Entity {

	/**
	 * Used to count how many of each enemy type is currently alive. Most likely
	 * will scale as more enemy types are made. It is displayed to the band of
	 * players every loop.
	 * 
	 * @param mobs The array of mobs currently fighting
	 */
	public static void enemyCount(Enemy[] mobs) {
		int minionCount = 0;
		int bossCount = 0;
		for (Enemy mob : mobs) {
			if (mob instanceof Minion && mob.isAlive()) {
				minionCount++;
			} else if (mob instanceof Boss && mob.isAlive()) {
				bossCount++;
			}
		}
		System.out.println("* " + minionCount + " Minions");
		System.out.println("* " + bossCount + " Bosses\n");
	}

	/**
	 * Base constructor using only their name for simple tests and very weak enemies
	 * 
	 * @param name Name of the enemy
	 */
	public Enemy(String name) {
		super(name);
	}

	/**
	 * More detailed enemy
	 * 
	 * @param name    Name of the enemy
	 * @param health  Health of the enemy
	 * @param damage  Amount of damage enemy does
	 * @param defence Amount of defence enemy has
	 * @param size    The number of abilities the enemy has
	 */
	public Enemy(String name, int health, int damage, int defence, int size) {
		super(name, health, damage, defence, size);
	}

	@Override
	public String toString() {
		if (this.isAlive) {
			return this.name + "\n  - " + this.health + "/" + this.maxHealth + " HP" + "\n  - " + this.defence + " DEF"
					+ "\n  - " + "Level " + this.level;
		} else {
			return "Enemy Elimited.";
		}

	}

}
