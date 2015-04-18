package de._1nulleins0.PlatformerGame.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import de._1nulleins0.PlatformerGame.core.Handler;

public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {
	this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();

	for (int i = 0; i < handler.objects.size(); i++) {
	    GameObject tempObject = handler.objects.get(i);

	    switch (tempObject.getID()) {
		case Player:
		    switch (key) {
			case KeyEvent.VK_D:
			    tempObject.setVelX(5);
			    break;
			case KeyEvent.VK_A:
			    tempObject.setVelX(-5);
			    break;
			case KeyEvent.VK_SPACE:
			    if (!tempObject.isJumping()) {
				tempObject.setJumping(true);
				tempObject.setVelY(-10);
				break;
			    }
			default:
			    break;
		    }
		    break;
		default:
		    break;
	    }
	}

	if (key == KeyEvent.VK_ESCAPE) {
	    System.exit(1);
	}
    }

    public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();

	for (int i = 0; i < handler.objects.size(); i++) {
	    GameObject tempObject = handler.objects.get(i);

	    switch (tempObject.getID()) {
		case Player:
		    switch (key) {
			case KeyEvent.VK_D:
			case KeyEvent.VK_A:
			    tempObject.setVelX(0);
			    break;
			default:
			    break;
		    }
		    break;
		default:
		    break;
	    }
	}
    }
}
