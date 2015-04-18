package de._1nulleins0.PlatformerGame.core;

public class Timer {

    private long timer;
    private long lastTime;
    private long now;
    private double amountOfTicks;
    private double nanoseconds;
    private double deltaTime;
    private int fps;

    public Timer() {
	timer = System.currentTimeMillis();
	lastTime = System.nanoTime();
	now = 0;
	amountOfTicks = 60.0;
	nanoseconds = 1000000000 / amountOfTicks;
	deltaTime = 0;
	fps = 0;
    }

    private boolean checkLapsedMillis() {
	if (System.currentTimeMillis() - timer > 1000) {
	    return true;
	} else {
	    return false;
	}
    }

    public void setNewTime() {
	now = System.nanoTime();
	deltaTime += (now - lastTime) / nanoseconds;
	lastTime = now;
    }

    public boolean checkDelta() {
	if (deltaTime >= 1) {
	    deltaTime--;
	    return true;
	} else {
	    return false;
	}
    }

    public void incrementFrames() {
	fps++;
	if (checkLapsedMillis()) {
	    System.out.println("FPS: " + fps);
	    timer += 1000;
	    fps = 0;
	}
    }

    public int getFPS() {
	return fps;
    }
}