/*
   Handler.java
    
   Created at Jul 06, 2:40 PM:08 
*/
package com.Game;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author Jeddi
 */
public class Handler {

    LinkedList<GameObject> object = new LinkedList<>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject tempObject : object) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
