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
	public static ArrayList<Player> playersList = new ArrayList<>(); //liste contenant tous les joueurs possibles dans le jeu.
	public static GameInterface HUD;
	public static Menu startMenu;
	public static PostGame postGameMenu;
	public static int session = 0; //nombre de sessions réalisées
	public static Game currentGame;
	
	public static void main(String[] args) {
		playersList.add(new Player(0));
		playersList.add(new Player(1));
		playersList.add(new Player(2));
		playersList.add(new Player(3));
		startMenu = new Menu();

		startMenu.initialisation(); //Initialisation Menu
	}
	
	public static void newGame(int p) { //nouvelle partie
		session++;
		new Game(p);
	}
	
	public static void endSession() {
		postGameMenu = new PostGame();
		postGameMenu.initialisation(); //Initialisation menu de fin
		//TODO:
	}
	
	public static void save() {
		//TODO:  Facultatif. Manche de 3.
	}
}



