package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Camera;

public class Tile {

	
	protected BufferedImage sprite;
	protected int x, y;
	protected boolean visible;
	
	public Tile(BufferedImage ssprite, int xx, int yy, boolean vvisible) {
		sprite = ssprite;
		x = xx;
		y = yy;
		visible = vvisible;
	}
	
	public void render(Graphics g) {
		if (visible && sprite != null) {
			g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
		}
	}
}
