/*
   EnemyBossBullet.java
    
   Created at Jul 07, 1:00 PM:45 
*/
package com.Game;

import java.awt.*;
import java.util.Random;

/**
 * @author Jeddi
 */
public class EnemyBossBullet extends GameObject {

    private Handler handler;
    Random r = new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = r.nextInt(5 - -5) + -5;
        velY = 5;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

//        if (y <= 0 || y >= Game.HEIGHT - 54) velY *= -1;
//        if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

        if (y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.RED, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 16, 16);
    }

}
