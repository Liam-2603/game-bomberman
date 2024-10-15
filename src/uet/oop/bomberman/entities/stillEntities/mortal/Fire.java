package uet.oop.bomberman.entities.stillEntities.mortal;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;
//sát thương của bom
public class Fire extends MortalStill {
    private int explodeTime = 23; // because explodeBomb() in Bomb runs sooner than 'this' 1 frame
    private String imgName;

    public Fire(double x, double y, Image img) {
        super(x, y, img);
        this.imgName = null;
    }

    public Fire(double x, double y, Image img, String type, boolean isLast) {
        super(x, y, img);
        this.imgName = "explosion_" + type;
    }

    public Fire(double x, double y, Image img, String type, boolean isLast, String lastType) {
        super(x, y, img);
        this.imgName = "explosion_" + type;
        if(isLast) {
            this.imgName += "_" + lastType;
        }
    }

    @Override
    public void update() {
        explodeTime--;
        int k = explodeTime / 6;
        if(imgName != null) {
            switch (k) {
                case 3:
                    this.img = Sprite.sprite(this.imgName).getFxImage(); break;
                case 2: case 0:
                    this.img = Sprite.sprite(this.imgName + "1").getFxImage(); break;
                default:
                    this.img = Sprite.sprite(this.imgName + "2").getFxImage(); break;
            }
        }
        /*if(explodeTime > 0 && 12 % explodeTime == 2) {
            Bomb.checkInstanceBomb(this);
        }*/
        if(this.explodeTime < 0) BombermanGame.damagesObjects.remove(this);
    }

    @Override
    public void destroy() {

    }
}
