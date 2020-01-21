package Main;

public class Tile {
	int type = 0; // 0 = tuile vide
				// 1 = mur de pierre, 2 = mur de glace, 3 = caisse
				// 4 = joyau bleu, 5 = joyau rouge, 6 = joyau vert, 7 = joyau rose
				// 8 = Tortue
	Player associatedPlayer;
	
	public Tile() {
		
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
	}
	
	
	public void setPlayer(int a) {
		associatedPlayer = Main.currentGame.players.get(a);
	}
	
	public void removePlayer() {
		associatedPlayer = null;
	}
	
	
	public String toString() { // Retourne le nom de la tuile en fonction de son type
		if (this.type == 0) {
			return ("Tuile Vide");
		} else if (this.type == 1) {
			return ("Mur de pierre");
		} else if (this.type == 2) {
			return ("Mur de glace");
		} else if (this.type == 3) {
			return ("Caisse");
		} else if (this.type == 4) {
			return ("Joyau Bleu");
		} else if (this.type == 5) {
			return ("Joyau Rouge");
		} else if (this.type == 6) {
			return ("Joyau Vert");
		} else if (this.type == 7){
			return ("Joyau Rose");
		} else {
			return ("Tortue");
		}
	}

	public Player getPlayer() {
		return associatedPlayer;
	}

}
