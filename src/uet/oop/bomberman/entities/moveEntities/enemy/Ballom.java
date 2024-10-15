package uet.oop.bomberman.entities.moveEntities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.moveEntities.Bomber;

import java.util.Random;

//quái Ballom
public class Ballom extends Enemy {
    public Ballom(double x, double y, Image img) {
        super(x, y, img);
        this.speed = 1;
        this.point = 100;
        this.type = "balloom";
    }

    @Override
    public void moveHandle() {
        setDifOpsDirect();
        super.moveHandle();
    }
}
