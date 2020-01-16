package Main;

import java.util.Random;

public class Main {
	public static int nombreJoueurs;
	public static Joueur[] listeJoueurs; //liste contenant tous les joueurs présents dans le jeu
	public static Carte[] deck; //Toutes les cartes du jeu
	public static Joueur[] tours; //file contenant les joueurs du jeu
	
	public static void main(String[] args) {
		Interface.InitialiserMenu(); //Initialisation Menu
		Interface.Open(); //ouverture interface graphique
	}

	public static void newGame() { //nouvelle partie
		Plateau board = new Plateau(); 
		board.Initialisation(); //reset du plateau
		shufflePlayers();
		shuffleDeck();
	}
	
	public static void newPlayer() {
		Joueur a = new Joueur();
		listeJoueurs[Main.nombreJoueurs] = a;
		nombreJoueurs = Main.nombreJoueurs + 1;
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
