package Main;

public class Case {
	int[] type; // 0 = mur, 1 = joyau
				// Pour les murs, 0 = mur de pierre, 1 = mur de glace, 2 = caisse
				// Pour les joyaux, 0 = joyau bleu, 1 = joyau rouge, 2 = joyau vert, 3 = joyau rose
	int[] position;
	
	public int[] getType() {
		return type;
	}
	
	public void setType(int a, int b) {
		type[0] = a;
		type[0] = b;
	}
	
	public void removeObstacle() {
		position[0] = -1;
		position [1] = -1;
	}
	
	public void placeObstacle (int a, int b) {
		position[0] = a;
		position[1] = b;
	}
}
