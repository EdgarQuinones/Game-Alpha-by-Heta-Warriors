package alpha.characters.enemies;

/**
 * Bosses are strong, multi-demensional 
 * creatures that players need to be wary around.
 * They tend to have 1-2 single target abilities, 
 * along with an AEO ability. You usually only see
 * one, but tagged along with some minions.
 */
public class Boss extends Enemy{

	/**
	 * More detailed boss
	 * @param name Name of the boss
	 * @param health Health of the boss
	 * @param damage Amount of damage boss does
	 * @param defence Amount of defence boss has
	 * @param size The number of abilities the boss has
	 */
	public Boss(String name, int health, int damage, int defence, int size) {
		super(name, health, damage, defence, size);
	}


	

}
