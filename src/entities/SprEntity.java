package entities;

import java.awt.image.BufferedImage;

import framework.Painter;
import resources.Spritesheet;

public class SprEntity {
	
	// Player pequeno
	
	public static BufferedImage[] sprSPlayerJumping;
	public static BufferedImage[] sprSPlayerWalking;
	public static BufferedImage[] sprSPlayerIdle;
	public static BufferedImage[] sprSPlayerFalling;
	
	
	// Carregar sprites

	public static void loadSPlayer(Spritesheet spritesheet) {
		sprSPlayerIdle = new BufferedImage[1];
		sprSPlayerIdle[0] = spritesheet.getSprite(0, Painter.sprSize*1, 16, 16);
		
		sprSPlayerWalking = new BufferedImage[2];
		sprSPlayerWalking[0] = spritesheet.getSprite(Painter.sprSize*1, Painter.sprSize*1, 16, 16);
		sprSPlayerWalking[1] = spritesheet.getSprite(Painter.sprSize*2, Painter.sprSize*1, 16, 16);
		
		sprSPlayerFalling = new BufferedImage[1];
		sprSPlayerFalling[0] = spritesheet.getSprite(Painter.sprSize*1, Painter.sprSize*2, 16, 16);

		sprSPlayerJumping = new BufferedImage[1];
		sprSPlayerJumping[0] = spritesheet.getSprite(Painter.sprSize*0, Painter.sprSize*2, 16, 16);
	
	}
	
}
