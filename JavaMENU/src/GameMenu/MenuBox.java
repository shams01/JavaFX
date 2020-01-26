package GameMenu;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuBox extends Pane {
    SubMenu subMenu;
    public MenuBox(SubMenu subMenus){
        subMenu = subMenus;
        setVisible(false);
        Rectangle bg = new Rectangle(600,500, Color.LIGHTBLUE);
        bg.setOpacity(0.4);
        getChildren().addAll(bg, subMenu);
    }
    public void setSubMenu(SubMenu subMenus){
        getChildren().remove(subMenu);
        subMenu = subMenus;
        getChildren().add(subMenu);
    }
}