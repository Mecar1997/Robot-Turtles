package Main;

import java.util.Random;

public class Player {
	int[] position = {0,0};
	int[] startPosition = {0,0};
	int color; // 0 = bleu, 1 = rouge, 2 = green, 3 = purple
	int direction = 2; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	Card[] program; // Cartes que le joueur a joué
	Card[] hand; // Cartes que possède le joueur dans sa main
	Card[] deck = new Card[37]; // deck du joueur
	
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
		Main.board.grid[position[0]][position[1]].setType(8);
		Main.board.grid[position[0]][position[1]].setPlayer(color);
	}
	
	public void setPosition(int a, int b) {
		Main.board.grid[position[0]][position[1]].setType(0);
		Main.board.grid[position[0]][position[1]].removePlayer();
		position[0] = a;
		position[1] = b;
		Main.board.grid[position[0]][position[1]].setType(8);
		System.out.println("BIG DEBUG ++ " + color);
		Main.board.grid[position[0]][position[1]].setPlayer(color);
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
			if (position[0] != 0) { // empêche la tortue d'avancer hors du plateau
				position[0] = position[0] - 1;
			}
		} else if (direction == 1) {
			if (position[1] != 0) { // empêche la tortue d'avancer hors du plateau
				position[1] = position[1] - 1;
			}			
		} else if (direction == 2) {
			if (position[0] != 7) { // empêche la tortue d'avancer hors du plateau
				position[0] = position[0] + 1;
			}	
		} else if (direction == 3) {
			if (position[1] != 7) { // empêche la tortue d'avancer hors du plateau
				position[1] = position[1] + 1;
			}
		}
	}	
	
	public void returnStart() {
		position = startPosition;
	}
	public void runCard() {
		Card currentCard = program[0];
		if (currentCard.type == 0) {
			forward();
		} else if (currentCard.type == 1) {
			turnLeft();
		} else if (currentCard.type == 2) {
			turnRight();
		} else {
			// ajouter des conditions pour que la tortue ne fasse fondre qu'un mur de glace en façe d'elle
		}
	}

	public void ditchHand(int a) {

	}
	
	public void shuffleDeck() {
		System.out.println("DEBUG: Mélange du deck du joueur " + this.getName());
        for (int i = 0; i < 37; i++) {
        	deck[i] = new Card();
        }
        Random rand = new Random();
		int a = 3; //nombre total de cartes lasers dans le jeu
		do {
			int i = rand.nextInt(36);
			if (deck[i].getType() == 0) {
	        	deck[i].setType(3);
	        	a = a - 1;
			}
		} while (a != 0);
		a = 8; // nombre total de cartes violettes
		do {
			int i = rand.nextInt(36);
			if (deck[i].getType() == 0) {
	        	deck[i].setType(2);
	        	a = a - 1;
			}
		} while (a != 0);
		a = 8; // nombre total de cartes jaunes
		do {
			int i = rand.nextInt(36);
			if (deck[i].getType() == 0) {
	        	deck[i].setType(1);
	        	a = a - 1;
			}
		} while (a != 0);
	showDeck();
	}
	
	public void showDeck() {
		int j = 0;
		int v = 0;
		int l = 0;
		int b = 0;
		System.out.print("DEBUG: Deck de " + this.getName() + ": ");
        for (int i = 0; i < 37; i++) {
        	if (deck[i].getType() == 0) {
        		b++;
        		System.out.print("B");
        	} else if (deck[i].getType() == 1) {
        		j++;
        		System.out.print("J");
        	} else if (deck[i].getType() == 2) {
        		v++;
        		System.out.print("V");
        	} else if (deck[i].getType() == 3) {
        		l++;
        		System.out.print("L");
        	}
        }
		System.out.println("");
		System.out.println("DEBUG: Le deck du joueur " + this.getName() + " contient " + b + " cartes Bleues, " + j + " cartes Jaunes, " + j + " cartes Violettes, " + l + " cartes Laser.");
	}
	
}
