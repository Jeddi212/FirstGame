/*
   SmartEnemy.java
    
   Created at Jul 06, 5:51 PM:06 
*/
package com.Game;

import java.awt.*;

/**
 * @author Jeddi
 */
public class SmartEnemy extends GameObject {

    private Handler handler;
    GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                player = handler.object.get(i);
            }
        }

        velX = 5;
        velY = 5;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt(
                (x - player.getX()) *
                (x - player.getX()) +
                (y - player.getY()) *
                (y - player.getY())
        );

        velX = (float) ((-1.0 / distance) * diffX);
        velY= (float) ((-1.0 / distance) * diffY);

        if (y <= 0 || y >= Game.HEIGHT - 54) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.MAGENTA, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect((int) x, (int) y, 16, 16);
    }

}
