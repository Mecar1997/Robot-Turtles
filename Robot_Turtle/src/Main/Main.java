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
	
	
	public static void commandChoice() {
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		do {System.out.println("DEBUG: Tour du joueur " + currentPlayer.getName() + ". Prochain joueur: " + turns.getFirst().getName() + "\r\n" + 
				"Tapez 1 pour passer votre tour.\r\n" + 
				"Tapez 2 pour afficher votre main\r\n" + 
				"Tapez 3 pour \r\n" +
				"Tapez 4 pour \r\n" + 
				"Tapez 5 pour \r\n" + 
				"Tapez 6 pour afficher le plateau.\r\n");
			a = scanner.nextInt();
		} while (a < 1 || a > 6);
		if (a == 1) {
			nextTurn();
		} else if (a == 2) {
			currentPlayer.showHand();
			commandChoice();
		} else if (a == 6) {
			board.show();
			commandChoice();
		} else {
			commandChoice();
		}
	}
}
