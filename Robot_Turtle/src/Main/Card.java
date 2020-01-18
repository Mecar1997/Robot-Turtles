package Main;

public class Card {
	int type = 0; //0 = bleu, 1 = jaune, 2 = violette, 3 = laser
	
	
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
	}
	
	public String toString() {
		if (this.type == 0) {
			return ("Carte Bleue");
		} else if (this.type == 1) {
			return ("Carte Jaune");
		} else if (this.type == 2) {
			return ("Carte Violette");
		}  else{
			return ("Carte Laser");
		}
	}
	
	
	public String toStringDebug() {
		if (this.type == 0) {
			return ("B");
		} else if (this.type == 1) {
			return ("J");
		} else if (this.type == 2) {
			return ("V");
		}  else{
			return ("L");
		}
	}
}
