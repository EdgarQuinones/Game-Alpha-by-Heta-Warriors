package alpha.characters;

import alpha.other.Ability;

/**
 * The Entity class is what handles all living creatures stats. 
 * This includes Enemies and Players. The main stats everyone 
 * has is Health, Damage, and defence. There are tweaks need to
 * be made but this is it for now.
 */
public class Entity {

	// Note: Not all instance variables are currently being used yet.
	// Protected variables to child classes can use them
	protected int maxHealth;
	protected int health;
	protected int damage;
    protected int level;
    protected int defence;
    protected boolean isAlive;
    protected String name;	
    protected Ability[] abilities;
    protected int numberOfAbilities;
    
    public Entity(String name, int health, int damage, int defence, int size) {
    	this.name = name;
    	this.health = health;
    	this.damage = damage;
    	this.defence = defence;
    	this.level = 1;
    	this.maxHealth = health;
    	this.isAlive = true;
    	numberOfAbilities = size;
    	
    	// TODO: I dont want ALL entities to have 3 abilities by default
    	this.abilities = new Ability[numberOfAbilities];
    	for(int i = 0; i < numberOfAbilities; i++){
    		int num = i+1;
    		abilities[i] = new Ability("Ability "+num, damage, false);
    	}
    	
    }
    
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
    
    public int getNumberOfAbilities() {
    	return abilities.length;
    }
    
	public Ability[] getAbilities() {
		return abilities;
	}

	public void setAbilities(Ability[] abilities) {
		this.abilities = abilities;
	}

	

	public int getDefence() {
		return defence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int attack() {
    	if(this.isAlive) {
    		return damage;
    	}else {
    		return 0;
    	}
    	
    }

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

    /**
     * Handles how Entities take damage, while a more 
     * advance defence stat will be made, for not it blocks 
     * a flat amount. So if you have more defence than someone's
     * damage, they will always do 0 damage. This means as of now
     * people need to either do alot of damage, or defence needs to be 
     * very low.
     * @param damage The damage the entity is about to take.
     */
    public void hurt(int damage) {
    	
    	damage = damage - defence;
    	if(damage < 0) damage = 0;
    	
    	this.health = this.health - damage;
    	
    	if(this.health <= 0) {
    		this.health = 0;
    		this.setAlive(false);
    		System.out.println(this.name + " has been elimited!");
    	}
    }
    
	public int getHealth() {
		return health;
	}

	public int getDamage() {
		return damage;
	}

	public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		this.level = level;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	private void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	protected void levelUp() {
		this.setLevel(level++);
	}
	
	//Used for when a band fails and need to restart a level.
	public void reset() {
		this.health = this.maxHealth;
		this.isAlive = true;
	}

}
