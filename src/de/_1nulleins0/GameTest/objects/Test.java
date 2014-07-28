package de._1nulleins0.GameTest.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import de._1nulleins0.GameTest.framework.GameObject;
import de._1nulleins0.GameTest.framework.ObjectID;

public class Test extends GameObject {

	public Test(float x, float y, ObjectID id) {
		super(x, y, id);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 32, 32);
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public float getVelX() {
		return velX;
	}

	@Override
	public float getVelY() {
		return velY;
	}

	@Override
	public void setVelX(float velX) {
		this.velX = velX;
	}

	@Override
	public void setVelY(float velY) {
		this.velY = velY;
	}

	@Override
	public ObjectID getID() {
		return id;
	}

}
