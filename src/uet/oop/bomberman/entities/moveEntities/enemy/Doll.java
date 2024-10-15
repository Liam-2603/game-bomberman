package uet.oop.bomberman.entities.moveEntities.enemy;

import javafx.scene.image.Image;

import java.util.Random;

//quái Doll
public class Doll extends Enemy{
    public Doll(double x, double y, Image img) {
        super(x, y, img);
        this.type = "doll";
        this.speed = 5;
        this.point = 1200;
    }

    public Doll(double x, double y, Image img, int speed) {
        super(x, y, img, speed);
        this.type = "doll";
        this.speed = speed;
        this.point = 1200;
    }

    @Override
    public void moveHandle() {
        setDifOpsDirect();
        super.moveHandle();
    }
}
