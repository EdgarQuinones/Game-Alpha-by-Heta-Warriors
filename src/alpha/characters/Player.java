package alpha.characters;

import alpha.other.Ability;

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
