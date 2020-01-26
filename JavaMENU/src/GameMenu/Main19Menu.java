package GameMenu;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.xml.soap.Text;
import java.awt.*;

public class Main19Menu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        Image image = new Image(getClass().getResourceAsStream("kurt.jpg"));
        ImageView img = new ImageView(image);
        img.setFitHeight(500);
        img.setFitWidth(400);
        root.getChildren().add(img);

        MenuItem newGame = new MenuItem("НОВАЯ ИГРА");
        MenuItem options = new MenuItem("НАСТРОЙКИ");
        MenuItem avtor = new MenuItem("РАЗРАБОТЧИК");
        MenuItem exitGame = new MenuItem("ВЫХОД");
        SubMenu mainMenu = new SubMenu(newGame,options,avtor,exitGame);

        MenuItem sound = new MenuItem("ЗВУК");
        MenuItem video = new MenuItem("ВИДЕО");
        MenuItem keys = new MenuItem("УПРАВЛЕНИЕ");
        MenuItem optionsBack = new MenuItem("НАЗАД");
        SubMenu optionsMenu = new SubMenu(sound,video,keys,optionsBack);

        MenuItem NG1 = new MenuItem("ТУРНИР");
        MenuItem NG2 = new MenuItem("ОДИН БОЙ");
        MenuItem NG3 = new MenuItem("2 ИГРОКА");
        MenuItem NG4 = new MenuItem("НАЗАД");
        SubMenu newGameMenu = new SubMenu(NG1,NG2,NG3,NG4);

        MenuItem avtorM = new MenuItem("ssheikhgasanov@gmail.com");
        MenuItem back = new MenuItem("НАЗАД");
        SubMenu avtorMenu = new SubMenu(avtorM,back);


        MenuBox menuBox = new MenuBox(mainMenu);

        newGame.setOnMouseClicked(event -> menuBox.setSubMenu(newGameMenu));
        options.setOnMouseClicked(event -> menuBox.setSubMenu(optionsMenu));
        avtor.setOnMouseClicked(event -> menuBox.setSubMenu(avtorMenu));
        back.setOnMouseClicked(event -> menuBox.setSubMenu(mainMenu));
        exitGame.setOnMouseClicked(event -> System.exit(0));
        optionsBack.setOnMouseClicked(event -> menuBox.setSubMenu(mainMenu));
        NG4.setOnMouseClicked(event -> menuBox.setSubMenu(mainMenu));
        root.getChildren().addAll(menuBox);

        Scene scene = new Scene(root, 600,500);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE){
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
                if(!menuBox.isVisible()){
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                } else {
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(event1 -> menuBox.setVisible(false));
                    ft.play();
                }
            }
        });

        primaryStage.setTitle("Pause");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}