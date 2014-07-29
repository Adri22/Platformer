package de._1nulleins0.GameTest.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

    protected float width, height;
    protected float x, y;
    protected float velX = 0, velY = 0;
    protected ObjectID id;
    protected boolean falling = true;
    protected boolean jumping = false;

    public GameObject(float x, float y, float width, float height, ObjectID id) {
	this.width = width;
	this.height = height;
	this.x = x;
	this.y = y;
	this.id = id;
    }

    public abstract void update(LinkedList<GameObject> object);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public boolean isFalling() {
	return falling;
    }

    public void setFalling(boolean falling) {
	this.falling = falling;
    }

    public boolean isJumping() {
	return jumping;
    }

    public void setJumping(boolean jumping) {
	this.jumping = jumping;
    }

    public float getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public float getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public float getX() {
	return x;
    };

    public float getY() {
	return y;
    };

    public void setX(float x) {
	this.x = x;
    };

    public void setY(float y) {
	this.y = y;
    };

    public float getVelX() {
	return velX;
    };

    public float getVelY() {
	return velY;
    };

    public void setVelX(float velX) {
	this.velX = velX;
    };

    public void setVelY(float velY) {
	this.velY = velY;
    };

    public ObjectID getID() {
	return id;
    };

}
