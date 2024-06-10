package alpha.characters.enemies;

import alpha.characters.Entity;

public class Enemy extends Entity{

	public Enemy(int health, int damage, int level, int defence, String name) {
		super(health, damage, level, name, defence);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "* "+this.getName()+"\n    Level "+this.getLevel();
	}

	public Enemy(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
}
