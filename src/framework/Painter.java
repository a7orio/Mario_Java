package framework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Painter extends Canvas{

	// Objetos
	
	private JFrame frame;
	private BufferedImage bimage;
	private BufferStrategy bs;
	private Graphics g;
	
	// Referências
	
	private Main main;
	
	// Propriedades globais

	private static final String title = "Mario";
	public static final int sprSize = 16;
	public static final int width = 16 * sprSize;
	public static final int height = 12 * sprSize;
	private static final int zoom = 4;
	
	// Métodos
	
	public Painter(Main m) {
		main = m;
		
		bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		frame = new JFrame(title);
		this.setSize(new Dimension(width * zoom, height * zoom));
		
		frame.add(this);
		frame.pack();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		this.addKeyListener(new Keyboard());
		this.requestFocus();
	}
	
	public void setVisible() {
		if (frame.isVisible() == false) {
			frame.setVisible(true);
		}else {
			frame.setVisible(false);
		}
	}
	
	public void gstep() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		g = bimage.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		main.render(g);
		
		g.dispose();
		
		g = bs.getDrawGraphics();
		g.drawImage(bimage, 0,0, width * zoom, height * zoom, null);
		g.dispose();
		
		bs.show();
	}
	
}
