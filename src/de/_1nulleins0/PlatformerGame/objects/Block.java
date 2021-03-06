package de._1nulleins0.PlatformerGame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import de._1nulleins0.PlatformerGame.framework.GameObject;
import de._1nulleins0.PlatformerGame.framework.ObjectID;

public class Block extends GameObject {

    public Block(float x, float y, ObjectID id) {
	super(x, y, 32, 32, id);
    }

    @Override
    public void update(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
	g.setColor(Color.white);
	g.drawRect((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public Rectangle getBounds() {
	return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

}
