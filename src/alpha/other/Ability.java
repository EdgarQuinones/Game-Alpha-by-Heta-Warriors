package alpha.other;

/**
 * All "Entities" (Enemies, playable characters, 
 * and other living things that fight all have 
 * abilities. The "Ability" class helps by 
 * taking care of the damage, naming, and 
 * determining if is an AOE attack.
 */
public class Ability {
	
	/**
	 * The name of the ability
	 */
	private String name;
	
	/**
	 * The effect/power of the ability
	 */
	private int effect;
	
	/**
	 * Whether or not the ability is AOE
	 */
	private boolean isAOE;
	
	/**
	 * The effectType of the ability, 1 of 4
	 */
	private String effectType;
	
	/**
	 * All abilities will have 1 of 4 types.
	 * These types will be implemented later 
	 * to determine what the ability does.
	 */
	
	/**
	 * Used when an ability has not been set yet
	 */
	private final String NO_TYPE = "None"; // Type 1
	/**
	 * Used for damaging abilities, reduces the health of another
	 */
	private final String DAMAGE_TYPE = "Damage"; // Type 2
	/**
	 * Used for healing, increases the health of others
	 */
	private final String HEAL_TYPE = "Heal"; // Type 3	
	/**
	 * Temporary boost of stats, this can be health, damage, defence, etc...
	 */
	private final String BOOST_TYPE = "Boost"; // Type 4
	
	
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
	 * @param effect The effectiveness of the ability, should be relativly low as it will
	 * scale with the players damage/power.
	 * @param isAOE Used with a different function to deterime if a ability is AOE (Area of Effect).
	 */
	public Ability(String name, int effect, boolean isAOE) {
		this.name = name;
		this.effect = effect;
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
	
	/**
	 * 
	 * @return effective power of said ability
	 */
	public int getEffect() {
		return effect;
	}

	/**
	 * 
	 * @param effect New effective power of said ability
	 */
	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	/**
	 * 
	 * @return Current effective power of said ability
	 */
	public String getEffectType() {
		return effectType;
	}

	/**
	 * Sets the effectTypes of an ability. There are
	 * only 4 types, while there is no check for error, 
	 * this is handled in the back-end so hopefully no issues.
	 * @param effectType Effect type based on numbers
	 */
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
	public String toString() {
		return name + "\nDamage: " + effect + "\nAOE: " + isAOE;
	}

}
