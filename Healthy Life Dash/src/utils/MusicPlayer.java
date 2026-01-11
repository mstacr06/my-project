package utils;

import javax.sound.sampled.*;
import java.net.URL;

public class MusicPlayer {

    private static Clip clip;

    public static void play() {
        if (clip != null && clip.isRunning()) return;

        try {
            URL url = MusicPlayer.class.getResource("/sounds/game.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (clip != null) clip.stop();
    }
}
