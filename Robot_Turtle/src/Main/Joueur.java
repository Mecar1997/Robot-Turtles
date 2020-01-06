package Main;

public class Joueur {
	String nom;
	int[] position;
	int couleur;
	int direction; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	
	public String getName() {
		return nom;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public void tournerGauche() {
		if (direction == 3) {
			direction = 0;
		} else {
			direction = direction + 1;
		}
	}	
	
	public void tournerDroite() {
		if (direction == 0) {
			direction = 3;
		} else {
			direction = direction - 1;
		}
	}
	
	
	
}
