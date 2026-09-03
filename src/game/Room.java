package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.Tile;
import tiles.TileList;

public class Room {

	private Tile[] tiles;
	public int width, height; // Medido em tiles '-'
	public int level;
	
	public Room(int llevel) {
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
					System.out.printf(" ");
					break;
				case TileList.tileBrick:
					System.out.printf("X");
					break;
				case TileList.tilePlayerSpawn:
					System.out.printf("A");
				}
			}
			
			System.out.printf("\n");
		}
	}
	
}
