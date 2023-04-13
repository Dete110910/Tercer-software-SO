package views;

import javax.swing.*;
import java.awt.*;

public class ButtonMenu extends JButton {
    public ButtonMenu(String text) {
        super(text);
        setBackground(Color.decode("#9a8c98"));
        setForeground(Color.WHITE);
        setFont(ConstantsGUI.FONT_MENU_ITEMS);
        setPreferredSize(new Dimension(280,40));
    }
}
