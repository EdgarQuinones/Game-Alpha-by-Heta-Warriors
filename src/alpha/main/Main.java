package alpha.main;

import alpha.characters.*;
import alpha.game.Game;

public class Main {
    
    public static void main(String[] args) {
    	
    	Player EJ = new Player("Samurai", 150, 30, 25);//mid health, mid dmg (Brawler)
    	Player Papi = new Player("Wolverine", 200, 20, 30); // high health, low-mid dmg (Tank)
    	Player Jada= new Player("Flame Spirit", 125, 50, 10); //low health, high dmg (Glass cannon)
    	Player Marielle = new Player("Executioner",125, 40, 20); //mid health, high dmg (Assasin)
    	Player Vinny = new Player("Mender", 100, 10, 10); //low health, low dmg (healer)
    	Player[] band = {EJ, Papi, Jada, Vinny, Marielle};
    	
    	EJ.renameAllAbilities("Thunder Clap","Tempest Strike", "Eye of the Storm");
    	
    	Game.Start(band);
    	
    	
    }

}