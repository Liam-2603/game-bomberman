package uet.oop.bomberman.entities.stillEntities.mortal.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.moveEntities.Effect.InvincibilityEffect;

//item bất tử
public class InvincibilityItem extends Item{

    public InvincibilityItem(double x, double y, Image img) {
        super(x, y, img);
    }

    public InvincibilityItem(double x, double y, Image img, int time) {
        super(x, y, img);
        BombermanGame.getBomber().invincibilityTime = time;
        BombermanGame.getBomber().invincibility = true;
        BombermanGame.effects.add(new InvincibilityEffect(x, y, null));
    }

    public void restart() {
        BombermanGame.getBomber().invincibility = true;
        BombermanGame.getBomber().invincibilityTime = 10000/16;
    }

    @Override
    public void destroy() {
        sound.getItem.play();
        if(!BombermanGame.getBomber().invincibility) {
            BombermanGame.effects.add(new InvincibilityEffect(BombermanGame.getBomber().getX(), BombermanGame.getBomber().getY(), null));
        }
        restart();
        BombermanGame.stillObjects.remove(this);
    }
}
