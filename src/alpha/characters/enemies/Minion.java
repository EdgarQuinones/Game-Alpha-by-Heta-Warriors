package alpha.characters.enemies;

/**
 * Minions are weak creatures that tend
 * to pose no threat, but can be a bit tricky 
 * in high numbers. Only contains 1 single target ability
 * as of now.
 */
public class Minion extends Enemy{

	public Minion(String name) {
		super(name);
	}

	public Minion(String name, int health, int damage, int defence, int size) {
		super(name, health, damage, defence, size);
	}
	

}
