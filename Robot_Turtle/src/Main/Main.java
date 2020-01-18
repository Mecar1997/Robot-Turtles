package Main;

import java.util.Random;
import java.util.Scanner;


public class Main {
	public static int numberPlayers;
	public static Player[] playersList = new Player[4]; //liste contenant tous les joueurs présents dans le jeu
	public static Player[] tours; //file contenant les joueurs du jeu
	public static Board board = new Board();
	
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
		board.Initialisation(); //reset du plateau
		for (int j = 0; j < p; j++) {
			addPlayer(j);
		}
		setStartPositions();
		board.show();
		//listPlayers(); // DEBUG 
	}
	
	public static void addPlayer(int k) {
		playersList[k] = new Player(k);
		System.out.println("DEBUG: Joueur " + k + " ajouté. Son nom est " + playersList[k].getName() + " et sa couleur est le " + playersList[k].getColor());
		playersList[k].shuffleDeck();
	}
	
	public static void listPlayers() {
		for (int i = 0; i < playersList.length; i++) {
			System.out.println("DEBUG: Joueur " + i + ". Son nom est " + playersList[i].getName() + " et sa couleur est le " + playersList[i].getColor());
		}
	}
	
	public static void setStartPositions() {
		if (numberPlayers == 4) {
			playersList[0].setStartPosition(0,0);
			playersList[1].setStartPosition(0,2);
			playersList[2].setStartPosition(0,5);
			playersList[3].setStartPosition(0,7);
		} else if (numberPlayers == 3) {
			playersList[0].setStartPosition(0,0);
			playersList[1].setStartPosition(0,3);
			playersList[2].setStartPosition(0,6);
		} else if (numberPlayers == 2) {
			playersList[0].setStartPosition(0,1);
			playersList[1].setStartPosition(0,5);
		}
	}
	
	
}
