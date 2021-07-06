/*
   HUD.java
    
   Created at Jul 06, 4:09 PM:49 
*/
package com.Game;

import java.awt.*;

/**
 * @author Jeddi
 */
public class HUD {

    public static int HEATLH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void tick() {
        HEATLH = (int) Game.clamp(HEATLH, 0, 100);
        greenValue = (int) Game.clamp(greenValue, 0, 255);

        greenValue = HEATLH * 2;

        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEATLH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
