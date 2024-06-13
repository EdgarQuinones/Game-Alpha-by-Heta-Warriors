package alpha.characters.enemies;

import alpha.characters.Entity;

public class Enemy extends Entity{

	
	
	public Enemy(String name) {
		super(name);
	}

	public Enemy(String name, int health, int damage, int defence) {
		super(name, health, damage, defence);
	}

	@Override
	public String toString() {
		if(this.isAlive) {
			return this.name 							+
				"\n  - "+this.health+"/"+this.maxHealth+" HP" +
				"\n  - "+this.defence + " DEF"  				+
				"\n  - "+"Level "+this.level;
		}else {
			return "Enemy Elimited.";
		}
		
	}

}
