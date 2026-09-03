package framework;

import java.awt.Graphics;

import game.Game;

public class Main {

	
	public Main() {
		Painter painter = new Painter(this);
		Runner runner = new Runner(this, painter);
		
		runner.startThread();
		
		Game game = new Game();
		
		painter.setVisible();
	}
	
	public static void main(String[] args) {
		System.out.printf("Carregando jogo...\n");
		
		Main main = new Main();
		
		System.out.printf("Jogo carregado.\n\n");
	}
	

	public void step() {
		
	}
	
	public void render(Graphics g) {
		
	}
}
