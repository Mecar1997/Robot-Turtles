package Main;



public class Main {
	public static int nombreJoueurs;
	public static Joueur[] listeJoueurs; //liste contenant tous les joueurs présents dans le jeu
	
	public static void main(String[] args) {
		Interface.InitialiserMenu(); //Initialisation Menu
		Interface.Open(); //ouverture interface graphique
	}

	public static void newGame() {
		Plateau board = new Plateau(); 
		board.Initialisation(); //nouveau plateau + initialisation
	}
	
	public static void newPlayer() {
		Joueur a = new Joueur();
		listeJoueurs[Main.nombreJoueurs] = a;
		nombreJoueurs = Main.nombreJoueurs + 1;
	}
}
