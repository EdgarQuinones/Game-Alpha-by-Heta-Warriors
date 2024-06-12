package alpha.other;

/**
 * All "Entities" (Enemies, playable characters, 
 * and other living things that fight all have 
 * abilities. The "Ability" class helps by 
 * taking care of the damage, naming, and 
 * determining if is an AOE attack.
 */
public class Ability {
	
	// TODO: change damage to something else, should be able to be used as healing too.
	// Private instance variables 
	private String name;
	private int damage;
	private boolean isAOE;
	
	/**
	 * Default constructor will make 
	 * an ability with no real name, 
	 * a base damage of 10, and
	 * not being AOE(Area of Effect). These can 
	 * be changed after if wanted to.
	 */
	public Ability() {
		this.name = "Ability Name";
		this.damage = 10;
		this.isAOE = false;
	}
	
	/**
	 * A constructor that allows to choose all the stats beforehand. 
	 * @param name The name of the ability 
	 * @param damage The damage of the ability, should be relativly low as it will
	 * scale with the players damage/power.
	 * @param isAOE Used with a different function to deterime if a ability is AOE (Area of Effect).
	 */
	public Ability(String name, int damage, boolean isAOE) {
		this.name = name;
		this.damage = damage;
		this.isAOE = isAOE;
	}

	/**
	 * 
	 * @return The abilities name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name The new name of the ability
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return The abilities damage
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * 
	 * @param damage The damage the abilty will now do
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * 
	 * @return Whether or not the ability is an AOE spell
	 */
	public boolean isAOE() {
		return isAOE;
	}
	
	/**
	 * 
	 * @param isAOE Decides if the spell is AOE or not
	 */
	public void setAOE(boolean isAOE) {
		this.isAOE = isAOE;
	}

	/**
	 * Used in combination with the toString() method to properly
	 * display a group of spells. Most, if not all Entities will
	 * have more than one ability, so it is needed. 
	 * @param abilities The set of abilities a Entity will have.
	 */
	public static void displayAbilities(Ability[] abilities) {
		int counter = 1;
		for(Ability ability : abilities) {
			System.out.println("Ability "+counter+": \n"+ability+"\n");
			counter++;
		}
	}
	
	/**
	 * Prints an ability's name, damage, and whether it is AOE or not.
	 */
	@Override
	public String toString() {
		return name + "\nDamage: " + damage + "\nAOE: " + isAOE;
	}

}
