package framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	public static boolean left, right, up, down;
	public static boolean vk_z, vk_x, vk_space, vk_escape;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			vk_z = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			vk_x = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			vk_space = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			vk_escape = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			vk_z = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			vk_x = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			vk_space = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			vk_escape = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
