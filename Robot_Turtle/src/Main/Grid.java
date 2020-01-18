package Main;

public class Grid {
	int type = 0; // 0 = case vide
				// Pour les murs, 1 = mur de pierre, 2 = mur de glace, 3 = caisse
				// Pour les joyaux, 4 = joyau bleu, 5 = joyau rouge, 6 = joyau vert, 7 = joyau rose
				// 8 = Tortue
	
	
	public Grid() {
		
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
	}
	
	public String toString() { // retourner le nom de le case en fonction de son type
		if (this.type == 0) {
			return ("Case Vide");
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

}
