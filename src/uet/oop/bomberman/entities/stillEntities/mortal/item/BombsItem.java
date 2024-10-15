package uet.oop.bomberman.entities.stillEntities.mortal.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;

//item tăng số lượng bom
public class BombsItem extends Item{
    public BombsItem(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void destroy() {
        if(!(BombermanGame.bombs == BombermanGame.MAX_BOMBS)) BombermanGame.bombs += 1;
        sound.getItem.play();
        BombermanGame.stillObjects.remove(this);
    }
}
