package de._1nulleins0.PlatformerGame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import de._1nulleins0.PlatformerGame.core.Handler;
import de._1nulleins0.PlatformerGame.framework.GameObject;
import de._1nulleins0.PlatformerGame.framework.ObjectID;

public class Player extends GameObject {

    private float gravity = 0.5f;
    private final float MAX_SPEED = 10;

    private Handler handler;

    public Player(float x, float y, Handler handler, ObjectID id) {
	super(x, y, 48, 96, id);
	this.handler = handler;
    }

    @Override
    public void update(LinkedList<GameObject> object) {
	x += velX;
	y += velY;

	if (falling || jumping) {
	    velY += gravity;

	    if (velY > MAX_SPEED) {
		velY = MAX_SPEED;
	    }
	}

	collision(object);
    }

    private void collision(LinkedList<GameObject> object) {
	for (int i = 0; i < handler.objects.size(); i++) {
	    GameObject tempObject = handler.objects.get(i);

	    switch (tempObject.getID()) {
		case Block:
		    if (getBoundsTop().intersects(tempObject.getBounds())) {
			y = tempObject.getY() + tempObject.getHeight();
			velY = 0;
		    }

		    if (getBounds().intersects(tempObject.getBounds())) {
			y = tempObject.getY() - height;
			velY = 0;
			falling = false;
			jumping = false;
		    } else {
			falling = true;
		    }

		    if (getBoundsLeft().intersects(tempObject.getBounds())) {
			x = tempObject.getX() + tempObject.getWidth();
		    }

		    if (getBoundsRight().intersects(tempObject.getBounds())) {
			x = tempObject.getX() - width;
		    }
		    break;
		default:
		    break;
	    }
	}
    }

    @Override
    public void render(Graphics g) {
	g.setColor(Color.blue);
	g.fillRect((int) x, (int) y, (int) width, (int) height);

	Graphics2D g2d = (Graphics2D) g;

	// g.setColor(Color.red);
	g2d.draw(getBounds());
	g2d.draw(getBoundsRight());
	g2d.draw(getBoundsLeft());
	g2d.draw(getBoundsTop());
    }

    @Override
    public Rectangle getBounds() {
	return new Rectangle(
		(int) ((int) x + (width / 2) - ((width / 2) / 2)),
		(int) ((int) y + (height / 2)),
		(int) width / 2,
		(int) height / 2);
    }

    public Rectangle getBoundsTop() {
	return new Rectangle((int) (
		(int) x + (width / 2) - ((width / 2) / 2)),
		(int) y,
		(int) width / 2,
		(int) height / 2);
    }

    public Rectangle getBoundsRight() {
	return new Rectangle(
		(int) ((int) x + width - 5),
		(int) y + 5,
		(int) 5,
		(int) height - 10);
    }

    public Rectangle getBoundsLeft() {
	return new Rectangle(
		(int) x,
		(int) y + 5,
		(int) 5,
		(int) height - 10);
    }

}
