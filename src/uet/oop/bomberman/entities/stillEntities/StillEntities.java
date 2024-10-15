package uet.oop.bomberman.entities.stillEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
//
public abstract class StillEntities extends Entity {
    public StillEntities(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }
}
