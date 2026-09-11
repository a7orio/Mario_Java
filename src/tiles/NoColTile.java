package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NoColTile extends Tile{

	public NoColTile(BufferedImage ssprite, int xx, int yy, boolean vvisible) {
		super(ssprite, xx, yy, vvisible);
		
	}

	public void render(Graphics g) {
		super.render(g);
	}
}
