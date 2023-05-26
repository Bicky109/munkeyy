import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        // soundURL[1] = getClass().getResource("sounds/level1.wav");
        soundURL[2] = getClass().getResource("sounds/level2.wav");
        soundURL[3] = getClass().getResource("sounds/level3.wav");
        soundURL[4] = getClass().getResource("sounds/level4.wav");
        soundURL[5] = getClass().getResource("sounds/level5.wav");
        soundURL[6] = getClass().getResource("sounds/attack.wav");
        soundURL[7] = getClass().getResource("sounds/gethit.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println("No sound");
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
