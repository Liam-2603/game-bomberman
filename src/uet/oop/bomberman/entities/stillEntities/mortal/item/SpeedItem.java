package uet.oop.bomberman.entities.stillEntities.mortal.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;

//item tăng tốc độ chạy
public class SpeedItem extends Item {
    public SpeedItem(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void destroy() {
        sound.getItem.play();
        if(!(BombermanGame.speed == BombermanGame.MAX_SPEED)) BombermanGame.speed += 1;
        BombermanGame.stillObjects.remove(this);
    }
}
