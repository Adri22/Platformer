package de._1nulleins0.PlatformerGame.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import de._1nulleins0.PlatformerGame.framework.KeyInput;
import de._1nulleins0.PlatformerGame.framework.ObjectID;
import de._1nulleins0.PlatformerGame.objects.Block;
import de._1nulleins0.PlatformerGame.objects.Player;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -850345177889691148L;
    private boolean running = false;
    private Thread thread;

    public static int WIDTH;
    public static int HEIGHT;

    private BufferedImage level = null;

    Timer t;
    Handler handler;
    Camera cam;

    private void init() {

	WIDTH = getWidth();
	HEIGHT = getHeight();

	BufferedImageLoader imgLoader = new BufferedImageLoader();
	level = imgLoader.loadImage("/lvl/level_test1.png"); // test

	t = new Timer();
	handler = new Handler();
	cam = new Camera(0, 0);

	loadImgLevel(level);

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

	    if (t.checkDelta()) {
		updateGame();
	    }
	    renderGame();
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

    private void renderGame() {
	BufferStrategy bs = this.getBufferStrategy();

	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics g = bs.getDrawGraphics();
	Graphics2D g2d = (Graphics2D) g;

	g.setColor(Color.black);
	g.fillRect(0, 0, getWidth(), getHeight());

	g2d.translate(cam.getX(), cam.getY());

	handler.renderObjects(g);

	g2d.translate(-cam.getX(), -cam.getY());

	g.dispose();
	bs.show();
    }

    private void loadImgLevel(BufferedImage img) {
	int w = img.getWidth();
	int h = img.getHeight();

	for (int stepX = 0; stepX < w; stepX++) {
	    for (int stepY = 0; stepY < h; stepY++) {

		int pixel = img.getRGB(stepX, stepY);
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;

		// black => level-element
		if (red == 0 && green == 0 && blue == 0) {
		    handler.addObject(new Block(
			    stepX * 32,
			    stepY * 32,
			    ObjectID.Block
			    ));
		}

		// blue => player startposition
		if (red == 0 && green == 0 && blue == 255) {
		    handler.addObject(new Player(
			    stepX * 32,
			    stepY * 32,
			    handler,
			    ObjectID.Player
			    ));
		}
	    }
	}
    }

    public static void main(String args[]) {
	new Window(1024, 768, "Platformer", new Game());
    }
}
