package GameMenu;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MenuItem extends StackPane {
    public MenuItem(String name){
        Rectangle bg = new Rectangle(200,20, Color.BLACK);
        bg.setOpacity(0.5);

        Text text = new Text(name);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial", FontWeight.NORMAL,14));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg,text);
        FillTransition st = new FillTransition(Duration.seconds(0.5),bg);
        setOnMouseEntered(event -> {
            st.setFromValue(Color.BLACK);
            st.setToValue(Color.WHITE);
            st.setCycleCount(Animation.INDEFINITE);
            st.setAutoReverse(true);
            st.play();
        });
        setOnMouseExited(event -> {
            st.stop();
            bg.setFill(Color.BLACK);
        });
    }
}