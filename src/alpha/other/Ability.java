package alpha.other;

public class Ability {
	
	private String name;
	private int damage;
	private boolean isAOE;
	
	public Ability() {
		this.name = "Ability Name";
		this.damage = 10;
		this.isAOE = false;
	}
	
	public Ability(String name, int damage, boolean isAOE) {
		this.name = name;
		this.damage = damage;
		this.isAOE = isAOE;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public boolean isAOE() {
		return isAOE;
	}
	public void setAOE(boolean isAOE) {
		this.isAOE = isAOE;
	}

	public static void displayAbilities(Ability[] abilities) {
		int counter = 1;
		for(Ability ability : abilities) {
			System.out.println("Ability "+counter+": \n"+ability+"\n");
			counter++;
		}
	}
	
	@Override
	public String toString() {
		return name + "\nDamage: " + damage + "\nAOE? " + isAOE;
	}

}
