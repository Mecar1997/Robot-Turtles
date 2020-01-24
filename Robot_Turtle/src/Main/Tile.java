package Main;

<<<<<<< HEAD
=======
import java.awt.Image;

import javax.swing.ImageIcon;

>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
public class Tile {
	int type = 0; // 0 = tuile vide
				// 1 = mur de pierre, 2 = mur de glace, 3 = caisse
				// 4 = joyau bleu, 5 = joyau rouge, 6 = joyau vert, 7 = joyau rose
				// 8 = Tortue
<<<<<<< HEAD
	Player associatedPlayer;
	
	public Tile() {
		
	}
	
=======
	
	Player associatedPlayer; // pour les tuiles tortues, le joueur qui correspond à cette tortue
	ImageIcon icon; // icône de la tuile
	
	public Tile() {//constructeur
	}
	
	
	//getters and setters
	
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
<<<<<<< HEAD
	}
	
	
	public void setPlayer(int a) {
		associatedPlayer = Main.playersList[a];
=======
		setIcon();
	}
	
	
	public void setPlayer(Player a) {
		associatedPlayer = a;
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
	}
	
	public void removePlayer() {
		associatedPlayer = null;
	}
	
<<<<<<< HEAD
	
	public String toString() { // retourne le nom de la tuile en fonction de son type
=======
	public Player getPlayer() {
		return associatedPlayer;
	}
	
	
	public ImageIcon getIcon() {
		setIcon();
		return icon;
	}
	
	public void setIcon() {
		if (this.type == 0) {
			icon = null;
		} else if (this.type == 1) {
			icon = new ImageIcon(new ImageIcon("images/wall_stone.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
		} else if (this.type == 2) {
			icon = new ImageIcon(new ImageIcon("images/wall_ice.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
		}  else if (this.type == 3) {
			icon = new ImageIcon(new ImageIcon("images/wall_wood.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));	
		} else if (this.type == 4) {
			icon = new ImageIcon(new ImageIcon("images/jewel_blue.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
		} else if (this.type == 5) {
			icon = new ImageIcon(new ImageIcon("images/jewel_red.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
		} else if (this.type == 6) {
			icon = new ImageIcon(new ImageIcon("images/jewel_green.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
		} else if (this.type == 7) {
			icon =  new ImageIcon(new ImageIcon("images/jewel_purple.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
		} else if (this.type == 8) {
			Player p = associatedPlayer;
			 if (p.getColor() == 0) {
				 if (p.getDirection() == 0) {
					 icon = new ImageIcon(new ImageIcon("images/blueN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 1) {
					 icon = new ImageIcon(new ImageIcon("images/blueW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 2) {
					 icon = new ImageIcon(new ImageIcon("images/blueS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 3) {
					 icon = new ImageIcon(new ImageIcon("images/blueE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 }
			 } else	if (p.getColor() == 1) {
				 if (p.getDirection() == 0) {
					 icon = new ImageIcon(new ImageIcon("images/redN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 1) {
					 icon = new ImageIcon(new ImageIcon("images/redW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 2) {
					 icon = new ImageIcon(new ImageIcon("images/redS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 3) {
					 icon = new ImageIcon(new ImageIcon("images/redE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 }
			 } else	if (p.getColor() == 2) {
				 if (p.getDirection() == 0) {
					 icon = new ImageIcon(new ImageIcon("images/greenN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 1) {
					 icon = new ImageIcon(new ImageIcon("images/greenW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 2) {
					 icon = new ImageIcon(new ImageIcon("images/greenS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 3) {
					 icon = new ImageIcon(new ImageIcon("images/greenE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 }
			 } else	if (p.getColor() == 3) {
				 if (p.getDirection() == 0) {
					 icon = new ImageIcon(new ImageIcon("images/purpleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 1) {
					 icon = new ImageIcon(new ImageIcon("images/purpleW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 2) {
					 icon = new ImageIcon(new ImageIcon("images/purpleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 } else if (p.getDirection() == 3) {
					 icon = new ImageIcon(new ImageIcon("images/purpleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
				 }
			 }
		}
	}
	
	
	
	//méthodes
	
	public boolean isObstacle() { //si c'est un mur
		if (type == 1 || type == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isJewel() {// si c'est un joyau
		if ((type > 3) && (type < 8)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public String toString() { // Retourne le nom de la tuile en fonction de son type
>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
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

<<<<<<< HEAD
=======

>>>>>>> f527e4a76e11c47d9e16daec52065471b0eba5de
}
