package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import entities.Player;
import framework.Painter;

public class Game {

	public Stats stats;
	
	public Room room;
	public Player player;
	
	public List<Entity> entidades;
	
	public Game() {
		stats = new Stats();
		
		loadRoom();
	}
	
	public void loadRoom() {
		entidades = new ArrayList<Entity>();
		player = new Player(0,0, stats);
		entidades.add(player);
		room = new Room(stats.level, this);
	
		player.setRoom(room);
		
		Camera.following = player;
	}
	
	
	public void step() {
		player.step();
		
		if (Camera.following != null) {
			Camera.x = Camera.clamp((Camera.following.getPosition()[0] - Painter.width/2 + 8), 0, room.width*16 - Painter.width);
			Camera.y = Camera.clamp(Camera.following.getPosition()[1], 0, room.height*16 - Painter.height);
		}
	}
	
	public void render(Graphics g) {
		room.render(g);
		player.render(g);
	}
}
