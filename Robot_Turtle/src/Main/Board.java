package Main;

import java.util.Random;


public class Board {
	int size = 8;
<<<<<<< HEAD
	Tile[][] tile = new Tile[8][8];
	
	
	public Board() {
	}
	
	public void Initialisation() {
        Random rand = new Random();
		System.out.println("DEBUG: Initialisation");
		for (int L = 0; L < this.size; L++) {
            for (int C = 0; C < this.size; C++) {
        		tile[L][C] = new Tile();
        		tile[L][C].setType(0); // on vide toutes les cases
=======
	private Tile[][] tile = new Tile[size][size];
	
	
	public Board() {
        Random rand = new Random();
		for (int L = 0; L < size; L++) {
            for (int C = 0; C < size; C++) {
        		getTile()[L][C] = new Tile();
        		getTile()[L][C].setType(0); // on vide toutes les cases
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
            }
		}
        if (Main.numberPlayers == 4) {
			int i = rand.nextInt(3);
<<<<<<< HEAD
			tile[7][1].setType(4+i);
			i = rand.nextInt(3);
			tile[7][6].setType(4+i);
        } else {
        	if (Main.numberPlayers == 3) {
    			int i = rand.nextInt(3);
    			tile[7][0].setType(4+i);
    			i = rand.nextInt(3);
    			tile[7][3].setType(4+i);
    			i = rand.nextInt(3);
    			tile[7][6].setType(4+i);
        	} else {
    			int i = rand.nextInt(3);
    			tile[7][3].setType(4+i);
        	}
        	
            for (int L = 0; L < this.size; L++) {
            	tile[L][size-1].setType(1); //on ajoute des murs de pierre si le nombre de joueurs est inférieur à 4
=======
			getTile()[7][1].setType(4+i);
			i = rand.nextInt(3);
			getTile()[7][6].setType(4+i);
        } else {
        	if (Main.numberPlayers == 3) {
    			int i = rand.nextInt(3);
    			getTile()[7][0].setType(4+i);
    			i = rand.nextInt(3);
    			getTile()[7][3].setType(4+i);
    			i = rand.nextInt(3);
    			getTile()[7][6].setType(4+i);
        	} else {
    			int i = rand.nextInt(3);
    			getTile()[7][3].setType(4+i);
        	}
        	
            for (int L = 0; L < size; L++) {
            	getTile()[L][size-1].setType(1); //on ajoute des murs de pierre si le nombre de joueurs est inférieur à 4
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
            }
    		System.out.println("DEBUG: Murs de pierres ajoutés");
        }
	}
<<<<<<< HEAD
	
	
	
	public int openTiles(int x, int y) {
		int o = 0;
		for (int i = x-1; i < x+2; i++) {
			if ((i >= 0) & (i <= 7)) {
	    		System.out.println("DEBUG: i == " + i);	
				for (int j = y-1; j < y+2; j++) {
		    		System.out.println("DEBUG: j == " + i);	
					if ((j >= 0) & (j <= 7)) {
						if (tile[i][j].getType()==0) {
							o++;
						}
=======
		
	public Tile[][] getTile() {
		return tile;
	}
	
	public int numberBlocks(int x, int y) {
		int b = 0;
		for (int i = -1; i < 2;i++) {
			for (int j = -1; j < 2;j++) {
				if (x+i >= 0 && x+i <= 7 && y+j >= 0 && y+j <= 7) {
					if (this.tile[x+i][y+j].getType() == 0) {
						b++;
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
					}
				}
			}
		}
<<<<<<< HEAD
		return o;
	}
	
	public void show() {
		System.out.println("|12345678|");
		for (int L = 0; L < this.size; L++) {
			System.out.print("|");
            for (int C = 0; C < this.size; C++) {
            	if (tile[L][C].associatedPlayer != null) {
        			System.out.print(tile[L][C].associatedPlayer.color);
            	} else {
            		if (tile[L][C].getType() == 0) {
            			System.out.print(".");
            		}else if (tile[L][C].getType() == 1) {
            			System.out.print("S");
            		}else if (tile[L][C].getType() == 2) {
            			System.out.print("I");
            		}else if (tile[L][C].getType() == 3) {
            			System.out.print("C");
            		}else if (tile[L][C].getType() == 4) {
            			System.out.print("B");
            		}else if (tile[L][C].getType() == 5) {
            			System.out.print("R");
            		}else if (tile[L][C].getType() == 6) {
            			System.out.print("V");
            		}else if (tile[L][C].getType() == 7) {
            			System.out.print("P");
            		}
            	}
            }
			System.out.println("|");
		}
	}
=======
		return b;
	}
	
	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
}
