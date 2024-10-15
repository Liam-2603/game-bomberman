package uet.oop.bomberman.entities.moveEntities.Effect;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.moveEntities.MoveEntities;

public abstract class Effect extends MoveEntities {
    private int animCount = 0;
    protected String type;

    public Effect(double x, double y, Image img) {
        super(x, y, img);
    }

    //hiệu ừng nhân vật (load hình ảnh)
    public void effectAnim() {
        int k = animCount++ / 10;
        this.img = new Image("sprites/" + type + (k % 3 + 1) + ".png");
        if(animCount == 99900) animCount = 0;
    }

    @Override
    public void update() { }

    @Override
    public void destroy() {
        BombermanGame.effects.remove(this);
    }
}
