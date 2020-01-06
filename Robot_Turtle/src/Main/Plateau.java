package Main;


public class Plateau {
	int taille = 8;
	private Case[][] grid;
	
	
	public Plateau() {
	}
	
	public void Initialisation() {
        for (int L = 0; L < this.taille; L++) {
            for (int C = 0; L < this.taille; L++) {
            	grid[L][C].setType(0, 0); // on vide toutes les cases
            }
		}
        if (Main.nombreJoueurs < 4) {
            for (int L = 0; L < this.taille; L++) {
            	grid[L][taille - 1].setType(1, 0); //on ajoute des murs de pierre si le nombre de joueurs est inférieur à 4
            }
        }
	}

	public void addJewel (int x, int y, int type) {
		 grid[x][y].setType(2, type);
	}
	
	public void addWall (int x, int y, int type) {
		 grid[x][y].setType(1, type);
	}
	
	public void removeJewelOrWall(int x, int y) {
		 grid[x][y].setType(0, 0);
	}

}
