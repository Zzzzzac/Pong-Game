/*Music
**This class is to set the background music.
**User could decide turn on or off the music
**by pressing the key "V"
**/
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music
{
    public static Clip clip; // Set a new clip

    /**
     * Loading the stored music in "res" doc
     * @throws Exception
     */
    public static void load() throws Exception // Music load.
    {
        clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream(Music.class.getResource("BGM.wav"));
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the background music continuously.
    }

    /**
     * To pause the muusic by call the stop method in Clip
     */
    // Pause the music
    public static void pause()
    {
        clip.stop();
    }

    /**
     * To resume the paused music
     */
    // Resume the paused music
    public static void resume()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}