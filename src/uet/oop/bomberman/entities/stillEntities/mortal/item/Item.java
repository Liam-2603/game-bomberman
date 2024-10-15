package uet.oop.bomberman.entities.stillEntities.mortal.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.stillEntities.mortal.MortalStill;
import uet.oop.bomberman.sound.Sound;

//item ẩn
public abstract class Item extends MortalStill {
    Sound sound = new Sound();
    public Item(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if(Math.round(BombermanGame.getBomber().getX()) == Math.round(x)
                && Math.round(BombermanGame.getBomber().getY()) == Math.round(y)) {
            destroy();
        }
    }
}

