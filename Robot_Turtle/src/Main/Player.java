package Main;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player {
	int[] position = {0,0};
	int[] startPosition = {0,0};
	int color; // 0 = bleu, 1 = rouge, 2 = green, 3 = purple
	int direction; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	private int points; // points accumulés par le joueur
	public ArrayList<Card> hand = new ArrayList<Card>(); //liste contenant la main du joueur
	public ArrayDeque<Card> deck = new ArrayDeque<Card>(); //file contenant le deck du joueur
	public ArrayList<Card> graveyard = new ArrayList<Card>(); //file contenant les cartes defaussées du joueur
	public ArrayDeque<Card> program = new ArrayDeque<Card>(); //file contenant le programme du joueur
	int[] walls = {3,2,0}; // nombre de murs à la disposition du joueur. 0 = pierre, 1 = glace, 2 = bois
	boolean bugged; // est victime d'une carte Bug

	public int number;	
	
	public Player(int c) {
        this.color = c;
	}
	//TODO: out of bounds
	// getters & setters
	public String getName() {
		if (this.color == 0) {
			return "Beep";
		} else if (this.color == 1) {
			return "Pi";
		} else if (this.color == 2) {
			return "Pangle";
		} else {
			return "Dot";
		}
	}
	
	public String getColorString() {
		if (this.color == 0) {
			return "Bleu";
		} else if (this.color == 1) {
			return "Rouge";
		} else if (this.color == 2) {
			return "Vert";
		} else {
			return "Violet";
		}
	}
	
	public int getDirection() {
		return direction;
	}
	
	public int getColor() {
		return color;
	}
	
	
	public void setColor(int a) {
		color = a;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public int[] getstartPosition() {
		return startPosition;
	}
	
	
	public void setStartPosition(int a, int b) {
		startPosition[0] = a;
		startPosition[1] = b;
		position[0] = a;
		position[1] = b;
		direction = 2;
		if (Main.currentGame == null) {
			System.out.println("current game is null");
		}
		if (Main.currentGame.getBoard() == null) {
			System.out.println("current board is null");
		}
		if (Main.currentGame.getBoard().getTile()[a][b] == null) {
			System.out.println("current board tile is null");
		}

		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setPlayer(this);
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(8);
	}
	
	public void setPosition(int a, int b) {
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(0);
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].removePlayer();
		
		position[0] = a;
		position[1] = b;

		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setPlayer(this);
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(8);
	}
	
	public int getWalls(int a) {
		return walls[a];
	}

	public void setWalls(int wall, int type) {
		this.walls[type] = wall;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	// mouvement
	public void turnTwice() {
		System.out.println("demi tour ?");
		if (direction == 0) {
			direction = 2;
		} else if (direction == 1) {
			direction = 3;		
		} else if (direction == 2) {
			direction = 0;
		} else if (direction == 3) {
			direction = 1;
		}
	}
	
	
	
	public void turnLeft() {
		if (direction == 3) {
			direction = 0;
		} else {
			direction = direction + 1;
		}
	}	
	
	public void turnRight() {
		if (direction == 0) {
			direction = 3;
		} else {
			direction = direction - 1;
		}
	}
	
	public void forward() {
		int newX = 0;
		int newY = 0;
		
		if (direction == 0) {
			newX = position[0]-1;
			newY = position[1];
		} else if (direction == 1) {
			newX = position[0];
			newY = position[1]-1;		
		} else if (direction == 2) {
			newX = position[0]+1;
			newY = position[1];
		} else if (direction == 3) {
			newX = position[0];
			newY = position[1]+1;
		}
		
		if (newX < 0 || newX > 7 || newY < 0 || newY > 7) { // CHECK: Si la tortue sort, elle est retournée à la case départ
			returnStart();
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].isObstacle()) { // empêche d'avancer s'il y'a un obstacle
			System.out.println("il y'a un obstacle devant cette tortue");
			turnTwice();
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].getType() == 8) { //collision deux tortues
			returnStart();
			Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().returnStart();
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].isJewel()) { // joyau
			jewelFound();
			return;
		}
		setPosition(newX,newY);
		
		// TODO: Permettre à une tortue de pousser une caisse en bois ?
	}	
	
	public void returnStart() {
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(0);
		this.setPosition(startPosition[0], startPosition[1]);
		Main.HUD.updateBoard();
	}
	
	public void jewelFound() {
		System.out.println(this.getName() + " a trouvé un joyau.");
		if (Main.currentGame.players.size() > 2) { // plus de 2 joueurs dans la partie
			if (Main.currentGame.players.get(0) == this) {
				Main.currentGame.firstPlayer = Main.currentGame.players.get(1);
			}
			Main.currentGame.players.remove(0);
			Main.currentGame.turns.remove();
			Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(0);
			Main.currentGame.getBoard().getTile()[position[0]][position[1]].removePlayer();
			
		} else {
			Main.currentGame.endGame();
		}
		//TODO: Ajout système de points
		System.out.println("Il reste " + Main.currentGame.players.size() + " joueurs");
	}
	
	// Manipulation main + deck

	public void shuffleDeck() {
		Card[] temporaryDeck = new Card[37]; // liste temporaire
        for (int i = 0; i < 37; i++) {
        	temporaryDeck[i] = new Card();
        }
        Random rand = new Random();
		int a = 3; //nombre total de cartes lasers dans le jeu
		do {
			int i = rand.nextInt(36);
			if (temporaryDeck[i].getType() == 0) {
				temporaryDeck[i].setType(3);
	        	a = a - 1;
			}
		} while (a != 0);
		a = 8; // nombre total de cartes violettes
		do {
			int i = rand.nextInt(36);
			if (temporaryDeck[i].getType() == 0) {
				temporaryDeck[i].setType(2);
	        	a = a - 1;
			}
		} while (a != 0);
		a = 8; // nombre total de cartes jaunes
		do {
			int i = rand.nextInt(36);
			if (temporaryDeck[i].getType() == 0) {
				temporaryDeck[i].setType(1);
	        	a = a - 1;
			}
		} while (a != 0);
	deckToQueue(temporaryDeck);
	showDeck();
	}
	
	public void deckToQueue(Card[] temporaryDeck) {
        for (int i = 0; i < temporaryDeck.length; i++) {
        	this.deck.add(temporaryDeck[i]);
        }
	}
	
	public void showDeck() {
		int j = 0,v = 0,b = 0,l = 0;
		
		Object[] k=deck.toArray();
		
		System.out.print("DEBUG: Deck de " + this.getName() + ": ");
		for (int i = 0; i < k.length; i++) {
        	if (((Card) k[i]).getType() == 0) {
        		b++;
        		System.out.print("B");
        	} else if (((Card) k[i]).getType() == 1) {
        		j++;
        		System.out.print("J");
        	} else if (((Card) k[i]).getType() == 2) {
        		v++;
        		System.out.print("V");
        	} else if (((Card) k[i]).getType() == 3) {
        		l++;
        		System.out.print("L");
        	}
        }
        //System.out.println("");
        //System.out.print("DEBUG: Deck de " + this.getName() + ": ");
        //for (int i = 0; i < 37; i++) {
        //	System.out.print(temporaryDeck[i].toStringDebug());
        //}
		System.out.println("");
		System.out.println("DEBUG: Le deck du joueur " + this.getName() + " contient " + b + " cartes Bleues, " + j + " cartes Jaunes, " + v + " cartes Violettes, " + l + " cartes Laser.");
	}
	
	
	public void drawCard() {
		while (hand.size() < 5) {
			if (deck.isEmpty()) {
				System.out.println("deck vide, utilisation des cartes défaussées");
				while (graveyard.size() > 0) {
			        Random rand = new Random();
					int i = rand.nextInt(graveyard.size());
					deck.add(graveyard.remove(i));
				}
			}
			hand.add(deck.pop());
		}
		showDeck();
	}
	
	
	public void discardCard(int a) {
		if (hand.size() >= a) {
			Card c = hand.get(a-1);
			hand.remove(a-1);
			graveyard.add(c);
		} else {
			System.out.println("ERREUR: Il n'y a pas de la cartes dans la main du joueur à l'emplacement " + (a-1));
		}
	}
	
	// Exécution commandes
	
	public void runLaser() {
		int newX = 0;
		int newY = 0;
		
		if (direction == 0) {
			newX = position[0]-1;
			newY = position[1];
		} else if (direction == 1) {
			newX = position[0];
			newY = position[1]-1;		
		} else if (direction == 2) {
			newX = position[0]+1;
			newY = position[1];
		} else if (direction == 3) {
			newX = position[0];
			newY = position[1]+1;
		}
			
		if (newX < 0 || newX > 7 || newY < 0 || newY > 7) { // CHECK
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].getType() == 2) { // empêche d'avancer s'il y'a un obstacle
			Main.currentGame.getBoard().getTile()[newX][newY].setType(0);
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].getType() == 8) { //laser sur une autre tortue
			if (Main.currentGame.numberPlayers == 2) {
				Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().turnTwice();
			} else {
				Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().returnStart();
			}
			Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().returnStart();
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].isJewel()) { // laser sur soi
			if (Main.currentGame.numberPlayers == 2) {
				turnTwice();
			} else {
				returnStart();
			}
			return;
		}
	}
	
	
	public void removeWall(int type) {
		if (type == 1) {
			walls[0]--;
		} else if (type == 2) {
			walls[1]--;
		} else if (type == 3) {
			walls[2]--;
		}
	}
	
	public boolean placeWall(int x, int y, int type) {
		// TODO:  Empêcher un joueur de bloquer une tortue ou un joyau
		Main.currentGame.getBoard().getTile()[x][y].setType(type);
		this.removeWall(type);
		return true;
	}
	
	
	public void executeProgram() {
		Card e = null;
		while (program.size() > 0) {
			if (bugged) {
				e = program.removeLast();
			} else {
				e = program.pop();
			}
			runCard(e);
			Main.HUD.updateBoard();
		}
		bugged = false;
	}
	
	public void addToProgram(int a) {
		Card e = hand.get(a);
		hand.remove(a);
		graveyard.add(e);
		program.add(e);
	}
	
	public void runCard(Card currentCard) {
		if (currentCard.type == 0) {
			forward();
		} else if (currentCard.type == 1) {
			turnLeft();
		} else if (currentCard.type == 2) {
			turnRight();
		} else if (currentCard.type == 3) {
			runLaser();
		}
	}
	
}
