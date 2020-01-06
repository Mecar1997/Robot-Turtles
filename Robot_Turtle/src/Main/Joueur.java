package Main;

import java.util.Scanner;

public class Joueur {
	String nom;
	int[] position;
	int numero;
	int couleur;
	int direction; //0 = nord, 1 = Ouest, 2 = Sud, 3 = Est
	Carte[] listeCartes;
	
	public Joueur() {
        Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom du joueur " + Main.nombreJoueurs + 1);
		String a = sc.nextLine();
		nom = a;
		numero = Main.nombreJoueurs + 1;
	}
	
	
	public String getName() {
		return nom;
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
	

	public void executeCommands() {
		
	}

}
