package com.cfhayes.claf.food;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BasePanelUI;

public class FoodPanelUI extends BasePanelUI {

    private static FoodPanelUI panelUI = null;

    public static ComponentUI createUI(JComponent c) {
        if (panelUI == null) {
            panelUI = new FoodPanelUI();
        }
        return panelUI;
    }

    public void update(Graphics g, JComponent c) {
        if (c.getBackground() instanceof ColorUIResource) {
            if (c.isOpaque()) {
                FoodUtils.fillComponent(g, c);
            }
        } else {
            super.update(g, c);
        }
    }
}
