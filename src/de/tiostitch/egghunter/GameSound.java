package de.tiostitch.egghunter;

import de.tiostitch.egghunter.utilities.SoundType;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameSound {

    private final SoundType type;

    public GameSound(SoundType type) {
        this.type = type;
    }

    public void play() {
        try {
            File file = new File(getClass().getResource(type.getLocation()).toURI());

            if (!file.exists()) {
                System.out.println("[DEBUG] Ocorreu um erro ao executar a música!");
                return;
            }

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);

            clip.start();
        } catch (Exception e) {
            return;
        }
    }

    public void stop() {
        try {
            File file = new File(getClass().getResource(type.getLocation()).toURI());

            if (!file.exists()) {
                System.out.println("[DEBUG] Ocorreu um erro ao executar a música!");
                return;
            }

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);

            clip.stop();
        } catch (Exception e) {
            return;
        }
    }
}
