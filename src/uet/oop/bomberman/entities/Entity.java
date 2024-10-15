package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;
//entity
public abstract class Entity {
    protected double x;
    protected double y;
    protected Image img;
    public Entity(double x, double y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Image getImg() {
        return this.img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public static double round1(double n) {
        return (double) Math.round(n * 10) / 10;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x * Sprite.SCALED_SIZE, y * Sprite.SCALED_SIZE);
    }

    public abstract void update();

}
