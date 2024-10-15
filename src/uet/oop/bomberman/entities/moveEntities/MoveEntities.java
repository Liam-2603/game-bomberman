package uet.oop.bomberman.entities.moveEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Mortal;
import uet.oop.bomberman.entities.moveEntities.enemy.Enemy;
import uet.oop.bomberman.entities.stillEntities.immortal.Wall;
import uet.oop.bomberman.entities.stillEntities.mortal.Bomb;
import uet.oop.bomberman.entities.stillEntities.mortal.Brick;
import uet.oop.bomberman.entities.stillEntities.mortal.Fire;
import uet.oop.bomberman.sound.Sound;

import java.util.List;

public class MoveEntities extends Entity implements Mortal {
    public MoveEntities(double x, double y, Image img) {
        super(x, y, img);
    }

    //kiểm tra vật thế có đứng yên không
    public static boolean checkStillObject(Entity object) {
        List<Entity> entityList = BombermanGame.stillObjects;
        for (Entity entity : entityList) {
            if (Math.round(entity.getX()) == Math.round(object.getX()) && Math.round(entity.getY()) == Math.round(object.getY())) {
                if (entity instanceof Wall) return true;
                if (entity instanceof Brick) {
                    return true;
                }
            }
        }
        return false;
    }

    //kiểm tra xem có sát thương vào vật thể không
    public static boolean checkInstanceDamages(Entity object) {
        for(int i = 0; i < BombermanGame.damagesObjects.size(); i++) {
            if((int) Math.round(object.getX()) == (int) Math.round(BombermanGame.damagesObjects.get(i).getX())
                    && (int) Math.round(object.getY()) == (int) Math.round(BombermanGame.damagesObjects.get(i).getY())) {
                if(object instanceof Bomber) {
                    if(BombermanGame.damagesObjects.get(i) instanceof Fire || BombermanGame.damagesObjects.get(i) instanceof Bomb) {
                        if(((Bomber) object).flamePass) return true;
                    }
                    ((Bomber)object).destroy();
                } else if(object instanceof Enemy){
                    if((BombermanGame.damagesObjects.get(i) instanceof Fire || BombermanGame.damagesObjects.get(i) instanceof Bomb)) {
                        ((Enemy)object).destroy();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //kiểm tra xem có vật thể xung quanh không
    public static boolean checkInstanceStill(Entity object, String type) {
        boolean res = true;
        double space = (object instanceof Bomber)? 0.9 : 1.0;
        switch (type) {
            case "up":
                for(int i = 0; i < BombermanGame.stillObjects.size(); i++) {
                    Entity still = BombermanGame.stillObjects.get(i);
                    if(round1(Math.abs(still.getX() - round1(object.getX()))) < space
                            && round1(object.getY()) - still.getY() > 0.7 && round1(object.getY() - still.getY()) <= round1(space)) {
                        if(still instanceof Wall || still instanceof Brick) {
                            //if (object instanceof Bomber)
                            //System.out.println(still.toString() + " x: " + still.x + " , y: " + still.y);
                            res = false;
                        }
                        else if(still instanceof Bomb) {
                            res = false;
                        }
                    }
                }
                break;
            case "down":
                for(int i = 0; i < BombermanGame.stillObjects.size(); i++) {
                    Entity still = BombermanGame.stillObjects.get(i);
                    if(round1(Math.abs(still.getX() - round1(object.getX()))) < space
                            && still.getY() - round1(object.getY()) > 0.7 && round1(still.getY() - object.getY()) <= round1(space)) {
                        if(still instanceof Wall || still instanceof Brick) {
                            //if(object instanceof Bomber)
                            //System.out.println(still.toString() + " x: " + still.x + " , y: " + still.y);
                            res = false;
                        }
                        else if(still instanceof Bomb) {
                            res = false;
                        }
                    }
                }
                break;
            case "left":
                for(int i = 0; i < BombermanGame.stillObjects.size(); i++) {
                    Entity still = BombermanGame.stillObjects.get(i);
                    if(round1(object.getX()) - still.getX() > 0.7 && round1(object.getX() - still.getX()) <= round1(space)
                            && round1(Math.abs(still.getY() - round1(object.getY()))) < space) {
                        if(still instanceof Wall || still instanceof Brick) {
                            //if(object instanceof Bomber) //System.out.println(still.toString() + " x: " + still.x + " , y: " + still.y);
                            res = false;
                        }
                        else if(still instanceof Bomb) {
                            res = false;
                        }
                    }
                }
                break;
            case "right":
                for(int i = 0; i < BombermanGame.stillObjects.size(); i++) {
                    Entity still = BombermanGame.stillObjects.get(i);
                    if(still.getX() - round1(object.getX()) > 0.7 && round1(still.getX() - object.getX()) <= round1(space)
                            && round1(Math.abs(still.getY() - round1(object.getY()))) < space) {
                        if(still instanceof Wall || still instanceof Brick) {
                            //if(object instanceof Bomber) System.out.println(still.toString() + " x: " + still.x + " , y: " + still.y);
                            res = false;
                        }
                        else if(still instanceof Bomb) {
                            res = false;
                        }
                    }
                }
                break;
            default:
                break;
        }
        //if(object instanceof Bomber) System.out.println(type);
        return res;
    }

    @Override
    public void update() { }

    @Override
    public void destroy() { }
}
