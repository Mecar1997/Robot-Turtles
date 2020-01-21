package Main;

import java.util.Random;


public class Board {
	int size = 8;
	private Tile[][] tile = new Tile[8][8];
	
	
	public Board() {
	}
	
	public void initialisation() {
        Random rand = new Random();
		System.out.println("DEBUG: Initialisation");
		for (int L = 0; L < this.size; L++) {
            for (int C = 0; C < this.size; C++) {
        		getTile()[L][C] = new Tile();
        		getTile()[L][C].setType(0); // on vide toutes les cases
            }
		}
        if (Main.currentGame.numberPlayers == 4) {
			int i = rand.nextInt(3);
			getTile()[7][1].setType(4+i);
			i = rand.nextInt(3);
			getTile()[7][6].setType(4+i);
        } else {
        	if (Main.currentGame.numberPlayers == 3) {
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
        	
            for (int L = 0; L < this.size; L++) {
            	getTile()[L][size-1].setType(1); //on ajoute des murs de pierre si le nombre de joueurs est inférieur à 4
            }
    		System.out.println("DEBUG: Murs de pierres ajoutés");
        }
	}
	
	
	
	public int openTiles(int x, int y) {
		int o = 0;
		for (int i = x-1; i < x+2; i++) {
			if ((i >= 0) & (i <= 7)) {
	    		System.out.println("DEBUG: i == " + i);	
				for (int j = y-1; j < y+2; j++) {
		    		System.out.println("DEBUG: j == " + i);	
					if ((j >= 0) & (j <= 7)) {
						if (getTile()[i][j].getType()==0) {
							o++;
						}
					}
				}
			}
		}
		return o;
	}
	
	public void show() {
		System.out.println("|12345678|");
		for (int L = 0; L < this.size; L++) {
			System.out.print("|");
            for (int C = 0; C < this.size; C++) {
            	if (getTile()[L][C].associatedPlayer != null) {
        			System.out.print(getTile()[L][C].associatedPlayer.color);
            	} else {
            		if (getTile()[L][C].getType() == 0) {
            			System.out.print(".");
            		}else if (getTile()[L][C].getType() == 1) {
            			System.out.print("S");
            		}else if (getTile()[L][C].getType() == 2) {
            			System.out.print("I");
            		}else if (getTile()[L][C].getType() == 3) {
            			System.out.print("C");
            		}else if (getTile()[L][C].getType() == 4) {
            			System.out.print("B");
            		}else if (getTile()[L][C].getType() == 5) {
            			System.out.print("R");
            		}else if (getTile()[L][C].getType() == 6) {
            			System.out.print("V");
            		}else if (getTile()[L][C].getType() == 7) {
            			System.out.print("P");
            		}
            	}
            }
			System.out.println("|");
		}
	}

	public Tile[][] getTile() {
		return tile;
	}

	public void setTile(Tile[][] tile) {
		tile = tile;
	}
}
