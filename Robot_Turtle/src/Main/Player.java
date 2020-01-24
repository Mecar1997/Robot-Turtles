package Main;

import java.util.Random;
<<<<<<< HEAD
import java.util.ArrayDeque;
=======
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de

public class Player {
	int[] position = {0,0};
	int[] startPosition = {0,0};
	int color; // 0 = bleu, 1 = rouge, 2 = green, 3 = purple
<<<<<<< HEAD
	int direction = 2; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	int points; // points accumulés par le joueur
	public ArrayDeque<Card> hand = new ArrayDeque<>(); //file contenant la main du joueur
	public ArrayDeque<Card> deck = new ArrayDeque<>(); //file contenant le deck du joueur
	public ArrayDeque<Card> program = new ArrayDeque<>(); //file contenant le programme du joueur
	int wallStone = 3; // nombre de murs de pierre à la disposition du joueur
	int wallIce = 2; // nombre de murs de glace à la disposition du joueur
=======
	int direction; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	private int points; // points accumulés par le joueur
	public ArrayList<Card> hand = new ArrayList<Card>(); //liste contenant la main du joueur
	public ArrayDeque<Card> deck = new ArrayDeque<Card>(); //file contenant le deck du joueur
	public ArrayList<Card> graveyard = new ArrayList<Card>(); //file contenant les cartes defaussées du joueur
	public ArrayDeque<Card> program = new ArrayDeque<Card>(); //file contenant le programme du joueur
	int[] walls = {3,2,0}; // nombre de murs à la disposition du joueur. 0 = pierre, 1 = glace, 2 = bois
	boolean bugged; // est victime d'une carte Bug

	public int number;	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	
	public Player(int c) {
        this.color = c;
	}
	
	
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
	
<<<<<<< HEAD
	public String getColor() {
=======
	public String getColorString() {
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
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
	
<<<<<<< HEAD
=======
	public int getDirection() {
		return direction;
	}
	
	public int getColor() {
		return color;
	}
	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	
	public void setColor(int a) {
		color = a;
	}
	
	public int[] getPosition() {
		return position;
	}
	
<<<<<<< HEAD
=======
	public int[] getstartPosition() {
		return startPosition;
	}
	
	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	public void setStartPosition(int a, int b) {
		startPosition[0] = a;
		startPosition[1] = b;
		position[0] = a;
		position[1] = b;
<<<<<<< HEAD
		Main.board.tile[position[0]][position[1]].setType(8);
		Main.board.tile[position[0]][position[1]].setPlayer(color);
	}
	
	public void setPosition(int a, int b) {
		Main.board.tile[position[0]][position[1]].setType(0);
		Main.board.tile[position[0]][position[1]].removePlayer();
		position[0] = a;
		position[1] = b;
		Main.board.tile[position[0]][position[1]].setType(8);
		Main.board.tile[position[0]][position[1]].setPlayer(color);
	}
=======
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
	
	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	
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
<<<<<<< HEAD
			if (position[0] != 0) { // empêche la tortue d'avancer hors du plateau
				setPosition(position[0]-1,position[1]);
			}
		} else if (direction == 1) {
			if (position[1] != 0) { // empêche la tortue d'avancer hors du plateau
				setPosition(position[0],position[1]-1);
			}			
		} else if (direction == 2) {
			if (position[0] != 7) { // empêche la tortue d'avancer hors du plateau
				setPosition(position[0]+1,position[1]);
			}	
		} else if (direction == 3) {
			if (position[1] != 7) { // empêche la tortue d'avancer hors du plateau
				setPosition(position[0],position[1]+1);
=======
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
		
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].getType() == 3) { //caisse en bois
			int newX2 = 0;
			int newY2 = 0;
			if (direction == 0) {
				newX2 = position[0]-2;
				newY2 = position[1];
			} else if (direction == 1) {
				newX2 = position[0];
				newY2 = position[1]-2;		
			} else if (direction == 2) {
				newX2 = position[0]+2;
				newY2 = position[1];
			} else if (direction == 3) {
				newX2 = position[0];
				newY2 = position[1]+2;
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
			}
			
			if (newX2 >= 0 && newX2 <= 7 && newY2 >= 0 && newY2 <= 7 && Main.currentGame.getBoard().getTile()[newX2][newY2].getType() == 0) { // CHECK: Si la caisse ne va pas sortir du plateau, on la pousse
				Main.currentGame.getBoard().getTile()[newX][newY].setType(0);
				Main.currentGame.getBoard().getTile()[newX2][newY2].setType(3);
				setPosition(newX,newY);
				return;
			} else {
				System.out.println("il y'a une caise en bois que l'on peut pas pousser");
				turnTwice();
				return;
			}
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
<<<<<<< HEAD
		// TODO: Empêcher la tortue d'avancer s'il y'a un obstacle
		// TODO: Permettre à une tortue de pousser une caisse en bois ?
		// TODO : Implémentation de la colision de deux tortues
		// TODO: Implémentation du déplacement sur une case Joyau
=======
		setPosition(newX,newY);
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	}	
	
	public void returnStart() {
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(0);
		this.setPosition(startPosition[0], startPosition[1]);
		direction = 2;
		Main.HUD.updateBoard();
	}
<<<<<<< HEAD
	public void runCard() { //TODO: Fonction non implémentée
		Card currentCard = program.pop();
=======
	
	public void jewelFound() {
		System.out.println(this.getName() + " a trouvé un joyau.");
		if (Main.currentGame.winner == null) {
			Main.currentGame.winner = this;
		}
		points += Main.currentGame.remainingPlayers.size() - 1;
		if (Main.currentGame.remainingPlayers.size() > 2) { // plus de 2 joueurs dans la partie
			if (Main.currentGame.remainingPlayers.get(0) == this) {
				Main.currentGame.firstPlayer = Main.currentGame.remainingPlayers.get(1);
			}
			Main.currentGame.nextTurn();
			Main.currentGame.remainingPlayers.remove(this);
			Main.currentGame.turns.remove(this);
			Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(0);
			Main.currentGame.getBoard().getTile()[position[0]][position[1]].removePlayer();

			System.out.println("Il reste " + Main.currentGame.remainingPlayers.size() + " joueurs");
			
		} else {
			Main.endSession();
		}
		
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
	//showDeck();
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
		//showDeck();
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
			if (Main.numberPlayers == 2) {
				Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().turnTwice();
			} else {
				Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().returnStart();
			}
			Main.currentGame.getBoard().getTile()[newX][newY].getPlayer().returnStart();
			return;
		}
		
		if (Main.currentGame.getBoard().getTile()[newX][newY].isJewel()) { // laser sur soi
			if (Main.numberPlayers == 2) {
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
		for (int i = -1; i < 2;i++) {
			for (int j = -1; j < 2;j++) {
				if (x+i >= 0 && x+i <= 7 && y+j >= 0 && y+j <= 7) {
					if (Main.currentGame.board.getTile()[x+i][y+j].getType() == 8 || Main.currentGame.board.getTile()[x+i][y+j].isJewel()) {
						if (Main.currentGame.board.numberBlocks(x+i, y+j) < 2) {
							System.out.println("La tuile est bloquée");
							return false;
						}
					}
				}
			}
		}
		Main.currentGame.getBoard().getTile()[x][y].setType(type);
		this.removeWall(type);
		System.out.println("La tuile n'est pas bloquée");
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
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
		if (currentCard.type == 0) {
			forward();
		} else if (currentCard.type == 1) {
			turnLeft();
		} else if (currentCard.type == 2) {
			turnRight();
		} else if (currentCard.type == 3) {
<<<<<<< HEAD
			// TODO: Implémentation de la carte Laser
		}
	}

	public void discardHand() {
		System.out.println("DEBUG: Début défaussage. Nombre de cartes dans la main du joueur " + this.getName() + ": " + this.hand.size());
		while (hand.size() > 0) {
			hand.pop();
		}
		System.out.println("DEBUG: Début défaussage. Nombre de cartes dans la main du joueur " + this.getName() + ": " + this.hand.size());
		drawCard();
	}
	
	public void shuffleDeck() {
		Card[] temporaryDeck = new Card[37]; // liste temporaire
		System.out.println("DEBUG: Mélange du deck du joueur " + this.getName());
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
		System.out.println("DEBUG: Le deck du joueur " + this.getName() + " contient " + b + " cartes Bleues, " + j + " cartes Jaunes, " + j + " cartes Violettes, " + l + " cartes Laser.");
	}
	
	
	public void drawCard() {
		System.out.println("DEBUG: Initialisation. Nombre de cartes dans la main du joueur " + this.getName() + ": " + this.hand.size());
		while (hand.size() < 5) {
			hand.add(deck.pop());
		}
		System.out.println("DEBUG: Fin. Nombre de cartes dans la main du joueur " + this.getName() + ": " + this.hand.size());
		showDeck();
	}
	
	
	public void discardCard(int a) {
		
	}
	
	
	public void showHand() {
		Object[] l=hand.toArray();
		System.out.print("DEBUG: Main du joueur " + this.getName() +": ");
		for (int i = 0; i < l.length; i++) {
	        System.out.print(((Card) l[i]).toStringDebug());
		}
        System.out.println("");
	}
	
	public void removeWall(int a) {
		if (a == 1) {
			this.wallStone--;
		} else {
			this.wallIce--;
		}
	}
=======
			runLaser();
		}
	}
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	
}
