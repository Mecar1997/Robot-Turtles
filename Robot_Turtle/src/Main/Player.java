package Main;

import java.util.Random;
import java.util.ArrayDeque;

public class Player {
	int[] position = {0,0};
	int[] startPosition = {0,0};
	int color; // 0 = bleu, 1 = rouge, 2 = green, 3 = purple
	int direction = 2; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	int points; // points accumul�s par le joueur
	public ArrayDeque<Card> hand = new ArrayDeque<>(); //file contenant la main du joueur
	public ArrayDeque<Card> deck = new ArrayDeque<>(); //file contenant le deck du joueur
	public ArrayDeque<Card> program = new ArrayDeque<>(); //file contenant le programme du joueur
	int wallStone = 3; // nombre de murs de pierre � la disposition du joueur
	int wallIce = 2; // nombre de murs de glace � la disposition du joueur
	
	public Player(int c) {
        this.color = c;
	}
	
	
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
	
	public String getColor() {
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
	
	
	public void setColor(int a) {
		color = a;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public void setStartPosition(int a, int b) {
		startPosition[0] = a;
		startPosition[1] = b;
		position[0] = a;
		position[1] = b;
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
			if (position[0] != 0) { // emp�che la tortue d'avancer hors du plateau
				setPosition(position[0]-1,position[1]);
			}
		} else if (direction == 1) {
			if (position[1] != 0) { // emp�che la tortue d'avancer hors du plateau
				setPosition(position[0],position[1]-1);
			}			
		} else if (direction == 2) {
			if (position[0] != 7) { // emp�che la tortue d'avancer hors du plateau
				setPosition(position[0]+1,position[1]);
			}	
		} else if (direction == 3) {
			if (position[1] != 7) { // emp�che la tortue d'avancer hors du plateau
				setPosition(position[0],position[1]+1);
			}
		}
		// TODO: Emp�cher la tortue d'avancer s'il y'a un obstacle
		// TODO: Permettre � une tortue de pousser une caisse en bois ?
		// TODO : Impl�mentation de la colision de deux tortues
		// TODO: Impl�mentation du d�placement sur une case Joyau
	}	
	
	public void returnStart() {
		position = startPosition;
	}
	public void runCard() { //TODO: Fonction non impl�ment�e
		Card currentCard = program.pop();
		if (currentCard.type == 0) {
			forward();
		} else if (currentCard.type == 1) {
			turnLeft();
		} else if (currentCard.type == 2) {
			turnRight();
		} else if (currentCard.type == 3) {
			// TODO: Impl�mentation de la carte Laser
		}
	}

	public void discardHand() {
		System.out.println("DEBUG: D�but d�faussage. Nombre de cartes dans la main du joueur " + this.getName() + ": " + this.hand.size());
		while (hand.size() > 0) {
			hand.pop();
		}
		System.out.println("DEBUG: D�but d�faussage. Nombre de cartes dans la main du joueur " + this.getName() + ": " + this.hand.size());
		drawCard();
	}
	
	public void shuffleDeck() {
		Card[] temporaryDeck = new Card[37]; // liste temporaire
		System.out.println("DEBUG: M�lange du deck du joueur " + this.getName());
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
	
}
