package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import framework.Main;
import framework.Painter;
import tiles.ColTile;
import tiles.Tile;
import tiles.TileList;

public class Room {

	private Game game;
	
	private Tile[] tiles;
	public int width, height; // Medido em tiles '-'
	public int level;
	
	public Room(int llevel, Game g) {
		game = g;
		level = llevel;
		try {
			BufferedImage map = ImageIO.read(this.getClass().getResource("/rooms/room"+level+".png"));
			width = map.getWidth();
			height = map.getHeight();
			
			tiles = new Tile[width * height];
			
			int[] pixels = new int[width * height];
			
			map.getRGB(0, 0, width, height, pixels, 0, width);
			carregarRoom(pixels);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarRoom(int[] pixels) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				switch (pixels[x + (y * width)]) {
				case 0XFF000000: // Nada
					tiles[x + (y * width)] = null;
					break;
				case TileList.tileBrick:
					tiles[x + (y * width)] = new ColTile(Main.sprsheet.getSprite(0, 16*5, 16, 16), x*16, y*16, true);
					break;
				case TileList.tilePlayerSpawn:
					game.player.setPosition(x*16, y*16);
				}
			}
		}
	}
	
	public boolean isFree(int nextX, int nextY) {
		
		int x1 = nextX/Painter.sprSize;
		int y1 = nextY/Painter.sprSize;
		
		int x2 = nextX / Painter.sprSize +1;
		int y2 = nextY / Painter.sprSize;
		
		if (x1 + (y1 * width) > tiles.length || x2 + (y2 * width) > tiles.length){
			return true;
		}
		
		return !(tiles[x1 + (y1 * width)] instanceof ColTile ||
				tiles[x2 + (y2 * width)] instanceof ColTile );
	}
	
	public boolean canDrop(int nextX, int nextY) {
		
		int x1 = nextX/Painter.sprSize;
		int y1 = nextY/Painter.sprSize + 1;
		
		int x2 = nextX / Painter.sprSize +1;
		int y2 = nextY / Painter.sprSize + 1;
		
		if (x1 + (y1 * width) > tiles.length || x2 + (y2 * width) > tiles.length){
			return true;
		}
		
		return !(tiles[x1 + (y1 * width)] instanceof ColTile ||
				tiles[x2 + (y2 * width)] instanceof ColTile );
	}
	
	public void render(Graphics g) {
		for (Tile t : tiles) {
			if (t != null) {
				t.render(g);
			}
			
		}
	}
	
}
