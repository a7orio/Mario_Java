package game;

import entities.Entity;

public class Camera {

	public static Entity following;
	public static int x = 0, y = 0;
	
	
	public static int clamp(int nextE, int minAxis, int maxAxis) {
		
		if (nextE < minAxis) {
			return minAxis;
		}else if(nextE > maxAxis) {
			return maxAxis;
		}
		
		return nextE;
	}
	
	
	public static void resetCamera() {
		x = 0;
		y = 0;
		following = null;
	}
}
