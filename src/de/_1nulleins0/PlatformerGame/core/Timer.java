package de._1nulleins0.PlatformerGame.core;

public class Timer {

    private long lastTime = System.nanoTime();
    private double amountOfTicks = 60.0;
    private double ns = 1000000000 / amountOfTicks;
    private double delta = 0;
    private long timer = System.currentTimeMillis();
    private int frames = 0;
    private int updates = 0;

    private boolean checkMillis() {
	if (System.currentTimeMillis() - timer > 1000) {
	    return true;
	} else {
	    return false;
	}
    }

    public void setNewTime() {
	long now = System.nanoTime();
	delta += (now - lastTime) / ns;
	lastTime = now;
    }

    public boolean checkDelta() {
	if (delta >= 1) {
	    updates++;
	    delta--;
	    return true;
	} else {
	    return false;
	}
    }

    public void incrementFrames() {
	frames++;
	if (checkMillis()) {
	    System.out.println("FPS: " + frames + " TICKS: " + updates);
	    timer += 1000;
	    frames = 0;
	    updates = 0;
	}
    }
}
