package alpha.characters.enemies;

/**
 * Minions are weak creatures that tend to pose no threat, but can be a bit
 * tricky in high numbers. Only contains 1 single target ability as of now.
 */
public class Minion extends Enemy {

	/**
	 * Due to the simpleness of minions, I made a constructor for just putting their
	 * name, unsure how often I will use this later on.
	 *
	 * @param name Name of the minion
	 */
	public Minion(String name) {
		super(name);
	}

	/**
	 * More detailed minion
	 *
	 * @param name    Name of the minion
	 * @param health  Health of the minion
	 * @param damage  Amount of damage minion does
	 * @param defence Amount of defence minion has
	 * @param size    The number of abilities the minion has
	 */
	public Minion(String name, int health, int damage, int defence, int size) {
		super(name, health, damage, defence, size);
	}

}
