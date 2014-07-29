package de._1nulleins0.GameTest.core;

import java.awt.Graphics;
import java.util.LinkedList;

import de._1nulleins0.GameTest.framework.GameObject;
import de._1nulleins0.GameTest.framework.ObjectID;
import de._1nulleins0.GameTest.objects.Block;

public class Handler {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    private GameObject tempObject;

    public void updateObjects() {
	for (int i = 0; i < object.size(); i++) {
	    tempObject = object.get(i);
	    tempObject.update(object);
	}
    }

    public void render(Graphics g) {
	for (int i = 0; i < object.size(); i++) {
	    tempObject = object.get(i);
	    tempObject.render(g);
	}
    }

    public void addObject(GameObject object) {
	this.object.add(object);
    }

    public void removeObject(GameObject object) {
	this.object.remove(object);
    }

    public void createLevel() {
	for (int step = 0; step < Game.WIDTH + 32; step += 32) { // testing
	    addObject(new Block(step, Game.HEIGHT - 32, ObjectID.Block));
	}
    }
}
