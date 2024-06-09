package alpha.characters;
public class Entity {


	private int health;
    private int damage;
    private int level;
	private boolean isAlive;
	private String name;
	private Icon icon;
	

	public Entity(String name) {
		this.health = 100;
		this.damage = 10;
		this.level = 1;
		this.isAlive = true;
		this.name = name;
	}
	
    public Entity(int health, int damage, int level, String name) {
		super();
		this.health = health;
		this.damage = damage;
		this.level = level;
		this.isAlive = true;
		this.name = name;
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
    	health = health - damage;
    	
    	if(health <= 0) {
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

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	

}
