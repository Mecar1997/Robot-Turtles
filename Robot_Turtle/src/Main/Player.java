package Main;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player {
	int[] position = {0,0};
	int[] startPosition = {0,0};
	int color; // 0 = bleu, 1 = rouge, 2 = green, 3 = purple
	int direction = 2; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	int points; // points accumulés par le joueur
	public ArrayList<Card> hand = new ArrayList<Card>(); //liste contenant la main du joueur
	public ArrayDeque<Card> deck = new ArrayDeque<Card>(); //file contenant le deck du joueur
	public ArrayDeque<Card> graveyard = new ArrayDeque<Card>(); //file contenant les cartes defaussées du joueur //TODO:
	public ArrayDeque<Card> program = new ArrayDeque<Card>(); //file contenant le programme du joueur
	private int wallStone = 3; // nombre de murs de pierre à la disposition du joueur
	int wallIce = 2; // nombre de murs de glace à la disposition du joueur
	int wallWood = 0; // nombre de caisses à la disposition du joueur
	
	
	//TODO: Direction correcte??
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
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(8);
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setPlayer(color);
	}
	
	public void setPosition(int a, int b) {
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(0);
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].removePlayer();
		
		position[0] = a;
		position[1] = b;
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setType(8);
		Main.currentGame.getBoard().getTile()[position[0]][position[1]].setPlayer(color);
	}
	
	
	// mouvement
	
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
		if (direction == 0) {
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
			}
		}
		// TODO: Empêcher la tortue d'avancer s'il y'a un obstacle
		// TODO: Permettre à une tortue de pousser une caisse en bois ?
		// TODO : Implémentation de la colision de deux tortues
		// TODO: Implémentation du déplacement sur une case Joyau
		// TODO: Si la tortue sort, elle est retournée à la case départ
	}	
	
	public void returnStart() {
		position = startPosition;
	}
	
	
	// Manipulation main + deck

	public void shuffleDeck() { //TODO: Changer pour que ca marche avec les cartes défaussées.
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
		System.out.println("DEBUG: Le deck du joueur " + this.getName() + " contient " + b + " cartes Bleues, " + j + " cartes Jaunes, " + v + " cartes Violettes, " + l + " cartes Laser.");
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
		if (hand.size() >= a) {
			Card c = hand.get(a-1);
			hand.remove(a-1);
			graveyard.add(c);
		} else {
			System.out.println("ERREUR: Il n'y a pas de la cartes dans la main du joueur à l'emplacement " + (a-1));
		}
	}
	
	
	public void showHand() {
		Object[] l=hand.toArray();
		System.out.print("DEBUG: Main du joueur " + this.getName() +": ");
		for (int i = 0; i < l.length; i++) {
	        System.out.print(((Card) l[i]).toStringDebug());
		}
        System.out.println("");
	}
	
	// Exécution commandes
	
	public void removeWall(int type) {
		if (type == 1) {
			wallStone--;
		} else if (type == 2) {
			wallIce--;
		} else if (type == 3) {
			wallWood--;
		}
	}
	
	public boolean placeWall(int x, int y, int type) {
		// TODO:  Empêcher un joueur de bloquer une tortue ou un joyau
		Main.currentGame.getBoard().getTile()[x][y].setType(type);
		this.removeWall(type);
		System.out.println("DEBUG: Mur de type " + type + " placé par " + getName());
		return true;
	}
	
	
	public void executeProgram() {
		while (program.size() > 0) {
			Card e = program.pop();
			runCard(e);
			Main.HUD.updateBoard();
		}
	}
	
	public void addToProgram(int a) {
		Card e = hand.get(a);
		hand.remove(a);
		graveyard.add(e);
		program.add(e);
	}
	
	
	public void showProgram() {
		Object[] l=program.toArray();
		System.out.print("DEBUG: Programme du joueur " + this.getName() +": ");
		for (int i = 0; i < l.length; i++) {
	        System.out.print(((Card) l[i]).toStringDebug());
		}
        System.out.println("");
	}
	
	
	public void runCard(Card currentCard) {
		if (currentCard.type == 0) {
			forward();
		} else if (currentCard.type == 1) {
			turnLeft();
		} else if (currentCard.type == 2) {
			turnRight();
		} else if (currentCard.type == 3) {
			// TODO: Implémentation de la carte Laser
			// TODO: La carte Laser fait fondre les murs, peut toucher les tortues et est réfléchie par les Joyaux.
		} else if (currentCard.type == 3) {
			// TODO: Implémentation de la carte Bug
		}
	}
	
	public int getWallStone() {
		return wallStone;
	}

	public void setWallStone(int wallStone) {
		this.wallStone = wallStone;
	}
	
	public int getWallIce() {
		return wallIce;
	}

	public void setWallIce(int wallIce) {
		this.wallIce = wallIce;
	}
	
	public int getWallWood() {
		return wallWood;
	}

	public void setWallWood(int wallWood) {
		this.wallWood = wallWood;
	}
}
