package entities;

import java.awt.Graphics;

import framework.Keyboard;
import framework.Main;
import game.Room;
import game.Stats;
import resources.Spritesheet;

public class Player extends Entity{

	private Stats stats;
	private Room room;
	
	private double gravity = 0.1;
	private double hspeed, vspeed;
	
	private boolean left; // Direção
	
	private boolean walking, jumping, falling, running;
	private int walkIndex = 0, walkFrame = 0, walkMaxFrame = 15;
	
	public void setRoom(Room r) {
		room = r;
	}
	
	public Player(double xx, double yy, Stats sstats) {
		super(xx, yy);
		SprEntity.loadSPlayer(Main.sprsheet);
		width = 16;
		height = 16;
		sprite = SprEntity.sprSPlayerIdle[0];
		colide = true;
		visible = true;
	}
	
	private void running() {
		if (Keyboard.left && room.isFree((int) (x+hspeed), (int)y)) {
			hspeed = -1;
			left = true;
			walking = true;
		}else if(Keyboard.right && room.isFree((int) (x+hspeed), (int)y)) {
			hspeed = 1;
			left = false;
			walking = true;
		}else {
			hspeed = 0;
			walking = false;
			walkIndex = 0;
		}
		
		if (room.canDrop((int) (x), (int) (y + vspeed))) {
			vspeed += gravity;
			falling = true;
		}else {
			vspeed = 0;
			falling = false;
		}
	}
	
	
	public void animate() {
		if (walking) {
			if (jumping) {
				
			}else if (falling) {
				
			}else {	
				walkFrame++;
				if (walkFrame > walkMaxFrame) {
					walkFrame = 0;
					walkIndex++;
					if (walkIndex >= SprEntity.sprSPlayerWalking.length) {
						walkIndex = 0;
					}
				}
				if (left) {
					sprite = Spritesheet.invertSprite(SprEntity.sprSPlayerWalking[walkIndex]);
				}else {
					sprite = SprEntity.sprSPlayerWalking[walkIndex];
				}
			}
		}else if(falling) {
			if (left) {
				sprite = Spritesheet.invertSprite(SprEntity.sprSPlayerFalling[0]);
			}else {
				sprite = SprEntity.sprSPlayerFalling[0];
			}
		}else {
			if (left) {
				sprite = Spritesheet.invertSprite(SprEntity.sprSPlayerIdle[0]);
			}else {
				sprite = SprEntity.sprSPlayerIdle[0];
			}
		}
	}
	
	public void step() {
		running();
		animate();
		
		x += hspeed;
		y += vspeed;
	}
	
	public void render(Graphics g) {
		super.render(g);
	}

}
