package de._1nulleins0.GameTest.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import de._1nulleins0.GameTest.framework.GameObject;
import de._1nulleins0.GameTest.framework.ObjectID;

public class Block extends GameObject {

    public Block(float x, float y, ObjectID id) {
	super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
	g.setColor(Color.white);
	g.drawRect((int) x, (int) y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
	return new Rectangle((int) x, (int) y, 32, 32);
    }

}
