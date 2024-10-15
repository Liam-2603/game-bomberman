package uet.oop.bomberman.entities.moveEntities.Effect;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;

//hiệu ứng lửa dưới chân (tăng tốc độ)
public class FlamePassEffect extends Effect{
    public FlamePassEffect(double x, double y, Image img) {
        super(x, y, img);
        this.type = "FlamePass";
    }

    @Override
    public void update() {
        if(BombermanGame.getBomber().flamePass) {
            effectAnim();
            x = BombermanGame.getBomber().getX();
            y = BombermanGame.getBomber().getY();
        } else {
            destroy();
        }
    }
}
