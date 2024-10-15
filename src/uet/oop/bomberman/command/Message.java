package uet.oop.bomberman.command;

import com.sun.javafx.cursor.CursorFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.net.URL;


public class Message {

    //Trạng thái lúc tạm dừng game
    public static Pane pause() {
        Pane res = new Pane();
        res.setPrefSize(BombermanGame.WIDTH * Sprite.SCALED_SIZE, BombermanGame.HEIGHT * Sprite.SCALED_SIZE);
        res.setOpacity(0.5);
        res.setStyle("-fx-background-color: black");
        Label pause = new Label("PAUSE");
        pause.setPrefSize(160, 80);
        pause.setTextFill(Paint.valueOf("WHITE"));
        pause.setFont(Font.font("Bomberman", FontWeight.LIGHT, FontPosture.REGULAR, 25));
        pause.relocate((res.getPrefWidth() - pause.getPrefWidth()) / 2,
                (res.getPrefHeight() - pause.getPrefHeight()) / 2);
        res.getChildren().add(pause);
        res.setVisible(false);
        return res;
    }
    //Trạng thái lúc thua
    public static Pane lose() {
        Pane res = new Pane();
        res.setPrefSize(BombermanGame.WIDTH * Sprite.SCALED_SIZE, BombermanGame.HEIGHT * Sprite.SCALED_SIZE);
        res.setStyle("-fx-background-color: rgba(42,48,57,0.99)");
        Label lose = new Label(" YOU LOSE ");
        lose.setPrefSize(160, 80);
        lose.setTextFill(Paint.valueOf("GHOSTWHITE"));
        lose.setFont(Font.font("Bomberman", FontWeight.MEDIUM, FontPosture.REGULAR, 25));
        lose.relocate((res.getPrefWidth() - lose.getPrefWidth()) / 2,
                (res.getPrefHeight() - lose.getPrefHeight()) / 2);
        Label press = new Label("Press [X] to restart!");
        press.relocate(lose.getLayoutX(), lose.getLayoutY() + lose.getPrefHeight());
        press.setTextFill(Paint.valueOf("YELLOW"));
        press.setFont(Font.font("System", 20));
        res.getChildren().add(lose);
        res.getChildren().add(press);
        return res;
    }
}
