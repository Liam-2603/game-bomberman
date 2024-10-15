package uet.oop.bomberman.entities.stillEntities.mortal;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.stillEntities.immortal.Grass;
import uet.oop.bomberman.entities.stillEntities.StillEntities;
import uet.oop.bomberman.graphics.Sprite;

//gạch
public class Brick extends MortalStill {
    private int explodeTime = 24;
    private boolean still = true;
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if(!still) {
            explodeTime--;
            if(this.explodeTime < 0) {
                BombermanGame.stillObjects.add(0, new Grass((int)x, (int)y, Sprite.grass.getFxImage()));
                BombermanGame.stillObjects.remove(this);
            }
            int k = explodeTime / 6;
            switch (k) {
                case 3:
                    this.img = Sprite.brick_exploded.getFxImage();
                    break;
                case 2: case 0:
                    this.img = Sprite.brick_exploded1.getFxImage();
                    break;
                default:
                    this.img = Sprite.brick_exploded2.getFxImage();
                    break;
            }
        }
    }

    @Override
    public void destroy() {
        still = false;
    }
}
