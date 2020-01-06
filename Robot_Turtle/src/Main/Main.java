package Main;



public class Main {
	public static int nombreJoueurs;
	
	
	public static void main(String[] args) {
		Interface.InitialiserMenu();
		Interface.Afficher();
	}

	public static void nouvellePartie() {
		Plateau board = new Plateau();
		board.setSize(8,8);
	}
	
}
