package game.util;

import game.GameMain;
import sun.audio.AudioPlayer;
import com.sun.media.sound.WaveFileReader;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class AudioHandler {
    WaveFileReader reader = new WaveFileReader();
    String resourceName = "";
    static AudioInputStream song;
    Clip sound;
    public AudioHandler(String resources){
        resourceName= "/"+resources;
        initiate();
    }
    int initiate() {
        return 0;
    }
    public int play() {

        //InputStream poly = song;
        //AudioPlayer.player.start(poly);
        try {
            AudioPlayer.player.start(GameMain.class.getResourceAsStream(resourceName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
   
    public int stop(){
        try {
            AudioPlayer.player.stop(GameMain.class.getResourceAsStream(resourceName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    void threadPlay() {

    }


}