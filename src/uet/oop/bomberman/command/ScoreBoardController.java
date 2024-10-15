package uet.oop.bomberman.command;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import uet.oop.bomberman.BombermanGame;

public class ScoreBoardController {

    @FXML
    AnchorPane scoreBoard;
    @FXML
    Label score, flame, bombs, speed, flamePassTime, invincibilityTime, level;
    @FXML
    HBox life;

    //
    void life_update() {
        life.getChildren().clear();
        for(int i = 0; i < BombermanGame.life; i++) {
            Image heart = new Image("sprites/heart.png", 32, 32, false, false);
            life.getChildren().add(new ImageView(heart));
        }
    }

    //cập nhật lại
    public void update() {
        this.score.setText(String.valueOf(BombermanGame.score));
        this.flame.setText(String.valueOf(BombermanGame.flame));
        this.bombs.setText(String.valueOf(BombermanGame.bombs));
        this.speed.setText(String.valueOf(BombermanGame.speed));
        level.setText("Level " + BombermanGame.level);
        life_update();
    }
}