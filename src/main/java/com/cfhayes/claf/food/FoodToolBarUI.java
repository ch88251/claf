package com.cfhayes.claf.food;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.AbstractToolBarUI;

public class FoodToolBarUI extends AbstractToolBarUI {

    public static ComponentUI createUI(JComponent c) {
        return new FoodToolBarUI();
    }

    public Border getRolloverBorder() {
        return FoodBorders.getRolloverToolButtonBorder();
    }

    public Border getNonRolloverBorder() {
        return FoodBorders.getToolButtonBorder();
    }

    public boolean isButtonOpaque() {
        return true;
    }

    public void paint(Graphics g, JComponent c) {
        FoodUtils.fillComponent(g, c);
    }
}
