package de._1nulleins0.PlatformerGame.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import de._1nulleins0.PlatformerGame.framework.KeyInput;
import de._1nulleins0.PlatformerGame.framework.ObjectID;
import de._1nulleins0.PlatformerGame.objects.Player;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -850345177889691148L;
    private boolean running = false;
    private Thread thread;

    public static int WIDTH;
    public static int HEIGHT;

    Timer t;
    Handler handler;
    Camera cam;

    private void init() {

	WIDTH = getWidth();
	HEIGHT = getHeight();

	t = new Timer();
	handler = new Handler();
	cam = new Camera(0, 0);

	handler.addObject(new Player(100, 100, handler, ObjectID.Player));
	handler.createLevel();

	this.addKeyListener(new KeyInput(handler));
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
		updateGame();
	    }
	    render();
	    t.incrementFrames();
	}
    }

    private void updateGame() {
	handler.updateObjects();

	for (int i = 0; i < handler.objects.size(); i++) {
	    if (handler.objects.get(i).getID() == ObjectID.Player) {
		cam.updateCam(handler.objects.get(i));
	    }

	}

    }

    private void render() {
	BufferStrategy bs = this.getBufferStrategy();
	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics g = bs.getDrawGraphics();
	Graphics2D g2d = (Graphics2D) g;

	// ------- draw stuff here ----------

	g.setColor(Color.black);
	g.fillRect(0, 0, getWidth(), getHeight());

	g2d.translate(cam.getX(), cam.getY());

	handler.render(g);

	g2d.translate(-cam.getX(), -cam.getY());

	// ----------------------------------

	g.dispose();
	bs.show();
    }

    public static void main(String args[]) {
	new Window(1024, 768, "Platformer", new Game());
    }
}
