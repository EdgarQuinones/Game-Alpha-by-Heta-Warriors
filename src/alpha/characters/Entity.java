package alpha.characters;

import alpha.other.Ability;

/**
 * The Entity class is what handles all living creatures stats. This includes
 * Enemies and Players. The main stats everyone has is Health, Damage, and
 * defence. There are tweaks need to be made but this is it for now.
 */
public class Entity {

	// Protected variables to child classes can use them

	/**
	 * maxHealth of Enetity
	 */
	protected Ability[] abilities;

	/**
	 * damage of Enetity
	 */
	protected int damage;

	/**
	 * defence of Enetity
	 */
	protected int defence;

	/**
	 * current health of Enetity
	 */
	protected int health;

	/**
	 * boolean checking if alive for Enetity
	 */
	protected boolean isAlive;

	// TODO: Figure out implementation for level
	/**
	 * current level of Enetity
	 */
	protected int level;

	/**
	 * maxHealth of Enetity
	 */
	protected int maxHealth;

	/**
	 * name of the Enetity
	 */
	protected String name;

	/**
	 * maxHealth of Enetity
	 */
	protected int numberOfAbilities;

	/**
	 * For simpilar characters like minions and nps, I wanted to give a simple
	 * default constructor, you do need to add a name though.
	 *
	 * @param name Name of the entity
	 */
	public Entity(String name) {
		this.name = name;
		this.health = 100;
		this.damage = 10;
		this.defence = 5;
		this.level = 1;
		this.maxHealth = health;
		this.isAlive = true;
		numberOfAbilities = 1;
		abilities = new Ability[1];
		abilities[0] = new Ability("Ability 1", damage, false);

	}

	/**
	 * Gives child classes the ability to be as detailed as possible when giving all
	 * the important stats needed in a turn-based rpg
	 *
	 * @param name              Name of the entity
	 * @param health            Health of the entity
	 * @param damage            Damage of the entity
	 * @param defence           Defence of the entity
	 * @param numberOfAbilities The number of abilities an entity will have
	 */
	public Entity(String name, int health, int damage, int defence, int numberOfAbilities) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.defence = defence;
		this.level = 1;
		this.maxHealth = health;
		this.isAlive = true;
		this.numberOfAbilities = numberOfAbilities;

		this.abilities = new Ability[numberOfAbilities];
		for (int i = 0; i < numberOfAbilities; i++) {
			int num = i + 1;
			abilities[i] = new Ability("Ability " + num, damage, false);
		}

	}

	/**
	 * Returns the current enetities damage as long as they are alive, if not it
	 * will simply return 0
	 *
	 * @return The entities damage
	 */
	public int attack() {
		if (this.isAlive) {
			return damage;
		} else {
			return 0;
		}

	}

	/**
	 *
	 * @return The ability array, as all entities store their abilities in an array
	 */
	public Ability[] getAbilities() {
		return abilities;
	}

	/**
	 *
	 * @return The entities damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 *
	 * @return The defence of an entity
	 */
	public int getDefence() {
		return defence;
	}

	/**
	 *
	 * @return The entities health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 *
	 * @return The entities level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 *
	 * @return The maxhealth of an entity
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 *
	 * @return The name of an entity
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @return The number of abilites an entity has
	 */
	public int getNumberOfAbilities() {
		return abilities.length;
	}

	/**
	 * Handles how Entities take damage, while a more advance defence stat will be
	 * made, for not it blocks a flat amount. So if you have more defence than
	 * someone's damage, they will always do 0 damage. This means as of now people
	 * need to either do alot of damage, or defence needs to be very low.
	 *
	 * @param damage The damage the entity is about to take.
	 */
	public void hurt(int damage) {

		// TODO: Figure out new calculation for defence stat
		damage = damage - defence;
		if (damage < 0) {
			damage = 0;
		}

		this.health = this.health - damage;

		if (this.health <= 0) {
			this.health = 0;
			this.setAlive(false);
			System.out.println(this.name + " has been elimited!");
		}
	}

	/**
	 *
	 * @return The bool determining if the entity is alive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Increases level a certain number of times
	 *
	 * @param level Number of levels the entity is increasing
	 */
	protected void levelUp(int level) {
		level += level;
	}

	/**
	 * Used for when a band fails and need to restart a level.
	 */
	public void reset() {
		this.health = this.maxHealth;
		this.isAlive = true;
	}

	/**
	 * New set of abilities to a new one with a new array of abilities, but it wont
	 * work if the size is not the same as numberOfAbilities
	 *
	 * @param abilities New set of abilities
	 */
	public void setAbilities(Ability[] abilities) {
		if (abilities.length == this.numberOfAbilities) {
			this.abilities = abilities;
		}
	}

	/**
	 *
	 * @param isAlive The new bool determining if the entity is alive
	 */
	private void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 *
	 * @param maxHealth New maxhealth of an entity
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 *
	 * @param name The new name of an entity
	 */
	public void setName(String name) {
		this.name = name;
	}

}
