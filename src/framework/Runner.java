package framework;

public class Runner implements Runnable{

	

	// Objetos
	private Thread thread;
		
	// Referẽncias
	
	private Main main;
	private Painter paint;
	
	// Propriedades globais
	
	private static final double sps = 1000000000 / 60;
	private static final double fps = 1000000000 / 30;
	
	
	// Variáveis

	private double accS = 0;
	private double accG = 0;
	private long lastT, nowT, elapsedT;
	private long clockT;
	private long sleep;
	private int countS = 0;
	private int countG = 0;
	
	private boolean rodando;
	
	
	// Métodos
	
	public Runner(Main m, Painter p) {
		main = m;
		paint = p;
		thread = new Thread(this);
	}
	
	public synchronized void startThread() {
		if (rodando) return;
		
		rodando = true;
		thread.start();
	}
	
	public synchronized void stopThread() {
		if (!rodando) return;
		
		rodando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void step() {
		main.step();
		accS--;
		countS++;
	}
	
	private void gstep() {
		paint.gstep();
		accG--;
		countG++;
	}
	
	
	@Override
	public void run() {
		lastT = System.nanoTime();
		clockT = System.currentTimeMillis();
		while (rodando) {
			nowT = System.nanoTime();
			elapsedT = nowT - lastT;
			lastT += elapsedT;
			
			accS += elapsedT / sps;
			accG += elapsedT / fps;
			
			while (accS >= 1) {
				step();
			}
			
			if (accG >= 1) {
				gstep();
			}
			
			if (System.currentTimeMillis() - clockT >= 1000) {
				System.out.printf("Steps; %d Renders: %d\n", countS, countG);
				countS = 0;
				countG = 0;
				clockT+=1000;
			}
			
			if (accS < 1.0 ) {
				sleep = (long) ((1.0 - accS) * sps );
				
				try {
					Thread.sleep((int)(sleep / 1000000),(int) (sleep % 1000000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		stopThread();
		
	}
	
}
