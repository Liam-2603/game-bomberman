package uet.oop.bomberman.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

public class SoundController {

    //load âm thanh
    public static MediaPlayer makeSound(String mp3File) {
        URL resource = SoundController.class.getResource("/sound/");
        //System.out.println(resource + mp3File);
        Media sound = new Media(resource + mp3File);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        return mediaPlayer;
    }

    //load âm thanh cùng với âm lượng
    public static MediaPlayer makeSound(String mp3File, double volume) {
        MediaPlayer res = makeSound(mp3File);
        res.setVolume(volume);
        return res;
    }
    //lặp lại
    public static void repeatMedia(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
    }

    //dừng mọi âm thanh (lúc hết life)
    public static void stopAllSounds(Sound sound) {
        sound.startSound.stop();
        sound.walking.stop();
        sound.makeBomb.stop();
        sound.bombExplodes.stop();
        sound.getItem.stop();
        sound.getDamage.stop();
        sound.kill_Enemy.stop();
        sound.death.stop();

        // Soundtrack
        sound.findTheExit.stop();
        sound.currentThemeSound.stop();
    }
}
