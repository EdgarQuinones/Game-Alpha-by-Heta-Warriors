package alpha.main;

import alpha.characters.*;

public class Main {
    
    public static void main(String[] args) {
    	Player player1 = new Player("Arashi");
    	Player player2 = new Player("Jimmy Newtron");
    	
//    	System.out.println(player1);
//    	System.out.println(player2);
    	
//    	player1.hurt(player2.attack());
    	
    	while(player1.isAlive()) {
    		player1.hurt(player2.attack());
    		player2.hurt(player1.attack());
    		
    		System.out.println(player1.getHealth());
        	System.out.println(player2.getHealth());
    	}
    }

}