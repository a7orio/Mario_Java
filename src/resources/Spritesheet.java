package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	private BufferedImage spritesheet;
	
	public Spritesheet(String path) {
		try {
			spritesheet = ImageIO.read(this.getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
	
	public static BufferedImage invertSprite(BufferedImage sprOriginal) {
		BufferedImage sprInverted = new BufferedImage(sprOriginal.getWidth(), sprOriginal.getHeight(), sprOriginal.getType());
		
		for (int y = 0; y < sprInverted.getHeight(); y++) {
			for (int x = 0; x < sprInverted.getWidth(); x++) {
				sprInverted.setRGB(sprOriginal.getWidth() - 1 - x, y, sprOriginal.getRGB(x, y));			}
		}
		
		return sprInverted;
	}
	
}
