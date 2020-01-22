package Main;

import java.util.Random;


public class Board {
	int size = 8;
	private Tile[][] tile = new Tile[size][size];
	
	
	public Board() {
        Random rand = new Random();
		for (int L = 0; L < size; L++) {
            for (int C = 0; C < size; C++) {
        		getTile()[L][C] = new Tile();
        		getTile()[L][C].setType(0); // on vide toutes les cases
            }
		}
        if (Main.numberPlayers == 4) {
			int i = rand.nextInt(3);
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
            }
        }
	}
		
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
					}
				}
			}
		}
		return b;
	}
	
	
}
