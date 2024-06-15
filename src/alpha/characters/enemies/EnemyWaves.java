package alpha.characters.enemies;

/**
 * Stores all the enemy waves for all levels. They will be stored in 2D arrays
 * since each level will have multiple sections.
 */
public class EnemyWaves {

	/**
	 * First level, currently contains 2 sections, but will certainly have more at a
	 * later date
	 */
	public static Enemy[][] level1 = {
			{ new Minion("Mysterious Minion"), new Minion("Wild Minion"), new Minion("Primeval Minion"),
					new Minion("Silly Minion") },
			{ new Minion("Cold-blooded Minion"), new Minion("Frosty Minion"), new Minion("Frigid Minion") } };

	// Will add more levels later on...

}
