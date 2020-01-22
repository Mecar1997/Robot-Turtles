package Main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.ArrayList;



import Interface.Menu;
import Interface.GameInterface;

public class Main {
	public static ArrayList<Player> possiblePlayers = new ArrayList<>(); //liste contenant tous les joueurs possibles dans le jeu.
	public static ArrayList<Player> players = new ArrayList<Player>(); //file contenant les joueurs du jeu
	public static GameInterface HUD; //interface du jeu
	public static Menu startMenu; // menu de début
	public static int session = 0; //nombre de sessions réalisées
	public static Game currentGame; // jeu en cours
	public static int numberPlayers; //nombre de joueurs
	
	public static void main(String[] args) {
		possiblePlayers.add(new Player(0));
		possiblePlayers.add(new Player(1));
		possiblePlayers.add(new Player(2));
		possiblePlayers.add(new Player(3));
		
		startMenu = new Menu();
		startMenu.initialisation(); //Initialisation Menu
	}
	
	public static void newGame(int p) { //nouvelle partie
		session++;
		new Game(p);
	}
	
	public static void endSession() {
		JOptionPane.showMessageDialog(null, "Joueur gagnant: " + currentGame.winner.getName(), "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
		HUD.Close();
	}

	
}



