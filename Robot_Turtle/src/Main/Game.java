package Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import Interface.GameInterface;
import Interface.Menu;

public class Game {
	public int numberPlayers;
	public ArrayList<Player> players = new ArrayList<Player>(); //file contenant les joueurs du jeu
	public ArrayDeque<Player> turns = new ArrayDeque<>(); //file contenant les joueurs du jeu dans l'ordre de leurs tours
	public Board board;
	public Player currentPlayer; // Joueur qui passe son tour actuellement
	public Player lastPlayer; //Joueur qui vient de finir son tour
	public Player firstPlayer; //Joueur qui débute
	public int turnCounter = 0;
	public int jewelsFound = 0;
	
	public Game(int p) {
		Main.currentGame = this;
		numberPlayers = p;
		board = new Board();
		board.initialisation(); //reset du plateau
		Menu.Close();
		for (int j = 0; j < p; j++) {
		 	addPlayer(j);
		}
		setStartPositions();
		currentPlayer = players.get(0);
		firstPlayer = players.get(0);
		Main.HUD = new GameInterface();
		Main.HUD.initialisation();
		nextTurn();
	}
	
	public void addPlayer(int k) {
        Random rand = new Random();
		int i = rand.nextInt(Main.playersList.size());
		Player a = Main.playersList.remove(i);
		players.add(a);
		turns.add(a);
		a.shuffleDeck();
		a.drawCard();
	}
	
	public void listPlayers() {
		Object[] l=turns.toArray();
		for (int i = 0; i < l.length; i++) {
		}
	}
	
	public void setStartPositions() {
		if (numberPlayers == 4) {
			players.get(0).setStartPosition(0,0);
			players.get(1).setStartPosition(0,2);
			players.get(2).setStartPosition(0,5);
			players.get(3).setStartPosition(0,7);
		} else if (numberPlayers == 3) {
			players.get(0).setStartPosition(0,0);
			players.get(1).setStartPosition(0,3);
			players.get(2).setStartPosition(0,6);
		} else if (numberPlayers == 2) {
			players.get(0).setStartPosition(0,1);
			players.get(1).setStartPosition(0,5);
		}
	}
	
	public void nextTurn() {
		if (lastPlayer == null) { //premier tour
			lastPlayer = new Player(0);
		} else {
			lastPlayer = currentPlayer;
			turns.add(lastPlayer);
		}
		currentPlayer = turns.pop();
		currentPlayer.drawCard();
		if (currentPlayer == firstPlayer) {
			turnCounter++;
		}
		Main.HUD.newTurn();
	}

	public static void endGame() {
//TODO: popup message + restart game
	}
	
	public Board getBoard() {
		return board;
	}
	
}
