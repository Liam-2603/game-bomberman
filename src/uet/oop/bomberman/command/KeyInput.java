package uet.oop.bomberman.command;


import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.moveEntities.Bomber;
import uet.oop.bomberman.entities.moveEntities.Effect.FlamePassEffect;
import uet.oop.bomberman.entities.moveEntities.Effect.InvincibilityEffect;
import uet.oop.bomberman.entities.stillEntities.mortal.Brick;
import uet.oop.bomberman.entities.stillEntities.immortal.Grass;
import uet.oop.bomberman.graphics.Sprite;

public class KeyInput {
    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    public boolean space = false;
    public boolean enter = false;
    public boolean pause = false;

    public boolean admin = false;
    private String adminProcedure = "";

    public void adminProcedureHandle(char c) {
        adminProcedure += c;
        if(adminProcedure.length() == 3) {
            switch (adminProcedure) {
                //tăng sát thương bom khi nhặt item flame
                case "apf":
                    if(BombermanGame.flame != BombermanGame.MAX_FLAME) {
                        BombermanGame.flame++;
                        System.out.println("Power up flame: " + BombermanGame.flame);
                    } else System.out.println("Flame is max!");
                    break;
                //tăng tốc độ khi nhặt item speed
                case "aps":
                    if(!(BombermanGame.speed == BombermanGame.MAX_SPEED)) {
                        BombermanGame.speed++;
                        System.out.println("Power up speed: " + BombermanGame.speed);
                    } else {
                        System.out.println("Speed is too fast!");
                    }
                    break;
                //tăng số lượng bom tối đa có thể đặt
                case "apb":
                    if(BombermanGame.bombs != BombermanGame.MAX_BOMBS) {
                        BombermanGame.bombs++;
                        System.out.println("Power up bombs: " + BombermanGame.bombs);
                    } else System.out.println("Bombs is max!");
                    break;
                //nhặt item reset lại trạng thái ban đầu
                case "ars":
                    resetBomberStatus();
                    System.out.println("Bomber is reset");
                    break;
                //cho nổ những vật cản (xóa khỏi map)
                case "acb":
                    for(int i = 0; i < BombermanGame.stillObjects.size(); i++) {
                        if(BombermanGame.stillObjects.get(i) instanceof Brick) {
                            Brick temp = (Brick) BombermanGame.stillObjects.get(i);
                            BombermanGame.stillObjects.remove(temp);
                            BombermanGame.stillObjects.add(0, new Grass((int) Math.round(temp.getX()), (int) Math.round(temp.getY()), Sprite.grass.getFxImage()));
                        }
                    }
                    System.out.println("Bricks are cleared");
                    break;
                //bất từ khi nhặt được item invincibility
                case "acp":
                    if(!BombermanGame.getBomber().invincibility) {
                        BombermanGame.effects.add(new InvincibilityEffect(BombermanGame.getBomber().getX(), BombermanGame.getBomber().getY(), null));
                    }
                    BombermanGame.getBomber().invincibility = true;
                    BombermanGame.getBomber().invincibilityTime = 10000/16;
                    System.out.println("Bomber being invincibility...");
                    break;
                //sát thương bom trở về ban đầu
                case "afp":
                    if(BombermanGame.entities.get(BombermanGame.entities.size() - 1) instanceof Bomber) {
                        if(BombermanGame.getBomber().flamePass) {
                            BombermanGame.getBomber().flamePassRestart();
                        } else {
                            try {
                                BombermanGame.getBomber().flamePass = true;
                                BombermanGame.effects.add(
                                        new FlamePassEffect(BombermanGame.getBomber().getX(), BombermanGame.getBomber().getY(), null));
                            } catch (NullPointerException nullPointerException) {
                                System.out.println("Bomber cannot found!");
                            }
                        }
                        System.out.println("Flame-pass mode...");
                    }
                    break;
                //đặt bom nổ trúng kẻ địch
                case "ade":
                    BombermanGame.destroyEnemy();
                    System.out.println("Destroy enemies");
                    break;
                //tăng thêm 1 mạng khi nhặt item life
                case "adl":
                    if(BombermanGame.life < BombermanGame.MAX_LIFE) BombermanGame.life++;
                    System.out.println("Bomber +1 life");
                    break;
            }
            adminProcedure = "";
            admin = false;
        }
    }

    public void resetAdminProcedure() {
        this.adminProcedure = "";
    }

    //khởi động lại bảng Status
    public void resetBomberStatus() {
        BombermanGame.flame = 1;
        BombermanGame.speed = 1;
        BombermanGame.bombs = 1;
    }
}
