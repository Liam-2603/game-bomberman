package uet.oop.bomberman.sound;

import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import uet.oop.bomberman.BombermanGame;

import java.net.URL;
import java.util.ResourceBundle;

public class Sound {
    // Sound effect
    public MediaPlayer startSound = makeSound("Level_Start.mp3");
    public MediaPlayer walking = makeSound("Walk_cut1.mp3", 0.125);
    public MediaPlayer makeBomb = makeSound("Make_Bomb.mp3", 20);
    public MediaPlayer bombExplodes = makeSound("Bomb_Explodes.mp3", 3);
    public MediaPlayer getItem = makeSound("Get_Item.mp3");
    public MediaPlayer getDamage = makeSound("Get_Damage.mp3");
    public MediaPlayer kill_Enemy = makeSound("Kill_Enemy.mp3", 0.5);
    public MediaPlayer death = makeSound("Death.mp3");

    // Soundtrack
    public MediaPlayer findTheExit = makeSound("Find_The_Exit.mp3", 0.6);
    public MediaPlayer currentThemeSound;

    public static void repeat(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
    }
    //phát lại âm thanh nền
    public void replay(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.play();
    }
    //phát âm thanh
    public void playSound(String mp3File) {
        makeSound(mp3File).play();
    }
    //load âm thanh
    public MediaPlayer makeSound(String mp3File) {
        URL resource = SoundController.class.getResource("/sound/");
        Media sound = new Media(resource + mp3File);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        return mediaPlayer;
    }
    //load âm thanh với âm lượng
    public MediaPlayer makeSound(String mp3File, double volume) {
        MediaPlayer res = makeSound(mp3File);
        res.setVolume(volume);
        return res;
    }
    //dùng trong bomber, lúc nhân vật bị kết liễu và hết mạng để hồi sinh
    public void stopAll() {
        SoundController.stopAllSounds(this);
    }
}
