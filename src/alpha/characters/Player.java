package alpha.characters;

/**
 * The Player class is where the main band of 
 * characters reside. Players have various capabities with 
 * more being implemented. For now they are known for having 
 * 3 abilities. 1 single target ability, 1 AOE ability, and 
 * 1 special abilties. Not all abilties do damage as there 
 * are multiple classes.
 */
public class Player extends Entity{

	//While enemies may have varying abilities, for now players always have 3
	public static final int NUMBER_OF_PLAYER_ABILITIES = 3;

	/**
	 * Players need detail as they are the main characters
	 * @param name Name of the player
	 * @param health Health of the player
	 * @param damage Amount of damage player does
	 * @param defence Amount of defence player has
	 */
	public Player(String name, int health, int damage, int defence) {
		super(name, health, damage, defence, NUMBER_OF_PLAYER_ABILITIES);
	}

	/**
	 * Sets the name of all 3 abilities the player has
	 * @param name1 The first ability name
	 * @param name2 The second ability name
	 * @param name3 The third ability name
	 */
	public void setAbilitiesNames(String name1, String name2, String name3) {
		this.abilities[0].setName(name1);
		this.abilities[1].setName(name1);
		this.abilities[2].setName(name1);
	}
	
	/**
	 * Sets the boolean value of all 3 abilities the player has
	 * @param AOE1 The first AOE value
	 * @param AOE2 The second AOE value
	 * @param AOE3 The third AOE value
	 */
	public void setAbilitiesAOE(boolean AOE1, boolean AOE2, boolean AOE3) {
		this.abilities[0].setAOE(AOE1);
		this.abilities[1].setAOE(AOE2);
		this.abilities[2].setAOE(AOE3);
	}
	
	/**
	 * Sets the effect of all 3 abilities the player has
	 * @param effect1 The first effect value
	 * @param effect2 The second effect value
	 * @param effect3 The third effect value
	 */
	public void setAbilitiesEffect(int effect1, int effect2, int effect3) {
		this.abilities[0].setEffect(effect1);
		this.abilities[1].setEffect(effect2);
		this.abilities[2].setEffect(effect3);
	}
	
	/**
	 * Sets the effectType of all 3 abilities the player has
	 * @param effectType1 The first effectType
	 * @param effectType2 The second effectType
	 * @param effectType3 The third effectType
	 */
	public void setAbilitiesEffectType(int effectType1, int effectType2, int effectType3) {
		this.abilities[0].setEffectType(effectType1);
		this.abilities[1].setEffectType(effectType2);
		this.abilities[2].setEffectType(effectType3);
	}
	
	@Override
	public String toString() {
		if(this.isAlive) {
			return this.name 							+
				"\n  - "+this.health+"/"+this.maxHealth+" HP" +
				"\n  - "+this.defence + " DEF"  				+
				"\n  - "+"Level "+this.level;
		}else {
			return this.name+" has been Elimited.";
		}
		
	}

	
}
