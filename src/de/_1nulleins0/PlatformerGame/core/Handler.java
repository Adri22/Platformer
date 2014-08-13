package de._1nulleins0.PlatformerGame.core;

import java.awt.Graphics;
import java.util.LinkedList;

import de._1nulleins0.PlatformerGame.framework.GameObject;

public class Handler {
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    private GameObject tempObject;

    public void updateObjects() {
	for (int i = 0; i < objects.size(); i++) {
	    tempObject = objects.get(i);
	    tempObject.update(objects);
	}
    }

    public void renderObjects(Graphics g) {
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
}
