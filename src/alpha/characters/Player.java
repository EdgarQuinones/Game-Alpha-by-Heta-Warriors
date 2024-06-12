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

	public Player(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	public Player(String name, int health, int damage, int defence) {
		super(name, health, damage, defence);
		// TODO Auto-generated constructor stub
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
