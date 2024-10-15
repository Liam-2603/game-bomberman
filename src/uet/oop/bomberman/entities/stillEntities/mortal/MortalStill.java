package uet.oop.bomberman.entities.stillEntities.mortal;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Mortal;
import uet.oop.bomberman.entities.stillEntities.StillEntities;
//
public class MortalStill extends StillEntities implements Mortal {
    public MortalStill(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void destroy() {

    }
}
