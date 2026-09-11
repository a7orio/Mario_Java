package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Camera;

public class Entity {

	
	protected BufferedImage sprite;
	protected double x, y;
	protected int width, height;
	protected Rectangle mask;
	protected boolean visible, colide;
	
	
	public Entity(double xx, double yy) {
		x = xx;
		y = yy;
	}
	
	public void step() {
		
	}
	
	
	public void setPosition(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public int[] getPosition() {
		return new int[]{(int) x, (int) y};
	}
	
	public void render(Graphics g) {
		if (visible) {
			g.drawImage(sprite, (int) x - Camera.x, (int) y - Camera.y, null);
		}
	}
	
}
