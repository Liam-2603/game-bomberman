package uet.oop.bomberman.entities.stillEntities.mortal.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.moveEntities.Effect.FlamePassEffect;

//item thêm sat thương
public class FlamePassItem extends Item {
    public FlamePassItem(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void destroy() {
        try {
            sound.getItem.play();
            if(BombermanGame.getBomber().flamePass) {
                BombermanGame.getBomber().flamePassRestart();
            } else {
                BombermanGame.getBomber().flamePass = true;
                BombermanGame.effects.add(
                        new FlamePassEffect(BombermanGame.getBomber().getX(), BombermanGame.getBomber().getY(), null));
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("Bomber cannot found!");
        }
        BombermanGame.stillObjects.remove(this);
    }
}
