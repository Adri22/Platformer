package de._1nulleins0.PlatformerGame.core;

import de._1nulleins0.PlatformerGame.framework.GameObject;

public class Camera {

    private float x, y;

    public Camera(float x, float y) {
	this.x = x;
	this.y = y;
    }

    public float getX() {
	return x;
    }

    public void setX(float x) {
	this.x = x;
    }

    public float getY() {
	return y;
    }

    public void setY(float y) {
	this.y = y;
    }

    public void updateCam(GameObject player) {
	x = -player.getX() + Game.WIDTH / 2;
    }

}
