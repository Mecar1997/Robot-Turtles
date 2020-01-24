package Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Interface.GameInterface;
import Interface.Menu;

public class Game {
	public ArrayList<Player> remainingPlayers; //file contenant les joueurs du jeu qui restent
	public ArrayDeque<Player> turns; //file contenant les joueurs du jeu dans l'ordre de leurs tours
	public Board board; //plateau du jeu
	public Player currentPlayer; // Joueur qui passe son tour actuellement
	public Player lastPlayer; //Joueur qui vient de finir son tour
	public Player firstPlayer; //Joueur qui débute
	public int turnCounter = 0; //compteur de tours
	public Player winner;

	
	public Game(int p) { //constructeurs
		Main.currentGame = this;
		Main.numberPlayers = p;
		remainingPlayers = new ArrayList<Player>();
		turns = new ArrayDeque<>();
		board = new Board();
		for (int j = 0; j < p; j++) {
		 	addPlayer(j);
		}
		setStartPositions();
		currentPlayer = remainingPlayers.get(0);
		firstPlayer = remainingPlayers.get(0);
		Main.HUD = new GameInterface();
		Main.HUD.initialisation();
		Main.HUD.update();
		nextTurn();
	}
	
	public void addPlayer(int k) {
		Player a;
		if (Main.session == 1) {
			System.out.println("première session. on crée de nouveaux joueurs");
	        Random rand = new Random();
			int i = rand.nextInt(Main.possiblePlayers.size());
			a = Main.possiblePlayers.remove(i);
			Main.players.add(a);
		} else {
			System.out.println("Seconde ou troisième session. on utilise les mêmes joueurs");
			a = Main.players.get(k);
		}

		remainingPlayers.add(a);
		turns.add(a);
		a.shuffleDeck();
		a.drawCard();
		a.walls[0] = 3;
		a.walls[1] = 2;
		a.walls[2] = 0;
	}
	
	public void listPlayers() {
		Object[] l=turns.toArray();
		for (int i = 0; i < l.length; i++) {
		}
	}
	
	public void setStartPositions() {
		if (Main.numberPlayers == 4) {
			Main.players.get(0).setStartPosition(0,0);
			Main.players.get(1).setStartPosition(0,2);
			Main.players.get(2).setStartPosition(0,5);
			Main.players.get(3).setStartPosition(0,7);
		} else if (Main.numberPlayers == 3) {
			Main.players.get(0).setStartPosition(0,0);
			Main.players.get(1).setStartPosition(0,3);
			Main.players.get(2).setStartPosition(0,6);
		} else if (Main.numberPlayers == 2) {
			Main.players.get(0).setStartPosition(0,1);
			Main.players.get(1).setStartPosition(0,5);
		}
	}
	
	public void nextTurn() {
		if (lastPlayer == null) { //premier tour
			System.out.println("Premier tour");
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

	public void endGame() {
		JOptionPane.showMessageDialog(null, "Fin de la manche " + Main.session + " sur 3", "Fin manche", JOptionPane.INFORMATION_MESSAGE);
		board = null;
		turns = null;
		remainingPlayers = null;
		Main.newGame(Main.numberPlayers);
	}
	
	
	public static void sortPlayers() {

	}
	
	public Board getBoard() {
		return board;
	}
	
}
