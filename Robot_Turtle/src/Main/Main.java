package Main;

import java.util.Random;

public class Main {
	public static int nombreJoueurs;
	public static Player[] listeJoueurs; //liste contenant tous les joueurs présents dans le jeu
	public static Card[] deck; //Toutes les cartes du jeu
	public static Player[] tours; //file contenant les joueurs du jeu
	
	public static void main(String[] args) {
		Interface.StartMenu(); //Initialisation Menu
		Interface.Open(); //ouverture interface graphique
	}
	
	public static void newGame(int p) { //nouvelle partie
		Board board = new Board(); 
		board.Initialisation(); //reset du plateau
		shufflePlayers();
		shuffleDeck();
	}

	
	public static void shuffleDeck() {
        for (int i = 0; i < 37; i++) {
        	deck[i].setType(0);
        }
        Random rand = new Random();
		int a = 3; //nombre total de cartes lasers dans le jeu
		do {
			int i = rand.nextInt(36);
			if (deck[i].getType() == 0) {
	        	deck[i].setType(3);
	        	a = a - 1;
			}
		} while (a != 0);
		a = 8; // nombre total de cartes violettes
		do {
			int i = rand.nextInt(36);
			if (deck[i].getType() == 0) {
	        	deck[i].setType(2);
	        	a = a - 1;
			}
		} while (a != 0);
		a = 8; // nombre total de cartes jaunes
		do {
			int i = rand.nextInt(36);
			if (deck[i].getType() == 0) {
	        	deck[i].setType(1);
	        	a = a - 1;
			}
		} while (a != 0);
	}
	
	
	public static void shufflePlayers() {
		
	}
}
