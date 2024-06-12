package alpha.characters;

import alpha.other.Ability;

public class Entity {


	protected int maxHealth;
	protected int health;
	protected int damage;
    protected int level;
    protected int defence;
    protected boolean isAlive;
    protected String name;	
    protected Ability[] abilities;
    
    public Entity(String name, int health, int damage, int defence) {
    	this.name = name;
    	this.health = health;
    	this.damage = damage;
    	this.defence = defence;
    	this.level = 1;
    	this.maxHealth = health;
    	this.isAlive = true;
    	
    	this.abilities = new Ability[3];
    	for(int i = 0; i < abilities.length; i++){
    		int num = i+1;
    		abilities[i] = new Ability("Ability "+num, damage, false);
    	}
    	this.abilities[0].setAOE(false);
    	this.abilities[1].setAOE(true);
    	this.abilities[2].setAOE(true);
    	
    }
    
    public void renameAllAbilities(String ability1, String ability2, String ability3) {
    	abilities[0].setName(ability1);
    	abilities[1].setName(ability2);
    	abilities[2].setName(ability3);

    }
    
    public Entity(String name) {
    	this.name = name;
    	this.health = 100;
    	this.damage = 10;
    	this.defence = 5;
    	this.level = 1;
    	this.maxHealth = health;
    	this.isAlive = true;
    	
    	abilities = new Ability[3];
    	for(int i = 0; i < abilities.length; i++){
    		int num = i + 1;
    		abilities[i] = new Ability("Ability "+num, damage, false);
    	}
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

	private void setDefence(int defence) {
		this.defence = defence;
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

	private void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	private void setDamage(int damage) {
		this.damage = damage;
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
	
	public void reset() {
		this.health = this.maxHealth;
		this.isAlive = true;
	}

}
