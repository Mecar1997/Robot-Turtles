package Main;

public class Case {
	int[] type; // 0 = case vide, 1 = mur, 2 = joyau
				// Pour les murs, 0 = mur de pierre, 1 = mur de glace, 2 = caisse
				// Pour les joyaux, 0 = joyau bleu, 1 = joyau rouge, 2 = joyau vert, 3 = joyau rose
	
	public int[] getType() {
		return type;
	}
	
	public void setType(int a, int b) {
		type[0] = a;
		type[0] = b;
	}
	
	public String toString() { // retourner le nom de le case en fonction de son type
		if (this.type[0] == 0) {
			return ("Case Vide");
		} else if (this.type[0] == 1) {
			if (this.type[1] == 0) {
				return ("Mur de pierre");
			} else if (this.type[1] == 1) {
				return ("Mur de glace");
			} else {
				return ("Caisse");
			}
		} else {
			if (this.type[1] == 0) {
				return ("Joyau Bleu");
			} else if (this.type[1] == 1) {
				return ("Joyau Rouge");
			} else if (this.type[1] == 2) {
				return ("Joyau Vert");
			} else {
				return ("Joyau Rose");
			}
		}
	}

}
