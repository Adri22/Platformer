package de._1nulleins0.GameTest.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import de._1nulleins0.GameTest.framework.ObjectID;
import de._1nulleins0.GameTest.objects.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -850345177889691148L;
	private boolean running = false;
	private Thread thread;

	public static int WIDTH;
	public static int HEIGHT;
	
	Timer t;
	Handler handler;
	// Random rand = new Random();

	private void init() {
		
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		t = new Timer();
		handler = new Handler();
		
		handler.addObject(new Player(100, 100, ObjectID.Player));
		handler.createLevel();
	}

	public synchronized void start() {
		if (running) {
			return;
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		init();
		this.requestFocus();

		while (running) {
			t.setNewTime();

			while (t.checkDelta()) {
				tick();
			}
			render();
			t.incrementFrames();
		}
	}

	private void tick() {
		handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// ------- draw stuff here ----------

		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		handler.render(g);

		// ----------------------------------

		g.dispose();
		bs.show();
	}

	public static void main(String args[]) {
		new Window(800, 600, "Test", new Game());
	}
}
