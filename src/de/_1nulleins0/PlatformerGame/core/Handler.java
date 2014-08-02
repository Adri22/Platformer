package de._1nulleins0.PlatformerGame.core;

import java.awt.Graphics;
import java.util.LinkedList;

import de._1nulleins0.PlatformerGame.framework.GameObject;
import de._1nulleins0.PlatformerGame.framework.ObjectID;
import de._1nulleins0.PlatformerGame.objects.Block;

public class Handler {
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    private GameObject tempObject;

    public void updateObjects() {
	for (int i = 0; i < objects.size(); i++) {
	    tempObject = objects.get(i);
	    tempObject.update(objects);
	}
    }

    public void render(Graphics g) {
	for (int i = 0; i < objects.size(); i++) {
	    tempObject = objects.get(i);
	    tempObject.render(g);
	}
    }

    public void addObject(GameObject object) {
	this.objects.add(object);
    }

    public void removeObject(GameObject object) {
	this.objects.remove(object);
    }

    public void createLevel() {
	for (int step = 0; step < Game.HEIGHT + 32; step += 32) { // testing
	    addObject(new Block(0, step, ObjectID.Block));
	}

	for (int step = 0; step < Game.WIDTH + 32; step += 32) { // testing
	    addObject(new Block(step, Game.HEIGHT - 32, ObjectID.Block));
	}

	for (int step = 200; step < 600; step += 32) { // testing
	    addObject(new Block(step, 550, ObjectID.Block));
	}
    }
}
