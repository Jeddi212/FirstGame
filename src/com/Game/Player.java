/*
   Player.java
    
   Created at Jul 06, 2:52 PM:14 
*/
package com.Game;

import java.awt.*;

/**
 * @author Jeddi
 */
public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int) x, 0, Game.WIDTH - 48);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 71);

        collision();

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.WHITE, 32, 32, 0.1f, handler));

    }

    private void collision() {
        for (GameObject tempObject : handler.object) {

            if (tempObject.getId() == ID.BasicEnemy
                    || tempObject.getId() == ID.FastEnemy
                    || tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // Collision code
                    HUD.HEATLH -= 2;
                }
            }

        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, 32, 32);
    }

}
