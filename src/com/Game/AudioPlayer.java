/*
   AudioPlayer.java
    
   Created at Jul 07, 3:39 PM:57 
*/
package com.Game;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeddi
 */
public class AudioPlayer {

    public static Map<String, Sound> soundMap = new HashMap<>();
    public static Map<String, Music> musicMap = new HashMap<>();

    public static void load() {

        try {
            soundMap.put("menu_sound", new Sound("res/click.wav"));

            musicMap.put("music", new Music("res/audio.ogg"));
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    //java -Djava.library.path="C:\Users\Jeddi\IdeaProjects\FirstGame\lib\lwjgl\native\windows" -classpath "FirstGame" com.Game.Game

    public static Music getMusic(String key) {
        return musicMap.get(key);
    }

    public static Sound getSound(String key) {
        return soundMap.get(key);
    }
}
