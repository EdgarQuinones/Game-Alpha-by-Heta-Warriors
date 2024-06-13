package alpha.other;

/**
 * All "Entities" (Enemies, playable characters, 
 * and other living things that fight all have 
 * abilities. The "Ability" class helps by 
 * taking care of the damage, naming, and 
 * determining if is an AOE attack.
 */
public class Ability {
	
	private final String NO_TYPE = "None"; // Type 1
	private final String DAMAGE_TYPE = "Damage"; // Type 2
	private final String HEAL_TYPE = "Heal";  // Type 3
	private final String BOOST_TYPE = "Boost"; // Type 4
	
	// Private instance variables 
	private String name;
	private int effect;
	private boolean isAOE;
	private String effectType;
	
	/**
	 * Default constructor will make 
	 * an ability with no real name, 
	 * a base damage of 10, and
	 * not being AOE(Area of Effect). These can 
	 * be changed after if wanted to.
	 */
	public Ability() {
		this.name = "Ability Name";
		this.effect = 10;
		this.isAOE = false;
		effectType = NO_TYPE;
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
		this.effect = damage;
		this.isAOE = isAOE;
		this.effectType = NO_TYPE;
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
	
	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}

	public String getEffectType() {
		return effectType;
	}

	public void setEffectType(int effectType) {
		//MUST BE 1 OF 4 TYPES ABOVE
		
		switch(effectType) {
		case 1 -> this.effectType = NO_TYPE;
		case 2 -> this.effectType = DAMAGE_TYPE;
		case 3 -> this.effectType = HEAL_TYPE;
		case 4 -> this.effectType = BOOST_TYPE;
		}

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
		return name + "\nDamage: " + effect + "\nAOE: " + isAOE;
	}

}
