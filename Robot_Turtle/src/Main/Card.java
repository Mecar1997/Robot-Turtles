package Main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {
	int type = 0; //0 = bleu, 1 = jaune, 2 = violette, 3 = laser, 4 = Bug
<<<<<<< HEAD
=======
	ImageIcon icon = new ImageIcon(new ImageIcon("images/CardBlue.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT)); //icone qui s'affichera sur l'interface graphique
	String tooltip; // tooltip qui apparait quand on met le curseur de la souris sur la carte
	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	
	//Getters and Setters
	
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
		setIcon();
		setTooltip();
	}
	
	public String toString() { //retourne le nom de la carte en fonction de son type
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
	
<<<<<<< HEAD
	
	public String toStringDebug() {
		if (this.type == 0) {
			return ("B");
		} else if (this.type == 1) {
			return ("J");
		} else if (this.type == 2) {
			return ("V");
		} else if (this.type == 3){
			return ("L");
		} else {
			return ("R"); //TODO: Carte bug
=======
	public ImageIcon getIcon() {
		return icon;
	}
	
	public String getTooltip() {
		return tooltip;
	}
	
	public void setIcon() {
		if (this.type == 0) {
			icon = new ImageIcon(new ImageIcon("images/CardBlue.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
		} else if (this.type == 1) {
			icon = new ImageIcon(new ImageIcon("images/CardYellow.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
		} else if (this.type == 2) {
			icon = new ImageIcon(new ImageIcon("images/CardPurple.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
		}  else if (this.type == 3) {
			icon = new ImageIcon(new ImageIcon("images/CardLaser.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
		} else {
			icon = new ImageIcon(new ImageIcon("images/CardEmpty.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
		}
	}
	
	public void setTooltip() {
		if (this.type == 0) {
			tooltip = "Fait avancer la tortue d’une case";
		} else if (this.type == 1) {
			tooltip = "Fait tourner la tortue dans le sens anti-horaire";
		} else if (this.type == 2) {
			tooltip = "Fait tourner la tortue dans le sens horaire";
		}  else if (this.type == 3) {
			tooltip = "Touche la première tuile se trouvant en face de la tortue. Si la tuile touchée est un mur de glace, celui-ci va fondre et disparaître";
		} else {
			tooltip = "Inverse le programme d'un autre joueur";
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
		}
	}
}
