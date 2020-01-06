package Case;

public class Obstacle {
	int type; // 0 = mur de pierre, 1 = mur de glace, 2 = caisse
	int[] position;
	
	public int getType() {
		return type;
	}
	
	public void setType(int a) {
		type = a;
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
