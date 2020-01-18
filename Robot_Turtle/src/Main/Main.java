package Main;

import java.util.Random;
import java.util.Scanner;


public class Main {
	public static int numberPlayers;
	public static Player[] playersList = new Player[4]; //liste contenant tous les joueurs présents dans le jeu
	public static Player[] tours; //file contenant les joueurs du jeu
	
	public static void main(String[] args) {
		//Interface.StartMenu(); //Initialisation Menu
		//Interface.Open(); //ouverture interface graphique
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Entrez le nombre de joueurs");
		int a = scanner.nextInt();
		newGame(a);
	}
	
	public static void newGame(int p) { //nouvelle partie
		numberPlayers = p;
		System.out.println("Il y a " + numberPlayers + " joueurs");
		Board board = new Board(); 
		board.Initialisation(); //reset du plateau
		for (int j = 0; j < p; j++) {
			addPlayer(j);
		}
		setStartPositions();
		board.show();
	}
	
	public static void addPlayer(int k) {
		playersList[k] = new Player(k);
		System.out.println("DEBUG: Joueur " + k + " ajouté. Son nom est " + playersList[k].getName());
		playersList[k].shuffleDeck();
	}
	
	public static void setStartPositions() {
		if (numberPlayers == 4) {
			playersList[0].setStartPosition(0,7);	
		}
	}
	
	
}
