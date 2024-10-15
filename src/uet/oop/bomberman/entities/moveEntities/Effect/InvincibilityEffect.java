package uet.oop.bomberman.entities.moveEntities.Effect;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;

//Hiệu ứng bất tử
public class InvincibilityEffect extends Effect {
    public InvincibilityEffect(double x, double y, Image img) {
        super(x, y, img);
        this.type = "Invincibility";
    }

    @Override
    public void update() {
        if(BombermanGame.getBomber().invincibility) {
            effectAnim();
            x = BombermanGame.getBomber().getX();
            y = BombermanGame.getBomber().getY();
        } else {
            destroy();
        }
    }
}
