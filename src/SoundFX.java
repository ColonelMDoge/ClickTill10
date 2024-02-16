import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundFX {

    Clip soundEffects;
    public Clip ambienceEffects;

    private final URL counterClickEffect = getClass().getResource("Buttons.wav");
    private final URL errorClickEffect = getClass().getResource("Error.wav");
    private final URL dialogueSoundEffect = getClass().getResource("Dialogue.wav");

    private final URL menu = getClass().getResource("BoundlessSlumber.wav");
    private final URL end = getClass().getResource("PoseidonRealm.wav");
    private final URL glitchEffect = getClass().getResource("Glitch.wav");
    private final URL finalEnd = getClass().getResource("FloatingInAbyss.wav");

    private final URL[] effects = {counterClickEffect, errorClickEffect, dialogueSoundEffect};
    private final URL[] songs = {menu, end, glitchEffect, finalEnd};

    public void playSong(int sound) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(songs[sound]);
            ambienceEffects = AudioSystem.getClip();
            ambienceEffects.open(ais);
            ((FloatControl) ambienceEffects.getControl(FloatControl.Type.MASTER_GAIN)).setValue(-15);
            ambienceEffects.loop(Clip.LOOP_CONTINUOUSLY);
            ambienceEffects.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playEffect(int sound) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(effects[sound]);
            soundEffects = AudioSystem.getClip();
            soundEffects.open(ais);
            ((FloatControl) soundEffects.getControl(FloatControl.Type.MASTER_GAIN)).setValue(-5);
            soundEffects.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
