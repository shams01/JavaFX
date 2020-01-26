package GameMenu;

import javafx.scene.layout.VBox;

public class SubMenu extends VBox {
    public SubMenu(MenuItem...iteams){
        setSpacing(15);
        setTranslateY(250);
        setTranslateX(400);
        for(MenuItem item : iteams){
            getChildren().addAll(item);
        }
    }
}