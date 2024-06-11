package alpha.characters;
public class Entity {


	protected int maxHealth;
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	protected int health;
	protected int damage;
    protected int level;
    protected int defence;
    protected boolean isAlive;
    protected String name;	

    public Entity(String name, int health, int damage, int defence) {
    	this.name = name;
    	this.health = health;
    	this.damage = damage;
    	this.defence = defence;
    }
    
	public Entity(String name) {
		this.health = 100;
		this.damage = 10;
		this.level = 1;
		this.isAlive = true;
		this.name = name;
		this.defence = 5;
		this.maxHealth = health;
	}
	
    public Entity(int health, int damage, int level, String name, int defence) {
		super();
		this.health = health;
		this.damage = damage;
		this.level = level;
		this.isAlive = true;
		this.name = name;
		this.defence = defence;
		this.maxHealth = health;
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
    
    public void hurt(int damage) {
    	
    	damage = damage * ((100 - this.defence) / 100);
    	
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

}
