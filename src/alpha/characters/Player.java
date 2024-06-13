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

	public static final int NUMBER_OF_PLAYER_ABILITIES = 3;
	
	public Player(String name) {
		super(name);
	}


	public Player(String name, int health, int damage, int defence, int size) {
		super(name, health, damage, defence, size);
	}

	public void setAbilitiesNames(String name1, String name2, String name3) {
		this.abilities[0].setName(name1);
		this.abilities[1].setName(name1);
		this.abilities[2].setName(name1);
	}
	
	public void setAbilitiesAOE(boolean AOE1, boolean AOE2, boolean AOE3) {
		this.abilities[0].setAOE(AOE1);
		this.abilities[1].setAOE(AOE2);
		this.abilities[2].setAOE(AOE3);
	}
	
	public void setAbilitiesEffect(int effect1, int effect2, int effect3) {
		this.abilities[0].setEffect(effect1);
		this.abilities[1].setEffect(effect2);
		this.abilities[2].setEffect(effect3);
	}
	
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
