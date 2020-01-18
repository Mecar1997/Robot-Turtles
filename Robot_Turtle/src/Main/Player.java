package Main;


public class Player {
	String name;
	int[] position;
	int[] startPosition;
	int number;
	int color;
	int direction; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	Card[] program; // Cartes que le joueur a joué
	Card[] hand; // Cartes que possède le joueur dans sa main
	
	public Player() {
		// name = a;
		number = Main.nombreJoueurs + 1;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int[] getPosition() {
		return position;
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
	
}
