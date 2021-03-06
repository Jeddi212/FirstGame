/*
   Handler.java
    
   Created at Jul 06, 2:40 PM:08 
*/
package com.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jeddi
 */
public class Handler {

    ArrayList<GameObject> object = new ArrayList<>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void clearEnemies() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if (tempObject.getId() == ID.Player) {
                object.clear();
                if (Game.gameState != Game.STATE.END)
                addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
            }
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
