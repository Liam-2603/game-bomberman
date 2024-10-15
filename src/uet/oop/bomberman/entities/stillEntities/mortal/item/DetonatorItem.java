package uet.oop.bomberman.entities.stillEntities.mortal.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;

//Item thêm mạng
public class DetonatorItem extends Item{
    public DetonatorItem(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void destroy() {
        if(BombermanGame.life < BombermanGame.MAX_LIFE) BombermanGame.life += 1;
        sound.getItem.play();
        BombermanGame.stillObjects.remove(this);
    }
}
