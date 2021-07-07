/*
   Menu.java
    
   Created at Jul 07, 1:32 PM:09 
*/
package com.Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Random;

/**
 * @author Jeddi
 */
public class Menu extends MouseAdapter {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.gameState == Game.STATE.MENU) {
            // Play Button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                Game.gameState = Game.STATE.GAME;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

                AudioPlayer.getSound("menu_sound").play();
            }

            // Help Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                Game.gameState = Game.STATE.HELP;

                AudioPlayer.getSound("menu_sound").play();
            }

            // Quit Button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }

        // Back Button for Help
        if (Game.gameState == Game.STATE.HELP) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                Game.gameState = Game.STATE.MENU;

                AudioPlayer.getSound("menu_sound").play();
            }
        }

        // Try Again Button
        if (Game.gameState == Game.STATE.END) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                Game.gameState = Game.STATE.GAME;
                hud.setLevel(1);
                hud.setScore(0);
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

                AudioPlayer.getSound("menu_sound").play();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        } else return false;
    }

    public void tick() {

    }

    public void render(Graphics g) {

        if (Game.gameState == Game.STATE.MENU) {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Wave", 245, 70);

            g.setFont(font2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 278, 192);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 278, 292);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 278, 392);
        } else if (Game.gameState == Game.STATE.HELP) {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            Font font3 = new Font("arial", 1, 20);

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Help", 245, 70);

            g.setFont(font3);
            g.drawString("Use WASD key to move player and dodge enemies", 78, 200);

            g.setFont(font2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 278, 392);
        } else if (Game.gameState == Game.STATE.END) {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            Font font3 = new Font("arial", 1, 20);

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Game Over", 180, 70);

            g.setFont(font3);
            g.drawString("You lost with a score of: " + hud.getScore(), 168, 200);

            g.setFont(font2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try Again", 248, 392);
        }

    }

}
