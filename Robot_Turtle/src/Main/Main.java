package Main;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



import Interface.Menu;
import Interface.PostGame;
import Interface.GameInterface;

public class Main {
	public static int numberPlayers;
	public static Player[] playersList = {new Player(0),new Player(1),new Player(2),new Player(3)}; //liste contenant tous les joueurs possibles dans le jeu. TODO: Changer en ArrayList
	public static ArrayDeque<Player> turns = new ArrayDeque<>(); //file contenant les joueurs du jeu dans l'ordre de leurs tours
	public static Board board = new Board();
	public static Player currentPlayer = new Player(0); // Joueur qui passe son tour actuellement
	public static Player lastPlayer; //Joueur qui vient de finir son tour
	public static GameInterface HUD;
	public static Menu startMenu;
	public static PostGame postGameMenu;
	public static int session = 0; //nombre de sessions réalisées
	
	
	public static void main(String[] args) {
		startMenu = new Menu();
		startMenu.initialisation(); //Initialisation Menu
	}
	
	public static void newGame(int p) { //nouvelle partie
		numberPlayers = p;
		System.out.println("DEBUG: Nombre de joueurs: " + numberPlayers);
		board.initialisation(); //reset du plateau
		Menu.Close();
		shufflePlayers();
		setStartPositions();
		for (int j = 0; j < p; j++) {
		 	addPlayer(j);
		}
		HUD = new GameInterface();
		HUD.initialisation();
		nextTurn();
	}
	
	
	public static void addPlayer(int k) {
		System.out.println("DEBUG: Joueur " + k + " ajouté. Son nom est " + playersList[k].getName() + " et sa couleur est le " + playersList[k].getColor());
		turns.add(playersList[k]);
		turns.peekLast().shuffleDeck();
		turns.peekLast().drawCard();
	}
	
	public static void shufflePlayers() {
		 // TODO: Les joueurs sont mélangés au hasard
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
	
	public static void nextTurn() { //TODO: Piochage des cartes
		if (lastPlayer == null) { //premier tour
			lastPlayer = new Player(0);
		} else {
			lastPlayer = currentPlayer;
			turns.add(lastPlayer);
		}
		currentPlayer = turns.pop();
		HUD.newTurn();
	}

	public static void endGame() {
		postGameMenu = new PostGame();
		postGameMenu.initialisation(true); //Initialisation menu de fin
	}
	
	
	public static void endSession() {
		postGameMenu = new PostGame();
		postGameMenu.initialisation(false); //Initialisation menu de fin
		//TODO:
	}
	
	public static void save() {
		//TODO:  Facultatif. Manche de 3.
	}
}
