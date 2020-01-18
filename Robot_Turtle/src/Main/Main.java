package Main;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static int numberPlayers;
	public static Player[] playersList = {new Player(0),new Player(1),new Player(2),new Player(3)}; //liste contenant tous les joueurs possibles dans le jeu
	public static ArrayDeque<Player> turns = new ArrayDeque<>(); //file contenant les joueurs du jeu dans l'ordre de leurs tours
	public static Board board = new Board();
	public static Player currentPlayer = new Player(0); // Joueur qui passe son tour actuellement
	public static Player lastPlayer; //Joueur qui vient de finir son tour
	
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
		// shufflePlayers(); // Ne marche pas actuellement
		for (int j = 0; j < p; j++) {
			addPlayer(j);
		}
		setStartPositions();
		board.show();
		listPlayers(); // DEBUG 
		nextTurn();
	}
	
	public static void addPlayer(int k) {
		System.out.println("DEBUG: Joueur " + k + " ajouté. Son nom est " + playersList[k].getName() + " et sa couleur est le " + playersList[k].getColor());
		turns.add(playersList[k]);
		turns.peekLast().shuffleDeck();
		turns.peekLast().drawCard();
	}
	
	public static void shufflePlayers() {
		System.out.println("DEBUG: Mélange des joueurs");
		List<Player> ShuffleList = new ArrayList<>();
		for (int i = 1; i < playersList.length; i++) {
			ShuffleList.add(playersList[i]);
		}
		Collections.shuffle(ShuffleList);
		for (int i = 1; i < ShuffleList.size(); i++) {
			playersList[i]=ShuffleList.remove(i);
		}
	}
	
	public static void listPlayers() {
		Object[] l=turns.toArray();
		for (int i = 0; i < l.length; i++) {
			System.out.println("DEBUG: Joueur " + i + ". Son nom est " + ((Player) l[i]).getName() + " et sa couleur est le " + ((Player) l[i]).getColor());
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
	
	public static void nextTurn() {
		if (lastPlayer == null) { //premier tour
			lastPlayer = new Player(0);
		} else {
			lastPlayer = currentPlayer;
			turns.add(lastPlayer);
		}
		currentPlayer = turns.pop();
		commandChoice();
	}
	
	
	public static void endTurn() {
		int a =0;
		Scanner scanner = new Scanner(System.in);
		do {System.out.println(currentPlayer.getName() + ", votre tour est fini.\r\n" + 
				"Tapez 1 pour défausser votre main.\r\n" + 
				"Tapez 2 pour terminer\r\n");
			a = scanner.nextInt();
		} while (a < 1 || a > 2);
		if (a == 1) {
			currentPlayer.discardHand();
			nextTurn();
		} else {
			nextTurn();
		}
	}
	
	
	public static void commandChoice() {
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		do {System.out.println("DEBUG: Tour du joueur " + currentPlayer.getName() + ". Prochain joueur: " + turns.getFirst().getName() + "\r\n" + 
				"Tapez 1 pour passer votre tour.\r\n" + 
				"Tapez 2 pour afficher votre main\r\n" + 
				"Tapez 3 pour placer un mur\r\n" +
				"Tapez 4 pour afficher votre programme actuel\r\n" + 
				"Tapez 5 pour compléter votre programme\r\n" + 
				"Tapez 6 pour afficher le plateau.\r\n");
			a = scanner.nextInt();
		} while (a < 1 || a > 6);
		if (a == 1) {
			endTurn();
		} else if (a == 2) {
			currentPlayer.showHand();
			commandChoice();
		} else if (a == 3) {
			wallChoice();
		} else if (a == 6) {
			board.show();
			commandChoice();
		} else {
			commandChoice();
		}
	}
	
	public static void wallChoice() {
		int a = 0; int b = 0; int c = 0;
		Scanner scanner = new Scanner(System.in);
		do {System.out.println("DEBUG: Joueur " + currentPlayer.getName() + " possède " + currentPlayer.wallStone + " mur(s) de pierre et " + currentPlayer.wallIce + " mur(s) de glace \r\n" + 
				"Tapez 1 pour placer un mur de pierre.\r\n" + 
				"Tapez 2 pour placer un mur de glace\r\n");
			a = scanner.nextInt();
		} while (a < 1 || a > 2);
		if (a == 1) {
			System.out.println("Entrez les coordonnées pour placer le mur de pierre");
		} else {
			System.out.println("Entrez les coordonnées pour placer le mur de glace");
		}
		do {System.out.print("X: ");
		b = scanner.nextInt();
		} while (b < 0 || b > 7);
		do {System.out.print("Y: ");
		c = scanner.nextInt();
		} while (c < 0 || c > 7);
		System.out.println("");
		// TODO:  Empêcher un joueur de bloquer une tortue ou un joyau
		if (board.grid[b][c].getType() == 0) {
			board.grid[b][c].setType(a);
			currentPlayer.removeWall(a);
			System.out.println("Le mur a été placé");
		} else {
			System.out.println("ERREUR: L'emplacement indiqué n'est pas vide");
		}

		endTurn();
	}
}
