package Main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tile {
	int type = 0; // 0 = tuile vide
				// 1 = mur de pierre, 2 = mur de glace, 3 = caisse
				// 4 = joyau bleu, 5 = joyau rouge, 6 = joyau vert, 7 = joyau rose
				// 8 = Tortue
	Player associatedPlayer;
	ImageIcon icon;
	
	public Tile() {
		
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
		setIcon();
	}
	
	
	public void setPlayer(Player a) {
		associatedPlayer = a;
	}
	
	public void removePlayer() {
		associatedPlayer = null;
	}
	
	public boolean isObstacle() {
		if (type == 1 || type == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isJewel() {
		if ((type > 3) && (type < 8)) {
			return true;
		} else {
			return false;
		}
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
	
	
	public ImageIcon getIcon() {
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
}
