package Main;

public class Card {
	int type = 0; //0 = bleu, 1 = jaune, 2 = violette, 3 = laser, 4 = Bug
	
	
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
		}  else if (this.type == 3) {
			return ("Carte Laser");
		} else {
			return ("Carte Bug");
		}
	}
}
