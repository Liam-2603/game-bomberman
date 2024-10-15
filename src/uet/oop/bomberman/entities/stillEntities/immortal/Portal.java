package uet.oop.bomberman.entities.stillEntities.immortal;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.stillEntities.StillEntities;

//Map - gạch
public class Portal extends StillEntities {
    public boolean isOpen = false;

    public Portal(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if(!(isOpen) && BombermanGame.score == BombermanGame.levelMaxScore) {
            this.isOpen = true;
            this.img = new Image(String.valueOf(Portal.class.getResource("/sprites/portal_open.png")));
        }
    }
}
