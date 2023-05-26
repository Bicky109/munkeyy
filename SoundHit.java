import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundHit {
    Clip clip;
    AudioInputStream ais;
    // File[] soundFile = new File[30];
    File file1 = new File("sounds/hit.wav");

    public SoundHit() {
        // soundFile[1] = file1;
        setFile(file1);
    }

    public void setFile(File f) {
        try {
            ais = AudioSystem.getAudioInputStream(f);
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
        clip.loop(5);
    }

    public void stop() {
        clip.stop();
    }
}
