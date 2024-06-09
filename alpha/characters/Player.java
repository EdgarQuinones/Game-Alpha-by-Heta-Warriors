package alpha.characters;

public class Player extends Entity{

	private int experiencePoints;
	private String lightAttack;
	private String heavyAttack;
	private String movementAbility;
	private String specialAttack;
	
	public Player(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.lightAttack = "Light Attack";
		this.heavyAttack = "Heavy Attack";
		this.movementAbility = "Movement Ability";
		this.specialAttack = "Special Attack";
	}

	public Player(int health, int damage, int level, String name, int experiencePoints, String lightAttack, String heavyAttack, String movementAbility, String specialAttack) {
		super(health, damage, level, name);
		// TODO Auto-generated constructor stub
		this.experiencePoints = experiencePoints;
		this.lightAttack = lightAttack;
		this.heavyAttack = heavyAttack;
		this.movementAbility = movementAbility;
		this.specialAttack = specialAttack;
	}

	public String getLightAttack() {
		return lightAttack;
	}

	public void setLightAttack(String lightAttack) {
		this.lightAttack = lightAttack;
	}

	public String getHeavyAttack() {
		return heavyAttack = "";
	}

	public void setHeavyAttack(String heavyAttack) {
		this.heavyAttack = heavyAttack;
	}

	public String getMovementAbility() {
		return movementAbility;
	}

	public void setMovementAbility(String movementAbility) {
		this.movementAbility = movementAbility;
	}

	public String getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(String specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	private void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}
	
}
