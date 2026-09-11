package framework;

import java.awt.Graphics;

import game.Game;
import resources.Spritesheet;

public class Main {

	
	private Game game;
	
	public static Spritesheet sprsheet;
	
	public Main() {
		Painter painter = new Painter(this);
		Runner runner = new Runner(this, painter);
	
		// Carregar recursos
		
		sprsheet = new Spritesheet("/spritesheets/sheet0.png");
		
		game = new Game();
		
		runner.startThread();
		painter.setVisible();
	}
	
	public static void main(String[] args) {
		System.out.printf("Carregando jogo...\n");
		
		Main main = new Main();
		
		System.out.printf("Jogo carregado.\n\n");
	}
	

	public void step() {
		game.step();
	}
	
	public void render(Graphics g) {
		game.render(g);
	}
}
